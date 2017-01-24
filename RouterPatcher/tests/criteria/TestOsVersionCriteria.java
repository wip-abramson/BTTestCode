package criteria;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import criteria.impl.OsVersionCriteria;
import main.Router;

public class TestOsVersionCriteria
{

	private OsVersionCriteria osVersionCriteria = new OsVersionCriteria();
	
	@Test
	public void testCheckCriteria()
	{
		List<Router> routers = osVersionCriteria.checkCriteria(generateRouters());
		
		assertTrue(routers.size() == 3);
	}
	
	private List<Router> generateRouters()
	{
		List<Router> routers = new ArrayList<Router>();
		
		Router router1 = new Router();
		router1.setOsSystem(12.0f);
		
		Router router2 = new Router();
		router2.setOsSystem(11.1f);
		
		Router router3 = new Router();
		router3.setOsSystem(13.30f);
		
		Router router4 = new Router();
		router4.setOsSystem(10.0f);
		
		Router router5 = new Router();
		router5.setOsSystem(12.5f);
		
		routers.add(router1);
		routers.add(router2);
		routers.add(router3);
		routers.add(router4);
		routers.add(router5);
		
		return routers;
	}

}
