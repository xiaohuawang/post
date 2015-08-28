package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Post;

import org.junit.Test;

import db.DBPost;

public class DBPostTest
{

//	@Test
	public void testGetAllPost()
	{
		System.out.println("test get all post");
		List<Post> posts = DBPost.getAllPost();
		System.out.println("posts size = " + posts.size());
		for(Post post:posts)
		{
			System.out.println("content " + post.getPostContent());
		}
	}
	
//	@Test
	public void testSearch()
	{
		System.out.println("test search");
		List<Post> posts = DBPost.searchPosts("this");
		for(Post post: posts)
		{
			System.out.println("content " + post.getPostContent());
		}
	}
	
	@Test
	public void testSearchProfile()
	{
		List<Post> posts = DBPost.searchPostsInProfile(22, "Add");
		
		for(Post post:posts)
		{
			System.out.println("post " + post.getPostContent());
		}
	}

}
