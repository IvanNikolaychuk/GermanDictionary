<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Training</title>
    <meta charset="utf-8">

    <link href="../static/css/bootstrap-theme.css" rel="stylesheet"/>
    <link href="../static/css/bootstrap.css" rel="stylesheet"/>
    <link href="../static/css/helper-chars.css" rel="stylesheet"/>
    <link href="../static/css/training.css" rel="stylesheet"/>

    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="../static/js/helper-chars.js"></script>
    <script src="../static/js/bootstrap.js"></script>
    <script src="../static/js/training.js"></script>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:700' rel='stylesheet' type='text/css'>
</head>
<body>
<jsp:include page="header.jsp"/>

<main>

    <div id="container">
        <div class="helper-chars">
            <div class="char">ü</div>
            <div class="char">ö</div>
            <div class="char">ä</div>
            <div class="char">ß</div>
        </div>
        <input class="rus-field" type="text" disabled>
        <br>
        <br>
        <input class="ger-field" type="text">
        <br>
        <br>
        <input type="button" class="btn answer-btn" value="Answer">
        <input type="button" class="btn help-btn" value="Help">
    </div>
    <input type="button" class="btn home-btn" value="Home">
</main>
</body>
</html>
