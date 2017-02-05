<%@ page import="java.sql.*"%> 
<html>    
<body onload="setTimeout( this.location.reload(); ,6000);"> 
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"> 
<meta http-equiv="refresh" content="5">
<%Class.forName("org.gjt.mm.mysql.Driver").newInstance();    
String url ="jdbc:mysql://localhost/wk";
Connection conn= DriverManager.getConnection(url,"root","820326");    
Statement stmt=conn.createStatement();
String sql="select * from record";       
ResultSet rs=stmt.executeQuery(sql);
double num;
String date;
String time;
int yy;
int mon;
int day;
int hh;
int ss;
int mm;
%>
<table width="100%" border="1">
  <tr>
    <td width="20%" height="20">Sequence</td>
    <td width="20%">Sensor_ID</td>
    <td width="20%">Temperature</td>
    <td width="20%">Date</td>
    <td width="20%">Time</td>
  </tr>
</table>
<%while(rs.next()) {
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
	   %>
<table width="100%" border="1">
  <tr>
    <td width="20%"><%=rs.getString(1)%></td>
    <td width="20%"><%=rs.getString(2)%></td>
    <td width="20%"><%=num%></td>
    <td width="20%"><%=date%></td>
    <td width="20%"><%=time%></td>
  </tr>
</table>
  <%}%>
  <%   
rs.close();    
stmt.close();    
conn.close();    
%>
</p>
<p>&nbsp;</p>
</body>    
</html>