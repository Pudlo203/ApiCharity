<%--
  Created by IntelliJ IDEA.
  User: ph
  Date: 28.11.2022
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="<c:url value="/login"/>" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="<c:url value="/register"/>" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </ul>

        <ul>
            <li><a href="<c:url value="/"/>" class="btn btn--without-border active">Start</a></li>
            <li><a href="<c:url value="/#steps"/>" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="<c:url value="/#about-us"/>" class="btn btn--without-border">O nas</a></li>
            <li><a href="<c:url value="/admin/list"/>" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="<c:url value="/donation/form"/>" class="btn btn--without-border">Przekaż dary</a></li>
            <li><a href="<c:url value="/#contact"/>" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>