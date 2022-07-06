package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UClaimDao;
import dao.UProductDetailsDao;
import model.Claim;
import model.UserProduct;

/**
 * Servlet implementation class ClaimController
 */
@WebServlet("/ClaimController")
public class ClaimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClaimController() {
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

		Claim claim = new Claim();
		String serialno =request.getParameter("serialno");
		String username =request.getParameter("username");
		UClaimDao cld = null;
		
		try {
			 cld = new UClaimDao();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
			cld.doReadClaim(serialno,username);
			String tableClaim = "";
		try {	
			tableClaim = cld.getHTMLTable();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("tableClaim", tableClaim);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/u-add-claim.jsp");
		dispatcher.forward(request, response);
	}

}
