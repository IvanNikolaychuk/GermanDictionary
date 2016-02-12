<jsp:useBean id="numberOfCorrectAnswersForDeletingUnit" scope="request" type="java.lang.Integer"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
    <meta charset="utf-8">

    <link href="../static/css/bootstrap-theme.css" rel="stylesheet"/>
    <link href="../static/css/bootstrap.css" rel="stylesheet"/>
    <link href="../static/css/basic.css" rel="stylesheet"/>
    <link href="../static/css/settings.css" rel="stylesheet"/>

    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="../static/js/bootstrap.js"></script>
    <script src="../static/js/settings.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <div class="container">
        <div class="help-text">
            <label>
            The world would be deleted after I don't make mistakes in it
                <input type="text" class="input-val" value="${numberOfCorrectAnswersForDeletingUnit}">
            times in a row.
            </label>
        </div>
        <input type="button" class="btn apply-btn" value="Apply">
        <input type="button" class="btn home-btn" value="Home">
    </div>
</main>
</body>
</html>
