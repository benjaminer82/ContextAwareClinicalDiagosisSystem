/*
 * CDSServlet.java
 *
 * Created on 2006年1月26日, 上午5:31
 */

package Test1;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class CDSServlet extends HttpServlet {
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet CDSServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet CDSServlet at " + request.getContextPath () + "</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            PrintWriter rw = response.getWriter();
            rw.println("<html>");
            rw.println("<head>");
            rw.println("<title>Servlet CDSServlet</title>");
            rw.println("</head>");
            rw.println("<body>");
            rw.println("<h1>Servlet CDSServlet at " + request.getProtocol() + "</h1>");
            rw.println("</body>");
            rw.println("</html>");
            rw.close();
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DataInputStream dis = new DataInputStream
                (new BufferedInputStream(request.getInputStream()));
        DataOutputStream out = new DataOutputStream
                (new BufferedOutputStream(response.getOutputStream()));
        String reqData=dis.readLine();

        String repData="_command[008]command_ _Title [A]Title_ _Price[12.85]Price _";
        out.writeUTF(repData);
        out.flush();
        out.close();        
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
