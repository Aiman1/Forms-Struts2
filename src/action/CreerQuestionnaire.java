package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import questionnaire.Question;
import questionnaire.Questionnaire;
import questionnaire.Reponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreerQuestionnaire extends ActionSupport implements SessionAware {
    private List<Question> questions;


    private String sujet;
    private String intitule;

    private Map<String, Object> session;

    public String execute(){
 /*       System.out.println("\n\n");
        System.out.println("Questionnaire " + intitule + " sur le sujet: " + sujet);
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Question "+ i + ": "+ questions.get(i).getIntitule());
            for (int nbReponse: nbReponses) {
                for (int j = 0; j < nbReponse; j++) {
                    if(reponses.get(j) != null) {
                        System.out.println("\t" + reponses.get(j).getIntitule());
                    }
                    else
                        System.out.println(reponses.toString());
                }
            }
            System.out.println("\n\n");
        }

        for(Question q : questions)
            System.out.println(q.toString());
        return "failure";
*/
        Questionnaire q = new Questionnaire();
        q.setQuestions(questions);
        q.setIntitule(intitule);
        q.setSujet(1);
        System.out.println(q.toString());
        return "failure";
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }



    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
}
