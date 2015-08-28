package main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBBulluser;
import model.Bulluser;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("login post");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Bulluser user = new Bulluser();
		user.setUserName(username);
		user.setUserPassword(password);
		System.out.println(username + password);
		int userId = DBBulluser.login(user);
		if (userId>0)
		{
			System.out.println("in if");
			HttpSession session = request.getSession();
			session.setAttribute("loginId", userId);
			
			Bulluser user1 = DBBulluser.getUser(userId);
			
			session.setAttribute("username", user1.getUserName());
			getServletContext().getRequestDispatcher("/AllPosts").forward(request, response);
		}
		else
		{
			getServletContext().getRequestDispatcher("/LoginForm.jsp").forward(request, response);
		}
	}

}
