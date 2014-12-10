import static org.junit.Assert.*;

import org.junit.Test;


public class OperationsTest {

	@Test
	public void test_getResult1()
	{
		assertEquals (0,Operations.getRusult(0, 4, "/"));
	}
	
	@Test
	public void test_getResult2() 
	{
		assertEquals (0,Operations.getRusult(4, 0, "/"));
	}
	
	@Test
	public void test_getResult3() {
		assertEquals (0,Operations.getRusult(0, 0, "/"));
	}
	
	@Test
	public void test_getResult4() {
		assertEquals (2,Operations.getRusult(8, 4, "/"));
	}

	@Test
	public void test_getResult5() {
		assertEquals (12,Operations.getRusult(4, 8, "+"));
	}
	
	@Test
	public void test_getResult6() {
		assertEquals (-4,Operations.getRusult(4, 8, "-"));
	}
	
	@Test
	public void test_getResult7() {
		assertEquals (32,Operations.getRusult(4, 8, "*"));
	}
	
	@Test
	public void test_getResult8() {
		assertEquals (0,Operations.getRusult(0, 6, "*"));
	}
	
	@Test
	public void test_getResult9() {
		assertEquals (2469134,Operations.getRusult(1234567, 1234567, "+"));
	}
	
}
