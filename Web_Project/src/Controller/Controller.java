package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Doctor;
import Service.Service;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search = request.getParameter("search");
		String action = request.getParameter("action");
		String action123 = request.getParameter("action123");
		Service s = new Service();
		PrintWriter out = response.getWriter();
		
		if(search!=null)
		{
			int pid = Integer.parseInt(request.getParameter("pid"));
			int i = s.login(pid);
			
			if(i>0)
			{
				
				ArrayList<Doctor> alist = s.search(pid);
				request.setAttribute("patient", alist);
				RequestDispatcher rd = request.getRequestDispatcher("viewpatientdetails.jsp");
				rd.forward(request, response);
			}
			
			else
			{
				out.println("<html><body><font color='red'><center>Patient Id:"+pid+" not Found</center></font></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.include(request, response);
			}
			
		}
		
		if(action!=null)
			if(action.equalsIgnoreCase("update"))
			{
				int pid=Integer.parseInt(request.getParameter("id"));
				String name=request.getParameter("id1");
				
				request.setAttribute("pid", pid);
				request.setAttribute("name", name);
				
				RequestDispatcher rd=request.getRequestDispatcher("generation.jsp");
				rd.forward(request, response);
			}
		if(action123!=null)
		{
			int id = Integer.parseInt(request.getParameter("pid"));
			String text = request.getParameter("pinves");
			
			int i = s.update(id,text);
			
			if(i>0)
			{
				ArrayList<Doctor> alist=s.search(id);
				request.setAttribute("Patient", alist);
				request.setAttribute("id",id);
				request.setAttribute("update","Investigation report generated successfully for id:"+id);
			
				RequestDispatcher rd=request.getRequestDispatcher("viewpatientdetails.jsp");
				rd.forward(request, response);
			}
		}
	}

}

