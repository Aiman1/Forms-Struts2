package Controleurs;

import Questionnaire.Question;
import Utilisateurs.Utilisateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="cs_questions", urlPatterns = {"/question","question.php"})
public class CreerQuestion extends HttpServlet {
    int questionId;
    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        if (request.getRequestURI().compareTo("/Projet_SR03_war_exploded/question") == 0) {
            RequestDispatcher requestDispatcher;
            requestDispatcher = request.getRequestDispatcher("formulaire-question.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
            PrintWriter p = response.getWriter();
            p.println("<h1>" + request.getRequestURI() + "<h1>");
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.** @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occur
     * * @throws IOException if an I/O error occurs
     */
    protected void processRequestUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        QuestionDAO QstDao = new QuestionDAO;
        ReponseDAO RepDao = new ReponseDAO;

        int createQuestion = QstDao.create(
                questionId;
                request.getParameter("Intitulé de la question")
                );
        int createQustion = RepDao.create(
                questionId++;
                request.getParameter("Réponse1"),
                request.getParameter("Réponse2"),
                request.getParameter("Réponse3"),
                request.getParameter("Réponse4")
        );

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Controller:</title>");
            out.println("</head>");out.println("<body>");
            out.println("<h1> Utilisateur crée " + usersTable.get(usersTable.size()-1).toString() + "</h1>");
            out.println("</body>");out.println("</html>");
        }
    }

    /**
     *
     *Handles the HTTP <code>POST</code> method.
     *  @param request servlet request
     *  @param response servlet response
     *  @throws ServletException if a servlet-specific error occurs
     *  @throws IOException if an I/O error occurs
     *  */
    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        if (request.getHeader("referer").compareTo("http://localhost:8083/Projet_SR03_war_exploded/question") == 0) {
            processRequestUser(request, response);
        }
        else{
            PrintWriter p = response.getWriter();
            p.println("<h1>" + request.getHeader("referer")+ "<h1>");
        }
    }

}
