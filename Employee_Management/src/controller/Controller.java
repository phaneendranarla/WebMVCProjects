package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import service.Service;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String num = String.valueOf(id);
		String name = request.getParameter("ename");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String submit = request.getParameter("save");
		
		PrintWriter out = response.getWriter();
		Service s = new Service();

		Employee emp = new Employee();
		emp.setId(id);
		emp.setName(name);
		emp.setPassword(password);
		emp.setEmail(email);
		emp.setCountry(country);
		
		if(submit!=null)
		{
			if(num != null && name != null && password != null && email != null && country != null)
			{
				try 
				{
					int status = s.add(emp);
					if(status > 0)
					{
						out.println("<html><body><h2><font color='green'><center>Added Sucessfully</center></font></h2></body></html>");
						RequestDispatcher rd = request.getRequestDispatcher("addemployee.jsp");
						rd.include(request, response);
					}
					else
					{
						out.println("<html><body><h2><font color='red'><center>Adding failed</center></font><h2></body></html>");
						RequestDispatcher rd = request.getRequestDispatcher("addemployee.jsp");
						rd.include(request, response);
					}
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			else
			{
//				out.println("<html><body><h2><font color='red'><center>Adding failed</center></font><h2></body></html>");
//				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
//				rd.include(request, response);
				System.out.println("Please enter all fields");
			}
		}
	}
}
