
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.miniproject.dao.UserRoledao;
import com.miniproject.dao.UserRoledaoImpl;



public class InsuredMethodsTesting {
	
	// Test Method for Checking PolicyNumber 
	@Test
	public void testUserPolicyNumber() {
		UserRoledao user=new UserRoledaoImpl();
		assertEquals(1001,user.userPolicyNumber(101));
	}
	
	// Test Method for Checking Getting AccountNumber By using UserName
	@Test
	public void testGetAccountNumberByUserName() {
		UserRoledao user=new UserRoledaoImpl();
		assertEquals(101,user.getAccountNumByUserName("Mark"));
	}
	
	//Test Method for Checking the claims
	@Test
	public void testCheckForClaim() {
		UserRoledao user=new UserRoledaoImpl();
		assertEquals(1,user.checkForClaim(1001));
	}
	
	//Test Method for Checking to get the Agent Names 
	@Test
	public void testGetAgentName() {
		UserRoledao user=new UserRoledaoImpl();
		assertEquals("Joe",user.getAgentName("Mark"));
	}
	
	//TestMethod for Checking to get the AccountNumber based on UserName
	@Test
	public void testGetAccountNumByUserName() {
		UserRoledao user=new UserRoledaoImpl();
		assertEquals(101,user.getAccountNumByUserName("Mark"));
	}
}