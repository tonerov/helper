package readers;
import org.junit.Assert;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class ConfigReaderTest {
	final String path = "/src/test/resources/readers/configReader.conf";
	
	@Test
	public void getValue() {
		ConfigReader reader = new ConfigReader(path);
		assertEquals(reader.getValue("a"), "a");
		assertEquals(reader.getValue("b"), "b");
		assertEquals(reader.getValue("c"), "c");
		assertEquals(reader.getValue("abc"), "a");
		assertEquals(reader.getValue("none"), "");
	}
	@Test
	public void getValues() {
		ConfigReader reader = new ConfigReader(path);
		Assert.assertArrayEquals(reader.getValues("a"), new String[]{"a"});
		Assert.assertArrayEquals(reader.getValues("b"), new String[]{"b"});
		Assert.assertArrayEquals(reader.getValues("c"), new String[]{"c"});
		Assert.assertArrayEquals(reader.getValues("abc"), new String[]{"a","b","c"});
		Assert.assertArrayEquals(reader.getValues("qwe"), new String[]{"q","w ,e"});
		Assert.assertArrayEquals(reader.getValues("none"), new String[0]);
		assertEquals(reader.getValues("none").length, 0);
		}

}
