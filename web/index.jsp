<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: oxygene
  Date: 14/05/19
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
</head>
<body>
<s:form action="SignIn">
  <label> Email </label>
  <input type="email" id="email" name="compte.email" />
  <br>
  <label> Password </label>
  <input type="password" id="mdp" name="compte.mdp" />
  <br>
  <s:submit value="envoyer"/>
</s:form>
</body>
</html>