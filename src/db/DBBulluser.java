package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Bulluser;
import customTools.DBUtil;
public class DBBulluser
{
	public static Bulluser getUser(long userId)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try
		{
			Bulluser user = em.find(Bulluser.class, userId);
			return user;
		}
		finally
		{
			em.close();
		}
	}
	public static Bulluser getUser(Bulluser bullUser)
	{
		//method to return the userId
		
		//get user name
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String query = "SELECT d FROM Bulluser d WHERE d.userName = :username AND d.userPassword = :password";
		try
		{
			TypedQuery<Bulluser> q = em.createQuery(query,Bulluser.class);
			
					q.setParameter("username", bullUser.getUserName());
					q.setParameter("password", bullUser.getUserPassword());
					
			Bulluser user = q.getSingleResult();
			return user;
			
			
		}
		catch(Exception e)
		{
			
			return null;
		}
		finally
		{
			em.close();
		}
	}
	
	public static int login(Bulluser bullUser)
	{
		//method to return the userId
		
		//get user name
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String query = "SELECT d.userId FROM Bulluser d WHERE d.userName = :username AND d.userPassword = :password";
		try
		{
			long l = (long) em.createQuery(query)
					.setParameter("username", bullUser.getUserName())
					.setParameter("password", bullUser.getUserPassword())
					.getSingleResult();
			
			
			return (int)l;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		finally
		{
			em.close();
		}
	}
	
	
	public static void insert(Bulluser bullUser) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.persist(bullUser);
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

	public static void update(Bulluser bullUser) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.merge(bullUser);
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

	public static void delete(Bulluser bullUser) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.remove(em.merge(bullUser));
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
