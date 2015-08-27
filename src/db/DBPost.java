package db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Bulluser;
import model.Post;
import customTools.DBUtil;

public class DBPost
{
	public static List<Post> searchPosts(String query)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT e FROM Post e WHERE e.postContent LIKE :query ";
		List<Post> posts = null;
		try
		{
			Query q = em.createQuery(queryStr);
			q.setParameter("query", '%' + query + '%');
			posts =  q.getResultList();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return posts;
	}
	
	public static List<Post> getAllPost()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT e FROM Post e ORDER BY e.postDate DESC";
		List<Post> posts = null;
		try
		{
			Query query = em.createQuery(queryStr);
			posts =  query.getResultList();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}

		

		return posts;
	}
	
	public static void insert(Post post) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.persist(post);
			trans.commit();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			trans.rollback();
		} 
		finally 
		{
			em.close();
		}
	}

	public static void update(Post post) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.merge(post);
			trans.commit();
		} catch (Exception e) 
		{
			System.out.println(e);
			trans.rollback();
		} 
		finally 
		{
			em.close();
		}
	}

	public static void delete(Post post) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.remove(em.merge(post));
			trans.commit();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			trans.rollback();
		} finally 
		{
			em.close();
		} 
	}
}
