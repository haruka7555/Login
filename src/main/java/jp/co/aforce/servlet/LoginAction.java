package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.beans.Customer;
import jp.co.aforce.dao.CustomerDAO;
import jp.co.aforce.tool.Action;

public class LoginAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession();

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		CustomerDAO dao = new CustomerDAO();
		Customer customer = dao.search(email, password);

		if (customer != null) {
			session.setAttribute("customer", customer);
			return "login-out.jsp";
		}
		return "login.jsp";
	}
}