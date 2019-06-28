package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.QuestionnaireDAO;
import org.apache.struts2.interceptor.SessionAware;
import questionnaire.Questionnaire;

import java.util.ArrayList;
import java.util.Map;

public class modifierAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;

    public String execute(){
        if(session.get("admin").equals(true)){
            return "success";
        }else{
            return "failure";
        }
    }
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
