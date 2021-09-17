package readers;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;

public class ReaderCSV {
	public ReaderCSV() {
 
	}
	public static Map<String, String> twoArraysTooMap(String[] keys, String[] values) {
        if(keys.length != values.length){
        	System.out.println("ni vredu velikost 2Arrays2Map");
        }
		Map<String, String> map = new HashMap<String, String>();
    	for(int index = 0; index < keys.length; index++){
    		map.put(keys[index], values[index]);
    	}
    	return map;
	}
	public static List<Map<String, String>> readCSVtooMapList(String path) {
		List<String[]> r = readCSV(path);
        List<Map<String, String>> pairs = new ArrayList<Map<String, String>>(); 
        for (int i = 1; i<r.size(); i++) {
            pairs.add(twoArraysTooMap(r.get(0), r.get(i)));
        }
        return pairs;
	}
	public static List<String[]> readCSV(String path) {
		List<String[]> r = new ArrayList<>();
		try (CSVReader reader = new CSVReader(new FileReader(path))) {
            r = reader.readAll();
            if (r == null) {
            	return r;
            }
            return r; 
		}catch(Exception e) {
			return r;
		}
	}
}
