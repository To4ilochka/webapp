<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sign in Page</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/sign_in" method="POST">
  <table>
    <tr>
      <td>Login:</td>
      <td><input type="text" name="login"/></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type="text" name="password"/></td>
    </tr>
  </table>
  <hr/>
  <a href="${pageContext.request.contextPath}/jsp/log_in.jsp">Go to log in page</a>
  <br/>
  <input type="submit" value="Sign in"/>
</form>
<c:if test="${not empty loginAlreadyTaken}">
  <p style="color: red;">${loginAlreadyTaken}</p>
</c:if>
<c:if test="${not empty sign_in_success}">
  <p style="color: green;">${sign_in_success}</p>
</c:if>
</body>
</html>