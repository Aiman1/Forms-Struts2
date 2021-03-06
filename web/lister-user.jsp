<%--
  Created by IntelliJ IDEA.
  User: oxygene
  Date: 28/05/19
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Roboto:300,300italic,700,700italic">
    <link rel="stylesheet" href="//cdn.rawgit.com/necolas/normalize.css/master/normalize.css">
    <link rel="stylesheet" href="//cdn.rawgit.com/milligram/milligram/master/dist/milligram.min.css">
    <title>Title</title>
</head>
<body>

<h3>All Records:</h3>

<s:iterator  value="list">
    <fieldset>
        id: <s:property value="id"/><br/>
        family_name: <s:property value="family_name"/><br/>
        first_name: <s:property value="first_name"/><br/>
        tel: <s:property value="tel"/><br/>
        societe: <s:property value="societe"/><br/>
        gender: <s:property value="gender"/><br/>
        actif: <s:property value="actif"/><br/>
        <button onclick="post('modifierStagiaire',this,'post')">Modifier utilisateur</button>
    </fieldset>
</s:iterator>
<script>
    function post(path, params, method='post') {

        var form = document.createElement('form');
        form.method = method;
        form.action = path;

        for (var key in params) {
            if (params.hasOwnProperty(key)) {
                var hiddenField = document.createElement('input');
                hiddenField.type = 'hidden';
                hiddenField.name = key;
                hiddenField.value = params[key];

                form.appendChild(hiddenField);
            }
        }

        document.body.appendChild(form);
        form.submit();
    }

</script>
</body>
</html>
