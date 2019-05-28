<%--
  Created by IntelliJ IDEA.
  User: oxygene
  Date: 28/05/19
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>All Records:</h3>

<s:iterator  value="list">
    <fieldset>
        <s:property value="id"/><br/>
        <s:property value="family_name"/><br/>
        <s:property value="first_name"/><br/>
        <s:property value="tel"/><br/>
        <s:property value="societe"/><br/>
        <s:property value="gender"/><br/>
        <s:property value="actif"/><br/>
    </fieldset>
</s:iterator>

</body>
</html>
