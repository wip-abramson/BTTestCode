package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class RouterFactoryTest
{

	String[] acceptedFields = {"ABc","1.2.3.4","no","12.0","this works"};
	
	String[] acceptedFieldsNoNotes = {"ABc","1.2.3.4","no","12.0"};
	
	String[] fieldsInvalidPatchedValue = {"ABc","1.2.3.4","not sure","12.0","Invalid Patched field"};
	
	String[] fieldsInvalidOs = {"ABc","1.2.3.4","no","Not number","invalid os version"};
	
	String[] fieldsEmptyHostName = {"   ", "1.2.3.4","no","Not number","Empty host" };
	
	@Test
	public void testCreateRouter()
	{
		assertNotNull(RouterFactory.createRouter(acceptedFields));
		assertNotNull(RouterFactory.createRouter(acceptedFieldsNoNotes));
		assertNull(RouterFactory.createRouter(fieldsInvalidPatchedValue));
		assertNull(RouterFactory.createRouter(fieldsInvalidOs));
		assertNull(RouterFactory.createRouter(fieldsEmptyHostName));
	}

}
