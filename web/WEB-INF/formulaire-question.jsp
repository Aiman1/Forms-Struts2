<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Création d'utillisateurs</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
<div>TODO write content</div>
<form action="Controleurs/CreerQuestion" method="post">
    <label> Intitulé </label>
    <input type="text" id="intitulé" name="Intitulé de la question" />
    <br>
    <label> Réponses </label>
    <input type="text" id="rep1" name="Réponse1" />
    <br>
    <input type="text" id="rep2" name="Réponse2" />
    <br>
    <input type="text" id="rep3" name="Réponse3" />
    <br>
    <input type="text" id="rep4" name="Réponse4" />
    <br>
    <input type="submit" value="Submit"> </form>
    <%
        ///Random random = new Random();
        ///System.out.println("Random: " + random.nextBoolean());
    %>
</body>

</html>