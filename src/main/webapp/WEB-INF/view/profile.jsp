<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="sv">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container mt-5">

    <h1>Din Profil</h1>
    <p>Förnamn: <c:out value="${user.firstname}"></c:out></p>
    <p>Efternamn: <c:out value="${user.lastname}"></c:out></p>
    <p>Country: <c:out value="${user.country}"></c:out></p>
    <p>Adress: <c:out value="${user.adress}"></c:out></p>



</body>
</html>

