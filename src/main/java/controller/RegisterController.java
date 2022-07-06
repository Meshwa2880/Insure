package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String celno = request.getParameter("celno");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		int isadmin = Integer.parseInt(request.getParameter("isadmin"));
		
		if(name == null || name.isEmpty() || email == null || email.isEmpty()) {
			String redirectUrl = "error.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(redirectUrl);
			dispatcher.forward(request, response);
		}		
		else {		
		UserDao userdao = null;
		
		try {
			userdao = new UserDao();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		user.setUsername(username);
		user.setEmail(email);
		user.setAddress(address);
		user.setCelno(celno);
		user.setName(name);
		user.setPassword(password);
		user.setIsadmin(isadmin);
		
		userdao.doAddUser(user);
		
		}
	}

}