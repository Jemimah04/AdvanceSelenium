package Generic_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {
	
	/**
	 * this method is used for login the application
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Jemimah
	 */
	public String getKeyAndValuePair(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Daniel\\Desktop\\PropertiesFile\\VTigerPropertiesfile.properties");
		Properties prop= new Properties();
		prop.load(fis);
		String Value = prop.getProperty(key);
		return Value;
	}
}
