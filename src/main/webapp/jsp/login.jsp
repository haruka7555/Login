<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.html"%>

<form action="Login.action" method="post">
	<p>ID(email) : <input type="text" name="email"></p>
	<p>password : <input type="password" name="password"></p>
	<p><input type="submit" value="ログイン"></p>
</form>

<%@include file="../footer.html"%>