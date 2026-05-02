<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
                        <td><c:out value="${book.title}"></c:out></td>
                        <td><c:out value="${book.author}"></c:out></td>
                        <td><c:out value="${book.category}"></c:out></td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>
    </c:otherwise>

</c:choose>