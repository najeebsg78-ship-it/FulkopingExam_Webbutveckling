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

<h1>Ändra konto</h1>
<form action= "${pageContext.request.contextPath}/Account" method="post">

  <c:if test="${not empty error}">
    <div class="alert alert-danger">
      <c:out value="${error}" />
    </div>
  </c:if>

  <c:if test="${not empty message}">
    <div class="alert alert-success">
      <c:out value="${message}" />
    </div>
  </c:if>

  <div class="mb-3">
    <label for="username" class="form-label">Username</label>
    <input type="text" class="form-control" id="username" name="username"
           value="${username}" required>
  </div>

  <br>
  <div class="mb-3">
    <label for="password" class="form-label">Password</label>
    <input type="password" class="form-control" id="password" name="password" required>
  </div>

  <div style="margin-top: 15px;">
    <button type="submit" class="btn btn-primary">Login</button>
    <a href="${pageContext.request.contextPath}/register" class="btn btn-secondary">Registera</a>
  </div>


</form>

</body>
</html>

