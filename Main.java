/*
 * Main.java
 *
 * Created on 2006年1月13日, 下午2:43
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.project.test;
import com.project.util.GetData;

/**
 *
 * @author Kai Wei
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date today=new Date();
        long date = today.getTime();
        
        // convert date type
        SimpleDateFormat DateFormat
                = new SimpleDateFormat("dd/MM/yyyy");
        String day = DateFormat.format(today);
     
      
        
        
        Calendar cal=Calendar.getInstance();
        int y=cal.get(cal.YEAR);
        int m=cal.get(cal.MONTH)+1;
        int d=cal.get(cal.DAY_OF_YEAR);
        int date=y*10000+m*100+d;
        System.out.println(date);
         
        int hour=cal.get(cal.HOUR_OF_DAY);
        int min=cal.get(cal.MINUTE);
        int sec=cal.get(cal.SECOND);
        int time=hour*10000+min*100+sec;
        System.out.println(time);
     
        
       
        Connection conn=null;
        try{
            
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            conn=DriverManager.getConnection("jdbc:mysql:///temperature","root", "root");
            Statement stmt=conn.createStatement();
            String a="hello";
            stmt.execute("create table "+a+" (name varchar(20))");
            stmt.close();
            
            if(!conn.isClosed())
                System.out.println("Successfully connected to " +
                        "MySQL server using TCP/IP...");
            
            
        }catch(Exception e){
            System.out.println("wrong");
        }
    
          GetData a=new GetData();
          a.run();
    
    }  
      
     
    }
    

