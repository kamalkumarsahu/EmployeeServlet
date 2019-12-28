package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.bean.Student;
import com.nit.bean.StudentReport;
import com.nit.controller.ResultController;

/**
 * Servlet implementation class StudentResultServlet
 */
public class StudentResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ResultController rc = null;

	@Override
	public void init() throws ServletException {
		rc = new ResultController();
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		int rollno = Integer.parseInt(req.getParameter("rollno"));

		StudentReport report = rc.getResult(rollno);
		if(null!=report){
		Student student=report.getStudent();
		pw.println("roll No :- " + student.getRollno()+"<br>");
		pw.println("name :- " + student.getFirstname()+" "+student.getLastname()+"<br>");
		pw.println("class :- " + student.getClazz()+"<br>");
		pw.println("per :- " + report.getPer()+"<br>");
		pw.println("result :- " + report.getResult()+"<br>");
		}else{
			pw.println("roll no not found.<br>");
		}
		pw.println("<a href='./'>Back</a>");
		
	}

}
