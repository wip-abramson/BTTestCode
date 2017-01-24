package utils;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class CsvParserTest
{

	String csvFileWithBlankLine = "testdata/blankLines.csv";
	
	String csvEmptyFields = "testdata/emptyFields.csv";

	@Test
	public void testParseCsvWithBlankLines()
	{
		List<String[]> routerFields = CsvParser.parseCsv(getCsvWithBlankLine());
		
		assertTrue(routerFields.size() == 4);
		

	}
	
	@Test
	public void testParseCsvWithEmptyFields()
	{
		
		List<String[]> routerFields = CsvParser.parseCsv(getCsvWithEmptyFields());
		
		assertTrue(routerFields.size() == 4);
		
	}
	
	private String getCsvWithBlankLine()
	{
		String csv = getClass().getResource(csvFileWithBlankLine).getPath();
		return csv;
	}
	
	private String getCsvWithEmptyFields()
	{
		String csv = getClass().getResource(csvEmptyFields).getPath();
		return csv;
	}

}
