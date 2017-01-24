package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by will on 20/01/17.
 */
public class CsvParser
{

    private static Logger logger = Logger.getLogger(CsvParser.class.getName());

    public static List<String[]> parseCsv(String csvFile)
    {
        List<String[]> routerFieldValues = new ArrayList<String[]>();
        FileReader fr = null;
        BufferedReader br = null;

        String line = "";
        String splitCsv = ",";

        try
        {
            fr = new FileReader(csvFile);
            br = new BufferedReader(fr);

            // skip first line for fields
            line = br.readLine();

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] fieldValues = line.split(splitCsv);

                if (fieldValues != null && fieldValues.length != 1)
                {
                	routerFieldValues.add(fieldValues);
                }
               
            }
        }
        catch (FileNotFoundException e)
        {
            logger.log(Level.WARNING, e.getMessage());
        }
        catch (IOException e)
        {
            logger.log(Level.WARNING, e.getMessage());
        }
        finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    logger.log(Level.WARNING, e.getMessage());
                }
            }
        }

        return routerFieldValues;
    }
}
