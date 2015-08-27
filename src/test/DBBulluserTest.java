package test;

import static org.junit.Assert.*;
import model.Bulluser;

import org.junit.Test;

import db.DBBulluser;

public class DBBulluserTest
{

//	@Test
	public void testInsert()
	{
		Bulluser user = new Bulluser();
		
		user.setFullName("Ahmed2");
		user.setUserName("ahmed2309");
		user.setEmail("ahmed23@infosys.com");
		user.setUserPassword("123");
		DBBulluser.insert(user);
	}
	
	@Test
	public void testLogin()
	{
		Bulluser user = new Bulluser();
		
		
		user.setUserName("cuongngo2306");
		
		user.setUserPassword("123");
		assertEquals(DBBulluser.login(user), 22);
	}

//	@Test
	public void testUpdate()
	{
		fail("Not yet implemented");
	}

//	@Test
	public void testDelete()
	{
		fail("Not yet implemented");
	}

}
