package main;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBBulluser;
import model.Bulluser;

/**
 * Servlet implementation class ServletRegisterUser
 */
@WebServlet("/RegisterUser")
public class ServletRegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost");
		String full_name = request.getParameter("full_name");
		String email = request.getParameter("email");
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String motto = request.getParameter("motto");
		Date joinDate = new Date();
		System.out.println(full_name + email + user_name + password);
		
		Bulluser user = new Bulluser();
		user.setFullName(full_name);
		user.setEmail(email);
		user.setUserName(user_name);
		user.setUserPassword(password);
		user.setMotto(motto);
		user.setJoindate(joinDate);
		System.out.println(full_name);
		System.out.println(email);System.out.println(user_name);System.out.println(password);
		System.out.println(motto);System.out.println(joinDate);
		DBBulluser.insert(user);
		
		HttpSession session = request.getSession();
		session.setAttribute("username", user_name);
		
		Bulluser user2 = DBBulluser.getUser(user);
		System.out.println("userId= " + user2.getUserId());
		session.setAttribute("userId", user2.getUserId());
		getServletContext().getRequestDispatcher("/AllPosts").forward(request, response);
		
	}

}
