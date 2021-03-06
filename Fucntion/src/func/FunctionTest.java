package func;

import static org.junit.Assert.*;

import org.junit.Test;

public class FunctionTest {

	@Test
	public void testFuctionWeekMonday() 
	{
		String res = Function.week(0); 
		assertEquals("Monday", res);
	}
	@Test
	public void testFuctionWeekThuersday() 
	{
		String res = Function.week(1); 
		assertEquals("Tuesday", res);
	}
	@Test
	public void testFuctionWeekWensday() 
	{
		String res = Function.week(2); 
		assertEquals("Wednesday", res);
	}
	@Test
	public void testFuctionWeekThursday() 
	{
		String res = Function.week(3); 
		assertEquals("Thursday", res);
	}
	@Test
	public void testFuctionWeekFriday() 
	{
		String res = Function.week(4); 
		assertEquals("Friday", res);
	}
	@Test
	public void testFuctionWeekSaturday() 
	{
		String res = Function.week(5); 
		assertEquals("Saturday", res);
	}
	@Test
	public void testFuctionWeekSunday() 
	{
		String res = Function.week(6); 
		assertEquals("Sunday", res);
	}
	@Test
	public void testFuctionWeekSeven() 
	{
		String res = Function.week(7); 
		assertEquals("Wrong day number", res);
	}

}
