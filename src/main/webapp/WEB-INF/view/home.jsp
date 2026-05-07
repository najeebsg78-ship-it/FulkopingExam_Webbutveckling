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
        <h1 class="display-4">Du är inloggad, Välkommen</h1>
        <p class="lead">Logga ut, ändra konto eller söka efter...</p>
    
        <div class="mt-4">
            <a href="${pageContext.request.contextPath}/login?logout=true" class="btn btn-primary btn-lg px-4 gap-3">Logga ut</a>
            <a href="${pageContext.request.contextPath}/account?editId=1" class="btn btn-outline-secondary btn-lg px-4">Ändra konto</a>
            <a href="${pageContext.request.contextPath}/account?editId=1" class="btn btn-outline-secondary btn-lg px-4">Ditt Profil</a>
            <a href="${pageContext.request.contextPath}/history" class="btn btn-outline-secondary btn-lg px-4">Historik</a>
        </div>
    </div>


    <form action="${pageContext.request.contextPath}/search" method="get"  class="d-flex justify-content-center gap-2 mt-3">
        <input type="text" name="q" placeholder="Sök böcker ..." value="${searchText}" class="form-control " style="max-width: 400px">
        <button type="submit" class="btn btn-primary mt-2">Sök</button>
    </form>

</body>
</html>