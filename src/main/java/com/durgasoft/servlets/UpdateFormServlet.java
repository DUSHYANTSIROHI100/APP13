package com.durgasoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.durgasoft.service.StudentService;




@WebServlet("/update")
public class UpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		String saddr=request.getParameter("saddr");
		StudentService ss=new StudentService();
		String status=ss.update(sid,sname,saddr);
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>");
		out.println("<br><br>");
		if(status.equals("success")){
		out.println("Student Updated Successfully<br>");
		}else{
		out.println("Student Updation Failure<br>");
		}
		out.println("<a href='./UpdateForm.html'>|Update Form|</a>");
		out.println("</h2></body></html>");

	}

}
