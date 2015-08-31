package main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bulluser;
import model.Post;
import db.DBBulluser;

/**
 * Servlet implementation class ServletProfile
 */
@WebServlet("/Profile")
public class ServletProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userIdStr = request.getParameter("userId");
		int userId = 0;
		
		HttpSession session = request.getSession();
		if(userIdStr == null)
		{
			if(session.getAttribute("loginId") == null)
			{
				getServletContext().getRequestDispatcher("/LoginForm.jsp").forward(request, response);
			}
			else
			{
				userId = Integer.parseInt(session.getAttribute("loginId").toString());
			}
		}
		else
		{
			userId = Integer.parseInt(userIdStr);
		}

		System.out.println("userId = " + userIdStr);
		
		 
		
		Bulluser user = DBBulluser.getUser(userId);
		
		String userData = "<div class='alert alert-info'>";
		userData += "<p> Name: " + user.getFullName() + "</p>";
		userData += "<p> Email: " + user.getEmail() + "</p>";
		userData += "<p> Motto: " + user.getMotto() + "</p>";
		userData += "<p> Join Date: " + user.getJoindate() + "</p>";
		
		userData += "</div>";
		request.setAttribute("userData", userData);
		request.setAttribute("userId", userId);
		//List<Post> posts = user.getPosts();
		
		String postData = "<table class='table table-bordered table-striped'>";
		postData += "<thead>";
		postData += "<tr>";
		postData += "<th>";
		postData += "User";
		postData += "</th>";
		postData += "<th>";
		postData += "Content";
		postData += "</th>";
		postData += "<th>";
		postData += "Date";
		postData += "</th>";
		postData += "</tr>";
		postData += "</thead>";
		/*
		for(Post post : posts)
		{
			postData += "<tr>";
			postData += "<td>";
			postData += "<a href='/BullhornAssignment/Profile?userId="+ post.getBulluser().getUserId() +"'>" +post.getBulluser().getFullName() + "</a>";
			postData += "</td>";
			postData += "<td>";
			postData += post.getPostContent();
			postData += "</td>";
			postData += "<td>";
			postData += post.getPostDate();
			postData += "</td>";
			postData += "</tr>";
		}*/
		request.setAttribute("userData", postData);
		getServletContext().getRequestDispatcher("/Profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
