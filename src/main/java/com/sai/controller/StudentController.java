package com.sai.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sai.Service.IStudentService;
import com.sai.Service.ServiceFactory;
import com.sai.dto.Student;


@WebServlet("/controller/*")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static IStudentService stdService=null;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//String URI = request.getRequestURI();
		stdService = ServiceFactory.getStudentServiceObj();
		
		
		if(request.getRequestURI().endsWith("insert")) {
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String city = request.getParameter("city");
			Student std = new Student();
			std.setName(name);
			std.setAge(age);
			std.setCity(city);
			String res = stdService.addStudent(std);
			PrintWriter out = response.getWriter();
			if(res.equalsIgnoreCase("successful")) {
				out.println("<html><body><center><h1 style='color:brown'>Insertion Successful</h1></center></body></html>");
			}
			else {
				out.println("<html><body><center><h1 style='color:brown'>Insertion Failed</h1></center></body></html>");
			}
		}
		if(request.getRequestURI().endsWith("search")) {
			String id =(request.getParameter("id"));
			Student res = stdService.searchStudent(Integer.parseInt(id));
			PrintWriter out = response.getWriter();
			if(res!=null) {
				out.println("<html><body><center><h1 style='color:brown'>Student details</h1>");
				out.println("<table><tr><td>ID: </td><td>"+res.getId()+"</td>");
				out.println("<table><tr><td>Name: </td><td>"+res.getName()+"</td>");
				out.println("<table><tr><td>Age: </td><td>"+res.getAge()+"</td>");
				out.println("<table><tr><td>City: </td><td>"+res.getCity()+"</td>");
				out.println("</table></center></body></html>");
			}
			else {
				out.println("<html><body><center><h1 style='color:brown'>Record Not Found!</h1></center></body></html>");
			}
		}
		if(request.getRequestURI().endsWith("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String res = stdService.deleteStudent(id);
			PrintWriter out = response.getWriter();
			if(res.equalsIgnoreCase("Successful")) {
					out.println("<html><body><center><h1 style='color:brown'>Record deleted Successfully!</h1></center></body></html>");
			}
			else {
				out.println("<html><body><center><h1 style='color:brown'>Deletion failed</h1></center></body></html>");
			}
		}
		if(request.getRequestURI().endsWith("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Student res = stdService.searchStudent(id);
			PrintWriter out = response.getWriter();
			if(res!=null) {
				out.println("<html><body><center><form method='GET' action='./controller/editRecord'><h1 style='color:brown'>Student details</h1>");
				out.println("<table><tr><td>ID = </td><td>"+res.getId()+"</td></tr>");
				out.println("<input type='hidden' name='id' value='" + res.getId() + "'/>");
				out.println("<tr><td>Name </td><td><input type'text' name='name' value='"+res.getName()+"' /></td></tr>");
				out.println("<tr><td>Age </td><td><input type'text' name='age' value='"+res.getAge()+"' /></td></tr>");
				out.println("<tr><td>City </td><td><input type'text' name='city' value='"+res.getCity()+"' /></td></tr>");
				out.println("<tr><td></td><input type='submit' value='update' /></tr>");
				out.println("</table></form></center></body></html>");
				 
				/*
				 * out.println("<html><head><title>update</title></head>"); out.
				 * println("<body><center><form method='GET' action='./controller/editRecord'>"
				 * ); out.println("<h1 style='color:brown'>Update the details</h1>");
				 */
			}
			else {
				out.println("<html><body><center><h1 style='color:brown'>Record Not Found!</h1></center></body></html>");
			}
		}
		if(request.getRequestURI().endsWith("editRecord")){
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String city = request.getParameter("city");
			Student std = new Student();
			std.setId(id);
			std.setName(name);
			std.setAge(age);
			std.setCity(city);
			String res = stdService.updateStudent(std);
			PrintWriter out = response.getWriter();
			if(res.equalsIgnoreCase("successful")) {
				out.println("<html><body><center><h1 style='color:brown'>Record Updated Successfully!</h1></center></body></html>");
			}
			else {
				out.println("<html><body><center><h1 style='color:brown'>Updation Failed</h1></center></body></html>");
			}
		}
	}

}
