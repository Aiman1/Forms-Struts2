<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Création d'utillisateurs</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
<div>TODO write content</div>
<form action="CreerQuestion" method="post">
<%
    for (int i = 0; i < 4; i++) {

    }
%>
    <input type="text" name="questions[0].intitule" value="intitule"/>
    <input type="text" name="questions[1].intitule" value="intitule"/>
    <input type="text" name="questions[2].intitule" value="intitule"/>
    <input type="text" name="questions[3].intitule" value="intitule"/>
    <input type="submit" value="Submit"> </form>
    <%
        ///Random random = new Random();
        ///System.out.println("Random: " + random.nextBoolean());
    %>
</body>

</html>