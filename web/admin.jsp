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
<button>lister questionnaire</button>
<button>creer questionnaire</button>

<a href="formulaire-user.jsp"><button>creer utilisateur</button>
</a><br>
<a href="formulaire-admin.jsp"><button>creer Administrater</button></a><br>
<a href="listAllUsers">lister utilisateur</a><br>
<a href="listQuestionnaires">lister questionnaire</a><br>
<a href="formulaire-questionaire.jsp">creer questionnaire</a>


</body>
</html>
