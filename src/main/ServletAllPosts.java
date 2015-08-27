package main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBPost;
import model.Post;

/**
 * Servlet implementation class ServletAllPosts
 */
@WebServlet("/AllPosts")
public class ServletAllPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAllPosts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doget");
		List<Post> posts = DBPost.getAllPost();
		
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
		}
		
		request.setAttribute("postData", postData);
		//forward it
		getServletContext().getRequestDispatcher("/AllPosts.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost");
		doGet(request,response);
	}

}
