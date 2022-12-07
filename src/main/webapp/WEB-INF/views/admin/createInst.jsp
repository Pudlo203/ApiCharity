<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ph
  Date: 07.12.2022
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Lista organizacji</title>
</head>
<header>
    <nav class="navbar navbar-expand-lg bg-light">

        <h1> Dodaj instytucje</h1>
    </nav>
</header>
<div>
    <br><br><br><br><br>
</div>
<form:form method="post" modelAttribute="institution">
<div class="form-group">
    <fieldset class="form-label-group">
        <form:label for="name" path="name">Nazwa</form:label>
        <form:input path="name" type="text" id="name" class="form-control" required="required" autofocus="autofocus"/>
        <form:errors path="name" cssStyle="color: red" element="div"/>
    </fieldset>

</div>
<div class="form-group">
    <div class="form-label-group">
        <form:label for="description" path="description">Opis</form:label>
        <form:input path="description" type="text" id="description" name="description" class="form-control" placeholder="Opis" required="required" autofocus="autofocus"/>
        <form:errors path="description" cssStyle="color: red" element="div"/>
        <br>
    </div>
    <input type="submit" class="btn btn-primary btn-block" value="Dodaj"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form:form>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</div>
</html>