package com.niit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Serv3
 */
@WebServlet("/Serv3")
public class Serv3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private MyStudentAction msaob;

	public Serv3() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id1 = request.getParameter("id");
		PrintWriter out = response.getWriter();
		Student1 ob11 = msaob.findData(Integer.parseInt(id1));
		if (ob11 != null) {
			out.println("Previous Data is ");
			out.println("Student ID -" + ob11.getId());
			out.println("Student Name -" + ob11.getStuname());
			out.println("Student Class -" + ob11.getClassname());
			@SuppressWarnings("unused")
			Student1 obr = msaob.removeStu(Integer.parseInt(id1));
			String id = request.getParameter("id");
	    	String stuname = request.getParameter("name");
	    	String classname = request.getParameter("classname");
	    	Student1 ob =msaob.updateData(Integer.parseInt(id), stuname, classname);
			
			out.println("Updated Data is ");
			out.println("Student ID -" + ob.getId());
			out.println("Student Name -" + ob.getStuname());
			out.println("Student Class -" + ob.getClassname());
		} else {
			out.println("ID not present");
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

}
