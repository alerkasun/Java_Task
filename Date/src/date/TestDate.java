package date;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDate {

	@Test
	public void testDate() {
		String res = Date.dateByWords(1, 1, 2014);
		assertEquals("First of January twenty fourteen", res);
	}

}
