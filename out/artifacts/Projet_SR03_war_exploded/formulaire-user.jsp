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
    <label> last name </label>
    <input type="text" id="frname" name="Stagiaire.family_name" />
    <br>
    <label> first name </label>
    <input type="text" id="faname" name="Stagiaire.first_name" />
    <br>
    <label> tel </label>
    <input type="email" id="email" name="Stagiaire.tel" />
    <br>
    <label> Société </label>
    <input type="password" id="psw" name="Stagiaire.societe" />
    <br>
    <label> male </label>
    <input type="radio" id="male" name="Stagiaire.gender" value="male" checked/>
    <br>
    <label> female </label>
    <input type="radio" id="female" name="Stagiaire.gender" value="female" />
    <br>
    <s:submit value="envoyer"/>
</s:form>
</body>
</html>