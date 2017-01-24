package criteria;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import criteria.impl.PatchedCriteria;
import main.Router;

public class TestPatchedCriteria
{

	private PatchedCriteria patchedCriteria = new PatchedCriteria();
	
	
	@Test
	public void testCheckCriteria()
	{
		List<Router> routers = patchedCriteria.checkCriteria(generateRouters());
		
		assertTrue(routers.size() == 3);
	}
	
	private List<Router> generateRouters()
	{
		List<Router> routers = new ArrayList<Router>();
		
		Router router1 = new Router();
		router1.setPatched(false);
		
		Router router2 = new Router();
		router2.setPatched(false);
		
		Router router3 = new Router();
		router3.setPatched(true);
		
		Router router4 = new Router();
		router4.setPatched(true);
		
		Router router5 = new Router();
		router5.setPatched(false);
		
		routers.add(router1);
		routers.add(router2);
		routers.add(router3);
		routers.add(router4);
		routers.add(router5);
		
		return routers;
	}

}
