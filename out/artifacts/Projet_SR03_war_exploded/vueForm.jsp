<%--
  Created by IntelliJ IDEA.
  User: oxygene
  Date: 19/03/19
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>TODO supply a title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div>TODO write content</div>
<form action="/Projet_SR03_war_exploded/CreerUtilisateur" method="post">
    <label> First name </label>
    <input type="text" id="frname" name="User first name"/>
    <br>
    <label> Familly name </label>
    <input type="text" id="faname" name="User familly name"/>
    <br>
    <label> Email </label>
    <input type="email" id="email" name="User email"/>
    <br>
    <label> Password </label>
    <input type="password" id="psw" name="User password"/>
    <br>
    <label> male </label>
    <input type="radio" id="male" name="gender" value="male" checked/>
    <br>
    <label> female </label>
    <input type="radio" id="female" name="gender" value="female"/>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>