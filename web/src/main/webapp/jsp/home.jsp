<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link href="../static/css/bootstrap-theme.css" rel="stylesheet"/>
    <link href="../static/css/bootstrap.css" rel="stylesheet"/>
    <script href="../static/js/bootstrap.js"></script>
    <link href="../static/css/home.css" rel="stylesheet"/>
    <title>Home</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <div id="container">
        <div class="item">
            <div class="icon dictionary-icon"></div>
        </div>
        <div class="item">
            <div class="icon learn-icon"></div>
        </div>
        <div class="item">
            <div class="icon settings-icon"></div>
        </div>
    </div>
</main>

<jsp:include page="footer.jsp"/>
</body>
</html>
