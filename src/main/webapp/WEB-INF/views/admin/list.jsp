<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ph
  Date: 07.12.2022
  Time: 10:43
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

        <h1> Organizacje, użytkownicy, dotacje</h1>
<%--        <h2> Witaj ${users.email}</h2>--%>
    </nav>
</header>
<div>
    <br><br><br><br>
</div>
<a href="/" class="btn btn-warning rounded-0 text-light m-1">Wróć do strony głównej </a>
<br>
<a href="/admin/createInst"
   class="btn btn-info rounded-0 text-light m-1">Dodaj organizacje</a>
<div>
    <br><br><br><br>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Fundacja:</th>
        <th scope="col">Cel i misja</th>
        <%--        <th scope="col">Dotacje</th>--%>
        <th scope="col">Edytuj organizacje</th>
        <th scope="col">Usuń organizacje</th>
    </tr>
    </thead>
    <tbody class="table-group-diver">
    <c:forEach var="inst" items="${institutions}" varStatus="i">
    <tr>
        <td>${inst.name}</td>
        <td>${inst.description}</td>
        <td>
            <a href="/admin/editInst?id=${inst.id}"
               class="btn btn-info rounded-0 text-light m-1">Edytuj</a>
        </td>
        <td>
            <a href="/admin/deleteInst?id=${inst.id}"
               class="btn btn-info rounded-0 text-light m-1"
               onclick="return confirm('Czy na pewno chcesz usunąć instytucję')">Usuń</a>
        </td>
        </c:forEach>
    </tr>
    </tbody>
</table>
<div>
    <br><br><br><br>
</div>
<table class="table">
    <thead>
    <th>Email</th>
    <th>Funkcja</th>
    <%--    <th>imię</th>--%>
    <%--    <th>nazwisko</th>--%>
    <th>Edytuj użytkownika</th>
    <th>Usuń użytkownika</th>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="users">
        <tr>
            <td><c:out value="${users.email}"/></td>
            <td><c:out value="${users.enabled}"/></td>
                <%--            <td><c:out value="${users.firstName}"/></td>--%>
                <%--            <td><c:out value="${users.lastName}"/></td>--%>
            <td>
                <a href="/admin/editUser?id=${users.id}"
                   class="btn btn-info rounded-0 text-light m-1">Edytuj</a>
            </td>
            <td>
                <a href="/admin/deleteUser?id=${users.id}"
                   class="btn btn-info rounded-0 text-light m-1"
                   onclick="return confirm('Czy na pewno chcesz usunąć użytkownika?')">Usuń</a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
<div>
    <br><br><br><br>
</div>
<table class="table">
    <thead>
    <th>Ilość worków:</th>
    <th>Kategorie:</th>
    <th>Instytucja:</th>
    <th>Ulica:</th>
    <th>Miasto:</th>
    <th>Kod pocztowy:</th>
    <th>Telefon:</th>
    <th>Data odbioru:</th>
    <th>Godzina odbioru:</th>
    <th>Komentarz:</th>

    </thead>
    <tbody>
    <c:forEach items="${donations}" var="donation">
        <tr>
            <td><c:out value="${donation.quantity}"/></td>
            <td>
                <c:forEach var="category" items="${donation.categories}">
                    ${category.name},
                </c:forEach>
            </td>
            <td><c:out value="${donation.institution.name}"/></td>
            <td><c:out value="${donation.street}"/></td>
            <td><c:out value="${donation.city}"/></td>
            <td><c:out value="${donation.zipCode}"/></td>
            <td><c:out value="${donation.phone}"/></td>
            <td><c:out value="${donation.pickUpDate}"/></td>
            <td><c:out value="${donation.pickUpTime}"/></td>
            <td><c:out value="${donation.pickUpComment}"/></td>

            <td>
                <a href="/admin/editDonation?id=${donation.id}"
                   class="btn btn-info rounded-0 text-light m-1">Edytuj</a>
            </td>
<%--            <td>--%>
<%--                <a href="/admin/deleteUser?id=${users.id}"--%>
<%--                   class="btn btn-info rounded-0 text-light m-1"--%>
<%--                   onclick="return confirm('Czy na pewno chcesz usunąć użytkownika?')">Usuń</a>--%>
<%--            </td>--%>

        </tr>
    </c:forEach>
    </tbody>
</table>
<div>
    <br><br><br><br>
</div>
<a href="/admin/createCategory"
   class="btn btn-info rounded-0 text-light m-1">Dodaj kategorie</a>
<br>
<table class="table">
    <thead>
    <th>Nazwa</th>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td><c:out value="${category.name}"/></td>
<%--            <td>--%>
<%--                <a href="/admin/editUser?id=${users.id}"--%>
<%--                   class="btn btn-info rounded-0 text-light m-1">Edytuj</a>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <a href="/admin/deleteUser?id=${users.id}"--%>
<%--                   class="btn btn-info rounded-0 text-light m-1"--%>
<%--                   onclick="return confirm('Czy na pewno chcesz usunąć użytkownika?')">Usuń</a>--%>
<%--            </td>--%>

        </tr>
    </c:forEach>
    </tbody>
</table>


<div>
    <br><br><br><br>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>