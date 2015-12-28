<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <link href="../static/css/bootstrap-theme.css" rel="stylesheet"/>
    <link href="../static/css/bootstrap.css" rel="stylesheet"/>
    <link href="../static/css/words.css" rel="stylesheet"/>
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="../static/js/bootstrap.js"></script>
    <script src="../static/js/words.js"></script>
    <title>Words</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<main>

    <div class="wrapper">
        <input type="text" class="ger-field" name="ger-word" placeholder="German word...">
        <input type="text" class="rus-field" name="rus-word" placeholder="Russian word...">

        <div class="icon add-icon" id="add-words-btn"></div>
    </div>

    <div id="container">
        <c:forEach items="${requestScope.units}" var="unit">
            <div class="pair">
                <span class="word ger-word">${unit.wordPair.germanWord.value}</span>
                <span class="dash">-</span>
                <span class="word rus-word"> ${unit.wordPair.russianWord.value}</span>
            </div>
        </c:forEach>
        <input class="btn home-btn" type="button" value="Home">
        <input class="btn delete-btn" type="button" value="Delete">
    </div>
</main>

<jsp:include page="footer.jsp"/>
</body>
</html>
