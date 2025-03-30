<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Log in Page</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/log_in" method="POST">
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
  <a href="${pageContext.request.contextPath}/jsp/sign_in.jsp">Go to sign in page</a>
  <br/>
  <input type="submit" value="Log in"/>
</form>
<c:if test="${not empty errorMessage}">
  <p style="color: red;">${errorMessage}</p>
</c:if>
</body>
</html>
