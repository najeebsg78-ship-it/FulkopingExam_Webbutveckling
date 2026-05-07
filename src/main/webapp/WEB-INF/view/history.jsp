<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="sv">
<head>
    <meta charset="UTF-8">
    <title>Historik</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

<h2>Lånehistorik</h2>

<c:choose>
    <c:when test="${empty loans}">
        <p>Inga lån hittades.</p>
    </c:when>
    <c:otherwise>
        <table class="table mt-3">
            <thead>
            <tr>
                <th>Bok ID</th>
                <th>Startdatum</th>
                <th>Slutdatum</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="loan" items="${loans}">
                <tr>
                    <td><c:out value="${loan.bookId}"/></td>
                    <td><c:out value="${loan.startDate}"/></td>
                    <td><c:out value="${loan.endDate}"/></td>
                    <td>
                        <c:choose>
                            <c:when test="${loan.endDate == null}">
                                <span class="badge bg-warning">Aktiv</span>
                            </c:when>
                            <c:otherwise>
                                <span class="badge bg-secondary">Återlämnad</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

<a href="${pageContext.request.contextPath}/home" class="btn btn-secondary mt-3">Tillbaka</a>

</body>
</html>