package Resources;

import java.io.FileInputStream;
import java.util.Properties;

public class Utils {

public static String getGlobalValue(String key) throws Exception {
		
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\ROHIT\\eclipse-workspace\\Cucumber\\src\\test\\java\\Resources\\global.properties");
		p.load(fis);
		return p.getProperty(key);
		
		
	}

}
