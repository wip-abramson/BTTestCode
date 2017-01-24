package criteria.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import criteria.ICriteria;
import main.Router;


/**
 * Created by will on 22/01/17.
 */
public class OsVersionCriteria implements ICriteria 
{

	private static final Logger logger = Logger.getLogger(OsVersionCriteria.class.getName());
	
	private float osVersion = 12;
	
	/**
	 * Returns all routers with os version above 12
	 */
	@Override
	public List<Router> checkCriteria(List<Router> routers) 
	{
		List<Router> passedRouters = new ArrayList<Router>();
		
		for (Router router : routers)
		{
			if (router.getOsSystem() >= osVersion)
			{
				passedRouters.add(router);
			}
		}
		
		logger.log(Level.INFO, passedRouters.size() + " Routers above " + osVersion + " OS");
		return passedRouters;
	}


}
