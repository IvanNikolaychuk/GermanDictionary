<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <link href="../static/css/basic.css" rel="stylesheet"/>
    <link href="../static/css/words.css" rel="stylesheet"/>
    <title>All Words</title>
</head>
<body>
<div id="words">
    <c:forEach items="${requestScope.units}" var="unit">
        <div class="unit">
            <div class="word ger-word">
                    ${unit.wordPair.germanWord.value}
            </div>
            -
            <div class="word rus-word">
                    ${unit.wordPair.russianWord.value}
            </div>
        </div>
    </c:forEach>
    <br>

    <button class="btn home-btn">
        <a href="home">Home</a>
    </button>

</div>
</body>
</html>
