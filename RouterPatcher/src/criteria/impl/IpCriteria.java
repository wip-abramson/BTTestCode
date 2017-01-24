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
public class IpCriteria implements ICriteria
{

	private static final Logger logger = Logger.getLogger(IpCriteria.class.getName());
	
	/**
	 * Returns list of all routers with unique ip addresses
	 */
	@Override
	public List<Router> checkCriteria(List<Router> routers) {
		
		List<Router> uniqueRouters = new ArrayList<>();
		
		while(routers.size() != 0)
		{
			Router routerToCheck = routers.get(0);
			
			if (countIpOccurance(routerToCheck.getIpAddress(), routers) == 1)
			{
				logger.log(Level.INFO, "Unique host name found : " + routerToCheck.getIpAddress());
				uniqueRouters.add(routerToCheck);	
				routers.remove(routerToCheck);
			}
			else
			{
				routers = removeAllOccurances(routerToCheck.getIpAddress(), routers);
			}
		}
		
		logger.log(Level.INFO, uniqueRouters.size() + " Unique Ip Addresses found.");
		return uniqueRouters;
	}
	
	/**
	 * Returns a new list of routers with all routers that have the given ip address removed
	 * 
	 * @param ipAddress
	 * @param routers
	 * @return
	 */
	private List<Router> removeAllOccurances(String ipAddress, List<Router> routers)
	{
		List<Router> updatedRouters = new ArrayList<Router>();
		
		for (Router router : routers)
		{
			if (! router.getIpAddress().equals(ipAddress))
			{
				updatedRouters.add(router);
			}
		}
		return updatedRouters;
	}
	
	private int countIpOccurance(String ipAddress, List<Router> routers)
	{
		int ipCount = 0;
		
		for (int i = 0 ; i < routers.size() ; i ++)
		{
			if (routers.get(i).getIpAddress().equals(ipAddress))
			{
				ipCount ++;
			}
		}
		
		return ipCount;
	}

}
