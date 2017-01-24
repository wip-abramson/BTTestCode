package main;



import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import checkcriteria.ICheckCriteria;
import checkcriteria.imp.CheckCriteria;
import criteria.ICriteria;
import criteria.impl.HostNameCriteria;
import criteria.impl.IpCriteria;
import criteria.impl.OsVersionCriteria;
import criteria.impl.PatchedCriteria;
import utils.CsvParser;
import utils.RouterFactory;

/**
 * Created by will on 20/01/17.
 */
public class RouterPatcher
{

    private static Logger logger = Logger.getLogger(RouterPatcher.class.getName());

    public static void main(String[] args)
    {
        String csvFile = args[0];
        List<String[]> routersFieldsValues = CsvParser.parseCsv(csvFile);
        
        List<Router> routers = buildRoutersFromFields(routersFieldsValues);

        logger.log(Level.INFO, routers.size() + " Routers parsed from file");

        printRouters(findPatchableRouters(routers));
        
    }
    
    private static List<Router> buildRoutersFromFields(List<String[]> routersFieldsValues)
	{
    	List<Router> routers = new ArrayList<Router>();
    	
		for (String[] fieldValues : routersFieldsValues)
		{
			Router router = RouterFactory.createRouter(fieldValues);
			
			if (router != null)
			{
				routers.add(router);
				logger.log(Level.INFO, "Router Added");
			}
		}
		
		logger.log(Level.INFO, routers.size() + " Routers Created");
		return routers;
	}

    /**
     * Prints out string with a router formatted per row
     * @param routers
     */
	private static void printRouters(List<Router> routers)
    {
    	String patchableRouters = "";
    	
    	for (Router router : routers)
    	{
    		patchableRouters += router.toString();
    		patchableRouters += "\n";
    	}
    	
    	logger.log(Level.INFO, patchableRouters);
    	System.out.println(patchableRouters);
    }
    
	/**
	 * checks all routers against the list of criteria
	 * 
	 * @param routers
	 * @return list of routers that pass the criteria
	 */
    private static List<Router> findPatchableRouters(List<Router> routers)
    {
    	List<ICriteria> criteria = addCriteria();
    	
    	ICheckCriteria checkCriteria = new CheckCriteria(criteria);
    	
    	return checkCriteria.checkPatchCriteria(routers);
    }
    
    /**
     * Creates list of criteria to check routers against
     * 
     * @return
     */
    private static List<ICriteria> addCriteria()
    {
    	List<ICriteria> criteria = new ArrayList<ICriteria>();
    	
    	criteria.add(new HostNameCriteria());
    	criteria.add(new IpCriteria());
    	criteria.add(new OsVersionCriteria());
    	criteria.add(new PatchedCriteria());
    	
    	return criteria;
    }


}
