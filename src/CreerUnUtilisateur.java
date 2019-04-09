import users.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

@WebServlet(name="cs", urlPatterns = {"/","*.php"})
public class CreerUnUtilisateur extends HttpServlet {
    private static Hashtable<Integer, User> usersTable= new Hashtable<>();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.** @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occur
     * * @throws IOException if an I/O error occurs
     */
    protected void processRequestUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        usersTable.put(
                usersTable.size()
                , new User(
                     request.getParameter("User familly name")
                    ,request.getParameter("User first name")
                    ,request.getParameter("User email"),usersTable.size()
                    ,request.getParameter("gender")
                    ,request.getParameter("User password")
                )
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
    protected void processRequestAdmin(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Controller:</title>");
            out.println("</head>");out.println("<body>");
            out.println("<h1> Admin pris en compte </h1>");
            out.println("</body>");out.println("</html>");
        }
    }
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs* @throws IOException if an I/O error occurs
     */
    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        if (request.getRequestURI().compareTo("/Projet_SR03_war_exploded/new-user") == 0) {
            RequestDispatcher requestDispatcher;
            requestDispatcher = request.getRequestDispatcher("formulaire-user.jsp");
            requestDispatcher.forward(request, response);
        }

        else if (request.getRequestURI().compareTo("/Projet_SR03_war_exploded/new-admin") == 0) {
            RequestDispatcher requestDispatcher;
            requestDispatcher = request.getRequestDispatcher("formulaire-admin.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
            PrintWriter p = response.getWriter();
            p.println("<h1>" + request.getRequestURI() + "<h1>");
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
        if (request.getHeader("referer").compareTo("http://localhost:8083/Projet_SR03_war_exploded/new-user") == 0) {
            processRequestUser(request, response);
        }
        if (request.getHeader("referer").compareTo("http://localhost:8083/Projet_SR03_war_exploded/new-admin") == 0) {
            processRequestAdmin(request, response);
        }
        else{
            PrintWriter p = response.getWriter();
            p.println("<h1>" + request.getHeader("referer")+ "<h1>");
        }
    }
}
/**
 *  Returns a short description of the servlet.
 */