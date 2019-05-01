package Questionnaire;

import java.util.ArrayList;

public class Questionnaire {
    private int id;
    private Boolean statut;
    private ArrayList<Question> questions;

    public ArrayList<Question> getQuestions(){return this.questions;}
}
