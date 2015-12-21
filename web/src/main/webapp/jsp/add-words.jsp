<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <link href="../static/css/basic.css" rel="stylesheet"/>
    <link href="../static/css/add-words.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Playfair+Display' rel='stylesheet' type='text/css'>
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="../static/js/add-words.js"></script>
</head>
<body>
<div id="add-words-panel">
    <label>
        <div class="title">German</div>
        <input type="text" class="ger-word" name="ger-word">
    </label>

    <label>
        <div class="title">Russian</div>
        <input type="text" class="rus-word" name="rus-word">
    </label>

    <br>

    <input id="add-words-btn" type="submit" value="Add">

    <br/>
    <button class="btn home-btn">
        <a href="${pageContext.request.contextPath}/home">Home</a>
    </button>
</div>
</body>
</html>
