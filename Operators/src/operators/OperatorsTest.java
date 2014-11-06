package operators;

import static org.junit.Assert.*;
import org.junit.Test;

public class OperatorsTest {

	@Test
	public void testOperatorsCountOddFirst() 
	{
		int res = Operators.count(3, 5); 
		assertEquals(8, res);
	}

	@Test
	public void testOperatorsCountOddSecond() 
	{
		int res = Operators.count(4, 3); 
		assertEquals(12, res);
	}
	@Test
	public void testOperatorsCount0_0() 
	{
		int res = Operators.count(0, 0); 
		assertEquals(0, res);
	}
	@Test
	public void testOperatorsCount4_0() 
	{
		int res = Operators.count(4, 0); 
		assertEquals(0, res);
	}
	@Test
	public void testOperatorsCountminus() 
	{
		int res = Operators.count(-4, 2); 
		assertEquals(-8, res);
	}
}