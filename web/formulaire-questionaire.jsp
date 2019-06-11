<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Création d'utillisateurs</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        thead {
            background-color: #333;
            color: #fff;
        }

        .header-form{
            background-color: #444;
            color: inherit;
            border: solid 1px
        }
    </style>
</head>

<body>
<div>TODO write content</div>
<form action="CreerQuestion" method="post">

    <input type="text" name="intitule" value="intitule du questionnaire"/>

    <select name="sujet" onChange="combo(this, 'theinput')">
        <option>Java</option>
        <option>PHP</option>
        <option>C++</option>
        <!--
            ON devrait utiliser un truc commme ça ici !
            new SujetDAO().getAl
        -->
    </select>


    <table id="qstnr">
        <thead>
        <tr>
            <th colspan="4"> <input class="header-form" type="text" name="questions[0].intitule" num="0" value="intitule de la question 1"/> </th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><input type="text" name="questions[0].reponses[0].intitule" value="reponse1"/></td>
            <td><input type="text" name="questions[0].reponses[1].intitule" value="reponse2"/></td>
        </tr>
        </tbody>

        <thead>
        <tr>
            <th colspan="4"><input class="header-form" type="text" name="questions[1].intitule" num="1" value="intitule de la question 2"/></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><input type="text" name="questions[1].reponses[0].intitule" value="reponse1"/></td>
            <td><input type="text" name="questions[1].reponses[1].intitule" value="reponse2"/></td>
        </tr>
        </tbody>
    </table>

    <br>
    <input type="submit" value="Submit"> </form>
    <button onclick="addQuestions()">Ajout Question</button>
    <button onclick="delQuestion()">Delete Question</button>
    <script>
        var nbQuestion = 2;
        function addQuestions() {
            var table = document.getElementById("qstnr");
            //var rows = table.getElementsByTagName("tbody")[0].getElementsByTagName("tr").length;

            var quest = table.insertRow(nbQuestion);
            var cell1 = quest.insertCell(0);
            var cell2 = quest.insertCell(0);

            cell1.innerHTML = "<button onclick=\"addReponse()\">Ajout Reponse</button> <button onclick=\"delReponse()\">suppr Reponse</button>";

            cell2.innerHTML = "<input class=\"header-form\" type=\"text\" name=\"reponses[" + nbQuestion + "].intitule\" value=\"Question"+ (++nbQuestion) +"\"/>";

            //nbQuestion++;
        }

        function delQuestion() {
            if (nbQuestion == 0) return;
            document.getElementById("qstnr").deleteRow(nbQuestion - 1);
            nbQuestion--;
        }
    </script>
</body>

</html>