package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtilies
{
	/**
	 * This method is used to read the data from the property file
	 * @author Arvind
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstants.proFilePath);
		Properties pobj = new Properties();
		
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}

}
