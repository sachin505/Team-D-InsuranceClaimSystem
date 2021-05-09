import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.miniproject.dao.PolicyImplemented;
import com.miniproject.entities.Policy;

class TestingPolicyImplementedClass {

	@Test
	void testGetPolicyByNumber() {
		PolicyImplemented pimpl= new PolicyImplemented();
		Policy policy=new Policy();
		assertEquals(true,pimpl.addPolicy(policy));
	}
	
	@Test
	void testViewPolicyDetails() {
		PolicyImplemented pimpl= new PolicyImplemented();
		Policy policy=new Policy();
		List list<Policy>;
		assertEquals(list,pimpl.viewPolicies());
	}
	
}
