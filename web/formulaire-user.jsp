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
    <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Roboto:300,300italic,700,700italic">
    <link rel="stylesheet" href="//cdn.rawgit.com/necolas/normalize.css/master/normalize.css">
    <link rel="stylesheet" href="//cdn.rawgit.com/milligram/milligram/master/dist/milligram.min.css">
    <title>Création d'utillisateurs</title>
</head>
<body>

<s:form action="createUserAction">
    <label> email </label>
    <input type="email" id="female" name="stagiaire.compte.email" value="email" />
    <br>
    <label> password </label>
    <input type="password" id="female" name="stagiaire.compte.mdp" value="password" />
    <br>
    <label> last name </label>
    <input type="text" id="frname" name="stagiaire.family_name" />
    <br>
    <label> first name </label>
    <input type="text" id="faname" name="stagiaire.first_name" />
    <br>
    <label> tel </label>
    <input type="text" id="text" name="stagiaire.tel" />
    <br>
    <label> Société </label>
    <input type="text" id="psw" name="stagiaire.societe" />
    <br>
    <label> male </label>
    <input type="radio" id="male" name="stagiaire.gender" value="male" checked/>
    <br>
    <label> female </label>
    <input type="radio" id="female" name="stagiaire.gender" value="female" />
    <br>
    <s:submit value="envoyer"/>
</s:form>
</body>
</html>

