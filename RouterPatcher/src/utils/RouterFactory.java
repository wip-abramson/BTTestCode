package utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import exceptions.FieldValueException;
import main.Router;

public class RouterFactory
{
	private static final Logger logger = Logger.getLogger(RouterFactory.class.getName());

	public static Router createRouter(String [] values)
    {
        Router router = null;
        logger.log(Level.INFO, " Field Values :" + values[0] + "," + values[1] + "," + values[2] + "," + values[3]);
        try
        {
            router = new Router();

            router.setHostname(trimField(values[0]));
            router.setIpAddress(trimField(values[1]));
            router.setPatched(isPatched(trimField(values[2])));
            router.setOsSystem(Float.valueOf(trimField(values[3])));

            // sometimes if notes is empty length is only 4
            // notes is aloud to be empty
            if (values.length == 5)
            {
                router.setNotes(values[4].trim());
            }

        }
        catch (FieldValueException e)
        {
            logger.log(Level.WARNING, "FieldValueException : " + e.getMessage());
            router = null;
        }
        catch (Exception e)
        {
            // Finer grain exceptions?
            router = null;
            logger.log(Level.WARNING,"Unable to create Router, invalid field values " + e.getMessage());
        }

        return router;
    }
	
	/**
	 * trims whitespace from fields 
	 * 
	 * @param field
	 * @return
	 * @throws FieldValueException An empty value after trim throws an exception
	 */
	private static String trimField(String field) throws FieldValueException
	{
		String trimmed = field.trim();
		if (trimmed.isEmpty())
		{
			throw new FieldValueException("Field Value is Empty");
		}
		else
		{
			return trimmed;
		}
	}

    private static boolean isPatched(String patched) throws FieldValueException
    {
    	if (patched != null)
    	{
    		patched = patched.toLowerCase();

            if (patched.equals("no"))
            {
                return false;
            }
            else if (patched.equals("yes"))
            {
                return true;
            }
            else
            {
                throw new FieldValueException("Patched is neither yes or no!");
            }
    	}
    	else
    	{
            throw new FieldValueException("Patched is neither yes or no!");
    	}
        
    }
}
