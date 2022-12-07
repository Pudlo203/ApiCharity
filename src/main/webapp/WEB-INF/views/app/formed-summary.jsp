
<%--
  Created by IntelliJ IDEA.
  User: ph
  Date: 05.12.2022
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <%@ include file="/WEB-INF/views/fragments/meta.jsp" %>
    <title>Podsumowanie</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header class="header--form-page">
    <%@ include file="/WEB-INF/views/fragments/header.jsp" %>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Oddaj rzeczy, których już nie chcesz<br />
                <span class="uppercase">potrzebującym</span>
            </h1>

            <div class="slogan--steps">
                <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
                <ul class="slogan--steps-boxes">
                    <li>
                        <div><em>1</em><span>Wybierz rzeczy</span></div>
                    </li>
                    <li>
                        <div><em>2</em><span>Spakuj je w worki</span></div>
                    </li>
                    <li>
                        <div><em>3</em><span>Wybierz fundację</span></div>
                    </li>
                    <li>
                        <div><em>4</em><span>Zamów kuriera</span></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>


    <!-- STEP 6 -->
    <div data-step="5" class="active">
        <h3>Podsumowanie Twojej darowizny</h3>
        <div class="summary">
            <div class="form-section">
                <h4>Oddajesz:</h4>
                <ul>
                    <li>
<%--                        <c:if test="${not empty donation}">--%>
                        <span class="icon icon-bag"></span>
                        <span id="quantity" class="summary--text">
                                     Ilość worków: ${donation.quantity} <br>
                                     Kategorie:
                                    <c:forEach var="category" items="${donation.categories}">
                                        ${category.name},
                                    </c:forEach>
                                </span>
                    </li>

                    <li>
                        <span class="icon icon-hand"></span>
                        <span id="institution" class="summary--text">
                                    Dla: ${donation.institution.name}
                                </span>
                    </li>
                </ul>
            </div>

            <div class="form-section form-section--columns">
                <div class="form-section--column">
                    <h4>Adres odbioru:</h4>
                    <ul>
                        <li id="where1">${donation.street}</li>
                        <li id="where2">${donation.city}</li>
                        <li id="where3">${donation.zipCode}</li>
                        <li id="where4">tel.: ${donation.phone}</li>
                    </ul>
                </div>

                <div class="form-section--column">
                    <h4>Termin odbioru:</h4>
                    <ul>
                        <li id="when1">${donation.pickUpDate}</li>
                        <li id="when2">${donation.pickUpTime}</li>
                        <li id="when3">${donation.pickUpComment}</li>
<%--                        </c:if>--%>
                    </ul>
                </div>
            </div>
        </div>

        <div class="form-group form-group--buttons">
            <a href="<c:url value="/donation/form"/>" class="btn">Wstecz</a>
<%--            <button type="button" class="btn prev-step">Wstecz</button>--%>
    <a href="<c:url value="/donation/confirm"/>" class="btn">Potwierdzam</a>
<%--            <button type="submit" class="btn">Potwierdzam</button>--%>
        </div>
    </div>
    </div>
</section>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/footer.jsp"/>
