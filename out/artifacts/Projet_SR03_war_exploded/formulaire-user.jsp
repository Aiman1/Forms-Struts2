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
    <title>Création d'utillisateurs</title>
</head>
<body>
<s:form action="createUserAction">
    <label> First name </label>
    <input type="text" id="frname" name="User first name" />
    <br>
    <label> Family name </label>
    <input type="text" id="faname" name="User family name" />
    <br>
    <label> Email </label>
    <input type="email" id="email" name="User email" />
    <br>
    <label> Password </label>
    <input type="password" id="psw" name="User password" />
    <br>
    <label> male </label>
    <input type="radio" id="male" name="gender" value="male" checked/>
    <br>
    <label> female </label>
    <input type="radio" id="female" name="gender" value="female" />
    <br>
    <s:submit value="envoyer"/>
</s:form>
</body>
</html>