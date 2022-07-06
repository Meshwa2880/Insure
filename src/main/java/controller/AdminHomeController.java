package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminHomeController")
public class AdminHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		Cookie cookies[] = request.getCookies();	 
		String usernamecook = ""; 
		String isAdminCook = ""; 
		for (Cookie c : cookies) {
			if(c.getName().equals("un")) {
				usernamecook = c.getValue();
			}
			
			if (c.getName().equals("isAdmin")) {
				isAdminCook = c.getValue();
			}
		}
		
		String url;
		if (isAdminCook.equals("")) {
			url = "/a-error.jsp";
		} else {
			// get username of admin cookie
			String[] isAdminCookLst = isAdminCook.split("_");
			if (isAdminCookLst[0].equals(usernamecook)) {
				System.out.println(isAdminCookLst[0]);
				url = "/a-home.jsp";
			} else {
				url = "/a-error.jsp";
				
				
			}
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
