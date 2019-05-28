package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import questionnaire.Question;
import questionnaire.Reponse;

import java.util.List;
import java.util.Map;

public class CreerQuestionnaire extends ActionSupport implements SessionAware {
    private List<Question> questions;
    private List<Reponse> reponses;

    private Map<String, Object> session;

    public String execute(){
        for(Question q : questions)
            System.out.println(q.getIntitule());
        return "failure";
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(List<Reponse> reponses) {
        this.reponses = reponses;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
