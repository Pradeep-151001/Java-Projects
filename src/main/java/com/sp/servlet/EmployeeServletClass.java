package com.sp.servlet;



import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sp.dao.EmployeeDAO;
import com.sp.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import com.sp.constants.Constants;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/")
public class EmployeeServletClass extends HttpServlet {

	public static final long serialVersionUID = 1L;
	
	private EmployeeDAO emp; 
	
	public void init() {
		emp = new EmployeeDAO();
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
		
		doGet(req,res);
	}
			
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException {
		
		String choice = req.getServletPath();
		try {
			switch (choice) {
				case Constants.CREATE_EMP:
					createForm(req,res);
					break;
				case Constants.LIST_EMP:
					listEmp(req,res);
					break;
				default:
					break;
			}
		}catch(SQLException|IOException e) {
			throw new ServletException(e); 
			
		}
	}
	
	private void createForm(HttpServletRequest req, HttpServletResponse res)throws ServletException,SQLException,IOException
	{
		RequestDispatcher rd = req.getRequestDispatcher("EmployeeForm.jsp");
		rd.forward(req,res);
		
	}
	
	private void listEmp(HttpServletRequest req, HttpServletResponse res) throws ServletException,SQLException,IOException 
	{
		List<Employee> list = emp.showExployee();
		req.setAttribute("listEmp", list);
		RequestDispatcher rd = req.getRequestDispatcher("EmployeeList.jsp");
		rd.forward(req, res);
		
		
	}
}
