package com.durgasoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.durgasoft.beans.Student;
import com.durgasoft.service.StudentService;



@WebServlet("/edit")
public class EditFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String sid=request.getParameter("sid");
		StudentService stdService=new StudentService();
		Student std=stdService.getStudent(sid);
		if(std==null){
		out.println("<html>");
		out.println("<body>");
		out.println("<br><br>");
		out.println("<font color='red' size='6'>");
		out.println("Student Not Existed");
		out.println("</font>");
		out.println("<br><br>");
		out.println("<h3><a href='./UpdateForm.html'>|Update Form|</a></h3>");
		out.println("</body></html>");
		}else{
		out.println("<html>");
		out.println("<body>");
		out.println("<font color='red'>");
		out.println("<h2>Durga Software Solutions</h2>");
		out.println("<h3>Student Edit Form</h3>");
		out.println("</font>");
		out.println("<form method='POST' action='./update'>");
		out.println("<table>");
		out.println("<tr><td>Student Id</td><td>"+std.getSid()+"</td></tr>");
		out.println("<input type='hidden' name='sid' value='"+sid+"'/>");
		out.println("<tr><td>Student Name</td><td><input type='text' name='sname' value='"+std.getSname()+"'/></td></tr>");
		out.println("<tr><td>Student Address</td><td><input type='text' name='saddr' value='"+std.getSaddr()+"'/></td></tr>");
				out.println("<tr><td><input type='submit' value='Update'/></td></tr>");
				out.println("</table></form></body></html>");
	}

}
}
