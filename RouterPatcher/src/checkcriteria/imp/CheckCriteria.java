package checkcriteria.imp;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import checkcriteria.ICheckCriteria;
import criteria.ICriteria;
import main.Router;

public class CheckCriteria implements ICheckCriteria
{
	private static final Logger logger = Logger.getLogger(CheckCriteria.class.getName());

	private final List<ICriteria> criteriaToCheck;
	
	public CheckCriteria(List<ICriteria> criteria) 
	{
		this.criteriaToCheck = criteria;
	}
	
	/**
	 * checks list of routers against all the different criteria
	 * returns list of routers that pass all criteria
	 */
	@Override
	public List<Router> checkPatchCriteria(List<Router> routers)
	{
		List<Router> routersToPatch = routers;

		for (ICriteria criteria : criteriaToCheck)
		{
			routersToPatch = criteria.checkCriteria(routersToPatch);
		}

		logger.log(Level.INFO, routersToPatch.size() + " Routers that can be patched");

		return routersToPatch;

	}

	
}
