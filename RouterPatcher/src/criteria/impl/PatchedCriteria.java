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
public class PatchedCriteria implements ICriteria
{

	private static final Logger logger = Logger.getLogger(PatchedCriteria.class.getName());
	
	/**
	 * returns all routers that are unpatched
	 */
	@Override
	public List<Router> checkCriteria(List<Router> routers) 
	{
		List<Router> unpatchedRouters = new ArrayList<Router>();
		
		for (Router router : routers)
		{
			if (!router.isPatched())
			{
				unpatchedRouters.add(router);
			}
		}
		
		
		logger.log(Level.INFO, unpatchedRouters.size() + " unpatched routers");
		return unpatchedRouters;
	}

}
