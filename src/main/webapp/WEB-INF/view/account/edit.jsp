<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="sv">
<head>
    <meta charset="UTF-8">
    <title>Edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container mt-5">

<h1>Ändra Konto</h1>
<form action= "${pageContext.request.contextPath}/account" method="post">

    <input type="hidden" name="id" value="${account.id}">
    <div class="mb-3">
        <label for="firstname" class="form-label">Firstname</label>
        <input type="text" class="form-label" id="firstname" name="firstname" value="${account.firstname}">
    </div>

    <div class="mb-3">
        <label for="lastname" class="form-label">Lastname</label>
        <input type="text" class="form-label" id="lastname" name="lastname" value="${account.lastname}">
    </div>

    <div class="mb-3">
        <label for="address" class="form-label">Address</label>
        <input type="text" class="form-label" id="address" name="address" value="${account.address}">
    </div>

    <div class="mb-3">
        <label for="country" class="form-label">Country</label>
        <input type="text" class="form-label" id="country" name="country" value="${account.country}">
    </div>

    <div style="margin-top: 15px;">
        <button type="submit" class="btn btn-primary">Save</button>
        <a href="${pageContext.request.contextPath}/account?getId" class="btn btn-secondary">Cancel</a>
    </div>


</form>

</body>
</html>

