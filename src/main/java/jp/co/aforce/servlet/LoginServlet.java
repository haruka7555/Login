package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.bean.Login;
import jp.co.aforce.dao.LoginDAO;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		session.invalidate();
        session = request.getSession(true);

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		LoginDAO dao = new LoginDAO();
		Login login;

		try {
			login = dao.search(name, email, password);
			if(login != null) {
				session.setAttribute("login", login);
				request.getRequestDispatcher("/jsp/login-out.jsp").forward(request, response);
			}else {
				session.setAttribute("error", "IDもしくはパスワードが違います。");
				response.sendRedirect("/Login/jsp/login.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}