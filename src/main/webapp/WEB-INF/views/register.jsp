<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ph
  Date: 28.11.2022
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <%@ include file="/WEB-INF/views/fragments/meta.jsp" %>
    <title>Rejestracja</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/views/fragments/header.jsp" %>
</header>

<section class="login-page">
    <h2>Załóż konto</h2>

    <form:form method="post" modelAttribute="registerDto">
        <div class="form-group">
            <form:input  path="email" type="email" name="email" placeholder="Email" />
        </div>
        <div class="form-group">
            <form:input  path="password" type="password" name="password" placeholder="Hasło" />
        </div>
        <div class="form-group">
            <input type="password" name="confirmPassword" placeholder="Powtórz hasło" />
        </div>

        <div class="form-group form-group--buttons">
            <a href="<c:url value="/login"/>" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/footer.jsp"/>