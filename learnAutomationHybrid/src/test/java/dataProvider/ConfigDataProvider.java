package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() {
		
		File scr = new File(System.getProperty("user.dir")+ "/Configration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(scr);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Failed to load the config file" +e.getMessage());
				}
		
	}
	public String getTestApplicationUrl() {
		
		String data =pro.getProperty("testURL");
		
		return data;
			}
public String getUatApplicationUrl() {
		
		String data =pro.getProperty("uatURL");
		
		return data;
			}
public String getProtApplicationUrl() {
	
	String data =pro.getProperty("prodURL");
	
	return data;
		}

public String getValueKey(String key) {
	String data =pro.getProperty(key);
	
	return data;
}

}
