package criteria.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import criteria.ICriteria;
import main.Router;

/**
 * Created by will on 22/01/17.
 * 
 * Checks that routers have unique host name 
 */
public class HostNameCriteria implements ICriteria
{

	private static final Logger logger = Logger.getLogger(HostNameCriteria.class.getName());
	
	/**
	 * Returns only routers with unique host name
	 */
	@Override
	public List<Router> checkCriteria(List<Router> routers) 
	{
		List<Router> uniqueRouters = new ArrayList<Router>();
	
		while(routers.size() != 0)
		{
			Router routerToCheck = routers.get(0);
			
			if (countHostNameOccurance(routerToCheck.getHostname(), routers) == 1)
			{
				logger.log(Level.INFO, "Unique host name found : " + routerToCheck.getHostname());
				uniqueRouters.add(routerToCheck);	
				routers.remove(routerToCheck);
			}
			else
			{
				routers = removeAllOccurances(routerToCheck.getHostname(), routers);
			}
		}
	
		logger.log(Level.INFO, uniqueRouters.size() + " Unique hostnames found.");
		return uniqueRouters;
	}
	
	/**
	 * Returns a new list of routers with all routers that have the given hostName removed
	 * 
	 * @param hostName
	 * @param routers
	 * @return
	 */
	private List<Router> removeAllOccurances(String hostName, List<Router> routers)
	{
		List<Router> updatedRouters = new ArrayList<Router>();
		
		for (Router router : routers)
		{
			if (! router.getHostname().equals(hostName))
			{
				updatedRouters.add(router);
			}
		}
		return updatedRouters;
	}
	
	
	private int countHostNameOccurance(String hostName, List<Router> routers)
	{
		int hostNameCount = 0;
		
		for (int i = 0 ; i < routers.size() ; i ++)
		{
			if (routers.get(i).getHostname().equals(hostName))
			{
				hostNameCount ++;
			}
		}
		
		return hostNameCount;
	}

}
