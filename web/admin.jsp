<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: oxygene
  Date: 21/05/19
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Roboto:300,300italic,700,700italic">
    <link rel="stylesheet" href="//cdn.rawgit.com/necolas/normalize.css/master/normalize.css">
    <link rel="stylesheet" href="//cdn.rawgit.com/milligram/milligram/master/dist/milligram.min.css">
    <title>Page admin</title>
</head>
<body>


<h1>Bonjour ${user}</h1>


<button><a href="formulaire-user.jsp">Créer un stagiaire</a></button>
<button><a href="formulaire-admin.jsp">Créer un administrateur</a></button>
<button><a href="listAllUsers">Lister utilisateurs</a></button>
<button><a href="listQuestionnaires">Lister questionnaires</a></button>
<button><a href="formulaire-questionaire.jsp">Créer un questionnaire</button>


</body>
</html>
