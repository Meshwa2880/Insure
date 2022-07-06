package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ULoginDao;
import dao.UProductDao;
import model.User;
import model.UserProduct;

/**
 * Servlet implementation class UserProductController
 */
@WebServlet("/UserProductController")
public class UserProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProductController() {
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
			
		String username = request.getParameter("username");
		String serialno = request.getParameter("serialno");
		String productname = request.getParameter("productname");
		Date purchasedate = Date.valueOf(String.valueOf(request.getParameter("purchasedate")));
		UserProduct userproduct = new UserProduct();
		RequestDispatcher rd = null;
		
		UProductDao upd = null;
		try {
			upd = new UProductDao();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 		
			String resultproduct;
			String table = "";
			try {
				resultproduct = upd.doValidateProductName(serialno, productname);				
				userproduct.setUsername(username);
				userproduct.setSerialno(serialno);
				userproduct.setProductname(productname);
				userproduct.setPurchasedate(purchasedate);	
				
			if (resultproduct.equals("success")) {
				 upd.doRegisterProduct(userproduct);
					/*
					 * upd.doReadUserProduct(); table = upd.getHTMLTable();
					 */
				 response.sendRedirect("UserProductDisplayController");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/errorproduct.jsp");
				dispatcher.forward(request, response);
			}
			/* request.setAttribute("table", table); */

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		 
	}


