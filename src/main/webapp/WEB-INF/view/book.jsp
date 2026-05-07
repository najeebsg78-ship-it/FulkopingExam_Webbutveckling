
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

<h2><c:out value="${book.title}"/></h2>

<table class="table">
    <tr><th>Författare</th><td><c:out value="${book.author}"/></td></tr>
    <tr><th>Kategori</th><td><c:out value="${book.category}"/></td></tr>
    <tr>
        <th>Status</th>
        <td>
            <c:choose>
                <c:when test="${activeLoan == null}">
                    <span class="badge bg-success">Tillgänglig</span>
                </c:when>
                <c:otherwise>
                    <span class="badge bg-danger">Utlånad - återlämnas: ${activeLoan.endDate}</span>
                </c:otherwise>

            </c:choose>

        </td>

    </tr>
</table>

<c:choose>
    <c:when test="${activeLoan == null}">
        <form action="${pageContext.request.contextPath}/loan" method="post">
            <input type="hidden" name="bookId" value="${book.bookId}">
            <input type="hidden" name="action" value="borrow">
            <button type="submit" class="btn btn-primary">Låna bok</button>
        </form>
    </c:when>
    <c:otherwise>
        <form action="${pageContext.request.contextPath}/loan" method="post">
            <input type="hidden" name="bookId" value="${book.bookId}">
            <input type="hidden" name="action" value="return">
            <button type="submit" class="btn btn-danger">Lämna tillbaka</button>
        </form>
    </c:otherwise>
</c:choose>

<div style="margin-top: 15px">
    <a href="${pageContext.request.contextPath}/home" class="btn btn-primary">Back</a>
</div>


</body>
</html>

