<%--
  Created by IntelliJ IDEA.
  User: oxygene
  Date: 09/04/19
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Roboto:300,300italic,700,700italic">
    <link rel="stylesheet" href="//cdn.rawgit.com/necolas/normalize.css/master/normalize.css">
    <link rel="stylesheet" href="//cdn.rawgit.com/milligram/milligram/master/dist/milligram.min.css">
    <title>Création d'utillisateurs</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
<div>TODO write content</div>
<form action="createUserAction" method="post">
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
    <input type="hidden" id="admin" name="admin" value="true">
    <input type="submit" value="Submit"> </form>
    <br>
</body>

</html>