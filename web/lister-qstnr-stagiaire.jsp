<%--
  Created by IntelliJ IDEA.
  User: oxygene
  Date: 18/06/19
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Roboto:300,300italic,700,700italic">
    <link rel="stylesheet" href="//cdn.rawgit.com/necolas/normalize.css/master/normalize.css">
    <link rel="stylesheet" href="//cdn.rawgit.com/milligram/milligram/master/dist/milligram.min.css">
</head>
<body>

<h3>Tout les questionnaires:</h3>

<s:iterator  value="qs">
    <fieldset>
        id: <s:property value="id"/><br/>
        statut: <s:property value="statut"/><br/>
        idSujet: <s:property value="idSujet"/><br/>
        intitule: <s:property value="intitule"/><br/>
        <button onclick="passer(this)">Passer le Questionnaire</button>
    </fieldset>
</s:iterator>

<script>
    function passer(qst) {

        //TODO
    }

</script>

</body>
</html>
