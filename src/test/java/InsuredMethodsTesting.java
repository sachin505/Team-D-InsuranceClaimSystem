import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.miniproject.dao.JPAUtility;
import com.miniproject.dao.UserRoledao;
import com.miniproject.dao.UserRoledaoImpl;
import com.miniproject.entities.Claim;



public class InsuredMethodsTesting {
	@Test
	public void testUserPolicyNumber() {
		UserRoledao user=new UserRoledaoImpl();
		assertEquals(1001,user.userPolicyNumber(101));
	}
	@Test
	public void testGetAccountNumberByUserName() {
		UserRoledao user=new UserRoledaoImpl();
		assertEquals(101,user.getAccountNumByUserName("Mark"));
	}
	@Test
	public void testCheckForClaim() {
		UserRoledao user=new UserRoledaoImpl();
		assertEquals(1,user.checkForClaim(1001));
	}
	@Test
	public void testGetAgentName() {
		UserRoledao user=new UserRoledaoImpl();
		assertEquals("Joe",user.getAgentName("Mark"));
	}
	@Test
	public void testGetAccountNumByUserName() {
		UserRoledao user=new UserRoledaoImpl();
		assertEquals(101,user.getAccountNumByUserName("Mark"));
	}
//	@Test
//	public void testAddClaim() {
//		
//		EntityManager entityManager = JPAUtility.getEntityManager();
//		UserRoledao userRoledaoObj=new UserRoledaoImpl();
//		Claim objClaim = new Claim(17,"Life","Nagole","Hyd","TS",500096,"Death",1003);
//		userRoledaoObj.createClaim(objClaim);
//		assertTrue(entityManager.equals(objClaim));
//		System.out.println("Add");
//		entityManager.remove(objClaim);
//	}
}
