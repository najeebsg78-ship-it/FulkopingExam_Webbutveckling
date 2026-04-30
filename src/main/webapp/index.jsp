<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Document</title>
</head>
<body class="mt-5 text-center">

    <div class="py-5">
        <h1 class="display-4">Välkommen till Fulköping Biblotek</h1>
        <p class="lead">Logga in eller skapa nytt konto</p>

        <div class="mt-4">
            <a href="${pageContext.request.contextPath}/login" class="btn btn-primary btn-lg px-4 gap-3">Logga in</a>
            <a href="${pageContext.request.contextPath}/register" class="btn btn-outline-secondary btn-lg px-4">Skapa konto</a>
        </div>
    </div>

</body>
</html>