package com.durgasoft.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import com.durgasoft.beans.Student;

public class StudentService {
Connection con;
Statement st;
ResultSet rs;
public StudentService() {
try {
Class.forName("oracle.jdbc.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","xe","123");
st=con.createStatement();
} catch (Exception e) {
e.printStackTrace();
}
}
public Student getStudent(String sid){
	Student std=null;
try {
rs=st.executeQuery("select * from Student where SID='"+sid+"'");
boolean b=rs.next();
if(b==true){
std=new Student();
std.setSid(rs.getString("SID"));
std.setSname(rs.getString("SNAME"));
std.setSaddr(rs.getString("SADDR"));
}else{
std=null;
}
} catch (Exception e) {
	e.printStackTrace();
}
return std;
}
public String update(String sid, String sname, String saddr){
	String status="";
try {
st.executeUpdate("update student set sname='"+sname+"',saddr='"+saddr+"' where sid='"+sid+"'"); 
status="success";
} catch (Exception e) {
status="failure";
e.printStackTrace();
}
return status;
}
}