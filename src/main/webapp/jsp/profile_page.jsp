<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<html>
<head>
    <title>Profile page</title>
</head>
<body>
    <ctg:repeat times="5">
        <p>Hi!, ${user}!</p>
    </ctg:repeat>
</body>
</html>
