<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html"%>

<c:choose>
    <c:when test="${not empty sessionScope.login}">
        ようこそ、${sessionScope.login.name}さん！
    </c:when>
    <c:otherwise>
        <c:redirect url="/jsp/login.jsp" />
    </c:otherwise>
</c:choose>

<%@include file="../footer.html"%>