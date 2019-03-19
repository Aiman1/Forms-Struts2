import users.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

public class CreerUnUtilisateur extends HttpServlet {
    private static Hashtable<Integer, User> usersTable= new Hashtable<>();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.** @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occur
     * * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
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
    // <editor-folddefaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs* @throws IOException if an I/O error occurs
     */
    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
    }
}
/**
 *  Returns a short description of the servlet.
 */