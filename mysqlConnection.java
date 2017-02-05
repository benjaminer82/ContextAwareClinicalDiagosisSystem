/*
 * mysqlConnection.java
 *
 * Created on 2006年1月26日, 上午4:53
 *
 */

package Test1;

import java.sql.*;

public class mysqlConnection {
    private Connection con = null;
    /** Creates a new instance of mysqlConnection */
    public mysqlConnection() {
    }
    
    private void createConnection(){
        String url = "jdbc:mysql://localhost/test";
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            con = java.sql.DriverManager.getConnection(url, "id", "pwd");
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
                System.out.println("Eorr: closeConnection()" +ex);
            }
        }
    }
    
    public String[] getInfo (String id){
        createConnection();
        try{
            String[] info = new String[4];
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet res = st.executeQuery("Select * from test where id='" + id + "'");
            while(res.next()){
                for(int i=0; i<res.getMetaData().getColumnCount();i++){
                    info[i] = res.getString(i + i);
                }
            }
            
            if (res != null) res.close();
            if(st != null) st.close();
            closeConnection();
            return info;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
