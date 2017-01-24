package criteria;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import criteria.impl.IpCriteria;
import main.Router;

public class IpCriteriaTest {

	private IpCriteria ipCriteria = new IpCriteria();
	
	private String duplicatedIp = "1.1.1.1";
	
	@Test
	public void testCheckCriteria()
	{
		
		List<Router> routers = ipCriteria.checkCriteria(generateRouters());
		
		assertTrue(routers.size() == 3);	
		
		for (Router router : routers)
		{
			assertFalse(router.getIpAddress().equals(duplicatedIp));
		}
		
	}
	
	private List<Router> generateRouters()
	{
		List<Router> routers = new ArrayList<Router>();
		
		
		Router router1 = new Router();
		router1.setIpAddress("1.1.1.1");
		
		Router router2 = new Router();
		router2.setIpAddress("1.1.1.2");
		
		Router router3 = new Router();
		router3.setIpAddress("1.1.1.3");
		
		Router router4 = new Router();
		router4.setIpAddress("1.1.1.4");
		
		Router router5 = new Router();
		router5.setIpAddress("1.1.1.1");
		
		Router router6 = new Router();
		router6.setIpAddress("1.1.1.1");
		
		routers.add(router1);
		routers.add(router2);
		routers.add(router3);
		routers.add(router4);
		routers.add(router5);
		routers.add(router6);
		
		return routers;
	}

}
