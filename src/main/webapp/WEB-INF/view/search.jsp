
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="sv">
<head>
    <meta charset="UTF-8">
    <title>Sökresultat</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container mt-5">

<h2>Sökresultat: <c:out value="${searchText}"></c:out></h2>

<c:choose>
    <c:when test="${empty books}">
        <p>Inga böcker hittades</p>
    </c:when>

    <c:otherwise>
        <table class="table mt-3">
            <thead>
            <tr><th>Titel</th><th>Författare</th><th>Kategori</th></tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/book?id=${book.bookId}" >
                        <c:out value="${book.title}"></c:out>
                        </a>
                    </td>

                    <td><c:out value="${book.author}"></c:out></td>
                    <td><c:out value="${book.category}"></c:out></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </c:otherwise>

</c:choose>

<a href="${pageContext.request.contextPath}/" class="btn btn-secondary mt-3">Tillbaka</a>

</body>
</html>

