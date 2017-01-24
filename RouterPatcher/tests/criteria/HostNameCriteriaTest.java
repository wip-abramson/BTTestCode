package criteria;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import criteria.impl.HostNameCriteria;
import main.Router;

public class HostNameCriteriaTest 
{
	
	private HostNameCriteria hostNameCriteria = new HostNameCriteria();
	
	private String duplicatedHostName;

	@Test
	public void testCheckCriteria() 
	{
		List<Router> routers = hostNameCriteria.checkCriteria(generateRouters());
		
		assertTrue(routers.size() == 2);
		
		for (Router router : routers)
		{
			assertFalse(router.getHostname().equals(duplicatedHostName));
		}
	}
	
	private List<Router> generateRouters()
	{
		List<Router> routers = new ArrayList<Router>();
		
		Router router1 = new Router();
		router1.setHostname("abc");

		Router router2 = new Router();
		router2.setHostname("abc");

		Router router3 = new Router();
		router3.setHostname("bbfc");

		Router router4 = new Router();
		router4.setHostname("abc");

		Router router5 = new Router();
		router5.setHostname("def");
		
		routers.add(router1);
		routers.add(router2);
		routers.add(router3);
		routers.add(router4);
		routers.add(router5);
		
		return routers;
	}

}
