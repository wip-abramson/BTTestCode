package criteria;

import java.util.List;

import main.Router;


/**
 * Created by will on 22/01/17.
 * 
 * Interface for that all criteria deciding if a router can be patched extend
 */
public interface ICriteria
{

	/**
	 * Takes in a list of routers and returns all routers that pass the criteria
	 * 
	 * @param routers
	 * @return
	 */
    public List<Router> checkCriteria(List<Router> routers);


}
