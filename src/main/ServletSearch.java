package main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;
import db.DBPost;

/**
 * Servlet implementation class ServletSearch
 */
@WebServlet("/Search")
public class ServletSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doget search");
		String query = request.getParameter("search");
		System.out.println("query = " + query);
		
		List<Post> posts = DBPost.searchPosts(query);
		
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
			postData += post.getBulluser().getFullName();
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

	}

}
