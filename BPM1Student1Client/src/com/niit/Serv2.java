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
 * Servlet implementation class Serv2
 */
@WebServlet("/Serv2")
public class Serv2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private MyStudentAction msaob;
	
    public Serv2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String id = request.getParameter("id");
    	
    	Student1 ob = msaob.removeStu(Integer.parseInt(id));
    	PrintWriter out = response.getWriter();
    	out.println("Deleted Data is ");
    	out.println("Student ID -"+ob.getId());
    	out.println("Student Name -"+ob.getStuname());
    	out.println("Student Class -"+ob.getClassname());
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

}
