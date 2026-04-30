<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="sv">
<head>
    <meta charset="UTF-8">
    <title>Registera</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container mt-5">
<h1>Registera konto</h1>

<% if (request.getAttribute("error") != null){ %>
<p style="color: red"><%= request.getAttribute("error")%></p>
<% } %>

<% if (request.getAttribute("success") != null){ %>
<p style="color: green"><%= request.getAttribute("success")%></p>
<p><a href="<%= request.getContextPath() %>/login"></a>Gå till login</p>
<% } else { %>

<form action="<%= request.getContextPath() %>/register" method="post">

    <div class="mb-3">
        <label for="username" class="form-label">Användarnamn</label><br>
        <input id="username" type="text" name="username" class="form-control"
               value="<%= request.getAttribute("username") != null ? request.getAttribute("username") : "" %>">
    </div>

    <div class="mb-3">
        <label for="password1" class="form-label" >Lösenord</label><br>
        <input id="password1" type="password" name="password1" class="form-control">
    </div>

    <div class="mb-3">
        <label for="password2" class="form-label">Upprepa Lösenord</label><br>
        <input id="password2" type="password" name="password2" class="form-control">
    </div>

    <div class="mb-4">
        <button type="submit" class="btn btn-primary" >Registera</button>
        <a href="<%= request.getContextPath() %>/login" class="btn btn-outline-secondary">Tillbaka</a>
    </div>
</form>

<% } %>

</body>
</html>

