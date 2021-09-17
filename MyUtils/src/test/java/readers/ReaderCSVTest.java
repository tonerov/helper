package readers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class ReaderCSVTest {
	String currentDir = System.getProperty("user.dir").replace("\\", "/");
	String csv1Path = "/src/test/resources/csvOsebe1.csv";
	String fullPath1 = currentDir + csv1Path;
	String[] keysT1 =  {"Ime", "DatumRojstva", "Priimek", "Email", "Naslov", "DatumLast", "DatumFirst", "Telefon"};
	String[] valsT1 =  {"Rosella", "1.1.2000", "Burks", "BurksR@univ.edu", "Ulica 1, 1292 Ig", "20.09.2021", "20.06.2021", "963.555.1253"};
 
	@Test
	public void testReadCSV() {
		assertNotNull(ReaderCSV.readCSV(fullPath1));
		assertFalse(ReaderCSV.readCSV(fullPath1).isEmpty());
		assertNotNull(ReaderCSV.readCSV("fake/path.csv"));
		assertTrue(ReaderCSV.readCSV("fake/path.csv").isEmpty()); 
	}


	@Test 
	public void testReadCSVtooMapList() {
		List<Map<String, String>> readed = ReaderCSV.readCSVtooMapList(fullPath1);
		assertEquals(readed.size(), 40);
		assertEquals(readed.get(0).size(), 8);
		Set<String> keys = new HashSet<> (Arrays.asList(keysT1));
		Collection<String> vals = new HashSet<>(Arrays.asList(valsT1));
		assertEquals(readed.get(0).keySet(), keys);
		assertTrue(readed.get(0).values().containsAll(vals));
	}
	
	@Test
	public void testTwoArraysTooMap() {
		Map<String, String> map = ReaderCSV.twoArraysTooMap(keysT1, valsT1);
		assertNotNull(map);
		assertEquals(map.get("DatumLast"), "20.09.2021");
	}
	@Test
	public void testNonPath() {
	}

}
