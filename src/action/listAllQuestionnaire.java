package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.QuestionnaireDAO;
import org.apache.struts2.interceptor.SessionAware;
import questionnaire.Questionnaire;

import java.util.ArrayList;
import java.util.Map;

public class listAllQuestionnaire  extends ActionSupport implements SessionAware {
    Map<String, Object> map;
    ArrayList<Questionnaire> qs;

    @Override
    public void setSession(Map<String, Object> map) {
        this.map =  map;
    }

    public ArrayList<Questionnaire> getQs() {
        return qs;
    }

    public void setQs(ArrayList<Questionnaire> qs) {
        this.qs = qs;
    }

    public String execute(){
        try{
            qs = (ArrayList<Questionnaire>) new QuestionnaireDAO().getAll();
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "failure";
        }
    }
}
