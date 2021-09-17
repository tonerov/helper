package readers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/*
 * Config reader for personal use on windows machine
 * splits resaults by "," but ignores split if ecape char is used befor
 * Ecape char = "/"
 */
public class ConfigReader {
	final String defaultFileName = "Config.conf";
	private Properties prop;
	private String fullPath;
	public ConfigReader(String path) {
		fullPath = System.getProperty("user.dir").replace("\\", "/") + path;
		InputStream inputStream;
		prop = new Properties();
		String propFileName = fullPath;
		try {
			inputStream = new FileInputStream(propFileName);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return;
		}
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
	public String getValue(String ukaz) {
		String[] v = getValues(ukaz);
		if (v==null ||v.length == 0 ) return "";
		return v[0];
	}
	public String[] getValues(String ukaz) {
		String[] x = new String[0];
		try {
			String[] r = prop.getProperty(ukaz).stripTrailing().split("(?<!/),");// negative lookbehind
																	// (?<!/) == if its "/" before comma ignor split 
			for (int index =0; index < r.length; index++){
				  r[index] = r[index].replace('/',' ');//URLEncoder.encode(test[index], "UTF-8");
				}
			if (r.length == 1 && r[0] == "") return null;
			return r;
		}catch (NullPointerException e) {
			return x;
		}
	}
}
