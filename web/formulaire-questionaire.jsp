<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Création d'utillisateurs</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .fhead {
            background-color: #333;
            color: #fff;
        }

        .header-form{
            background-color: #444;
            color: inherit;
            border: solid 1px
        }
        .finp{
            display: block;
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
            new SujetDAO().getAll()
        -->
    </select>

    <div class="finp" num="0" rep="2">
    <span class="fhead"><input class="header-form" type="text" name="questions[0].intitule" num="0" value="intitule de la question 1"/></span>
    <button onclick="return addReponses(event, this.parentNode)">Ajout Reponse</button>
    <button onclick="return delReponses(event, this.parentNode)">Enlever Reponse</button> <br>
    <input type="text" name="questions[0].reponses[0].intitule" value="reponse1"/>
    <input type="text" name="questions[0].reponses[1].intitule" value="reponse2"/>
    </div>

    <br>
    <br>

    <div class="finp" num="1" rep="2">
    <span class="fhead"><input class="header-form" type="text" name="questions[1].intitule" num="1" value="intitule de la question 2"/></span>
    <button onclick="return addReponses(event, this.parentNode)">Ajout Reponse</button>
    <button onclick="return delReponses(event, this.parentNode)">Enlever Reponse</button> <br>
    <input type="text" name="questions[1].reponses[0].intitule" value="reponse1"/>
    <input type="text" name="questions[1].reponses[1].intitule" value="reponse2"/>
    </div>


    <br>
    <input type="submit" value="Submit"> </form>
    <button onclick="addQuestions()">Ajout Question</button>
    <button onclick="delQuestion()">Delete Question</button>
    <script>

        var nbQuestion = 2;
        function addReponses(ev, parent){
            ev.preventDefault();

            question = parent.getAttribute("num");
            rep = parent.getAttribute("rep");

            parent.setAttribute("rep",(parseInt(rep) + 1));

            var node = document.createElement("INPUT");

            node.name = "questions["+question+"].reponses["+rep+"].intitule";
            node.type = "text";
            node.value = "reponse"+rep;

            parent.appendChild(node);

        }
        function delReponses(ev, parent){
            ev.preventDefault();
            rep = parseInt(parent.getAttribute("rep"));

            if (rep < 1) return;

            parent.removeChild(parent.lastElementChild);
            parent.setAttribute("rep",(parseInt(rep) - 1));

        }
        function addQuestions() {

        }

        function delQuestion() {
            if (nbQuestion == 0) return;

        }
    </script>
</body>

</html>