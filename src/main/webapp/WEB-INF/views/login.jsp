<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ph
  Date: 28.11.2022
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
  <%@ include file="/WEB-INF/views/fragments/meta.jsp" %>
  <title>Logowanie</title>
  <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header>
  <%@ include file="/WEB-INF/views/fragments/header.jsp" %>
</header>

<section class="login-page">
  <h2>Zaloguj się</h2>

  <form method="post" modelAttribute="user">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="form-group">
      <input  path="email" type="email" name="username" placeholder="Email" />
    </div>
    <div class="form-group">
      <input path="password" type="password" name="password" placeholder="Hasło" />
      <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
    </div>

    <div class="form-group form-group--buttons">
      <a href="<c:url value="/register"/>" class="btn btn--without-border">Załóż konto</a>
      <button class="btn" type="submit">Zaloguj się</button>
    </div>
  </form>
</section>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/footer.jsp"/>
