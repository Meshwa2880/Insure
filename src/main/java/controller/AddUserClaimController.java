package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UAddClaims;
import dao.UProductDetailsDao;
import model.Claim;

/**
 * Servlet implementation class AddUserClaimController
 */
@WebServlet("/AddUserClaimController")
public class AddUserClaimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserClaimController() {
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
		
		String username = request.getParameter("username");
		String serialno = request.getParameter("serialno");
		String description = request.getParameter("description");
		Date dateofclaim = Date.valueOf(String.valueOf(request.getParameter("dateofclaim")));
		int approvalstatus = Integer.parseInt(request.getParameter("approvalstatus"));
		
		UAddClaims aucl = null;	
		RequestDispatcher rd = null;
		UProductDetailsDao upd= null;
		
		try {
			aucl = new UAddClaims();
			upd = new UProductDetailsDao();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String resultvalid = "";
		int resultCount = 0;
		try {
			resultvalid = aucl.doValidate(username, serialno);
			resultCount = aucl.countClaims(serialno,username);
			System.out.print(resultCount);
			if (resultvalid.equals("success")) {
				
				if(resultCount > 2) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/erroraddclaim.jsp");
					dispatcher.forward(request, response);
				}else {
					claim.setUsername(username);
					claim.setSerialno(serialno);
					claim.setDescriptions(description);
					claim.setDateofclaim(dateofclaim);
					claim.setApprovalstatus(approvalstatus);
					aucl.doAddClaim(claim);
					/*
					 * upd.doReadUserProduct(); table = upd.getHTMLTable();
					 */
				 response.sendRedirect("UserProductDisplayController");
					
			}
			}else { RequestDispatcher dispatcher =
					 request.getRequestDispatcher("/error.jsp"); dispatcher.forward(request,
					  response); }
					 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
