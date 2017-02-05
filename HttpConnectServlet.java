/*
 * HttpConnectServlet.java
 * Created on 2006年1月06日, 上午3:54
 */

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.sql.DataSource;
import javax.servlet.*;
import javax.naming.*;

public class HttpConnectServlet extends HttpServlet {
    private Connection con = null;
    private String dbDriver = "org.gjt.mm.mysql.Driver";
    private DataSource dataSource;
    String mote_id = "";
    String temp = "";
    String date = "";
    String time = "";
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    
    /** Creates a new instance of mysqlConnection */
       
    private void createConnection(){
        String url = "jdbc:mysql://localhost:3306/wk?user=root&password=820326";
        String jdbcDriver = "org.gjt.mm.mysql.Driver";
        try{
            Class.forName(jdbcDriver);
            con = java.sql.DriverManager.getConnection(url);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void closeConnection() {
        if(con != null) {
            try{
                con.close();
            }
            catch (Exception ex){
                System.out.println("Error: closeConnection()" +ex);
            }
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        System.out.println("Messege from Midlet requested");   
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try{
        createConnection();
        PreparedStatement ps = con.prepareStatement
                ("SELECT * FROM record");
        ResultSet rs = ps.executeQuery();
        if(true){
                out.println("Successfully login in system");
                out.println("All the Records below" + "\n");
                System.out.println("Successfull confirm");
                while(rs.next()) {
         //format output information
         double num;
         String date;
         String time;
         int yy;
         int mon;
	  int day;
	  int hh;
	  int ss;
	  int mm;  
         num=Double.parseDouble(rs.getString(3))/100;
	  hh=(int)Integer.parseInt(rs.getString(5))/10000;
	  mm=(int)(Integer.parseInt(rs.getString(5))-hh*10000)/100;
	  ss=Integer.parseInt(rs.getString(5))-hh*10000-mm*100;
	  if(mm<=9){
	  time=""+hh+":0"+mm;
	  if(ss<=9){
	  time=""+hh+":0"+mm+":0"+ss;
	  }else{
	  time=""+hh+":0"+mm+":"+ss;
	  }
	  }else{
	  if(ss<=9){
	  time=""+hh+":"+mm+":0"+ss;
	  }else{
	  time=""+hh+":"+mm+":"+ss;
	  }
	  }	   
	 
	  yy=(int)Integer.parseInt(rs.getString(4))/10000;
	  mon=(int)(Integer.parseInt(rs.getString(4))-yy*10000)/100;
	  day=Integer.parseInt(rs.getString(4))-yy*10000-mon*100;
	  if(day<=9){
	  if(mon<=9){
	  date="0"+day+"/0"+mon+"/"+yy;
	  }else{
	  date="0"+day+"/"+mon+"/"+yy;
	  }
	  }else{
	  if(mon<=9){
	  date=""+day+"/0"+mon+"/"+yy;
	  }else{
	  date=""+day+"/"+mon+"/"+yy;
	  }
	  }	   

                    mote_id= rs.getString(2);
                    temp = ""+num;
                    date = date;
                    time = time;
                    
                    response.setContentType("text/plain");
                    out.println("Mote ID: " + mote_id + "  Temperature: " + temp +"\n"+
                           "Date: "+ date + " Time: " + time + "\n");
                    }
            }
            else{
                out.println("Sorry, ur pwd is wrong!");
                System.out.println("Error for confirm!");    
            }

            rs.close();
            ps.close();
            con.close();
            out.close();          
       }
       catch (Exception e) {
           e.printStackTrace();
           System.out.println("Error : " + e.toString());
       }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
