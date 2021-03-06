package loop;

import static org.junit.Assert.*;

import org.junit.Test;

public class testLoop {

	@Test
	public void testEven() 
	{
		String res = Loop.even();
		assertEquals("Summ = 2450 Quantity = 49", res);
	}
	@Test
	public void testIsPrime_0() 
	{
		Boolean res = Loop.isPrime(0);
		assertEquals(false, res);
	}
	@Test
	public void testIsPrime_1() 
	{
		Boolean res = Loop.isPrime(1);
		assertEquals(false, res);
	}
	@Test
	public void testIsPrime_2() 
	{
		Boolean res = Loop.isPrime(2);
		assertEquals(true, res);
	}
	@Test
	public void testIsPrime_3() 
	{
		Boolean res = Loop.isPrime(3);
		assertEquals(true, res);
	}
	@Test
	public void testIsPrime_4() 
	{
		Boolean res = Loop.isPrime(4);
		assertEquals(false, res);
	}
	@Test
	public void testIsPrime_5() 
	{
		Boolean res = Loop.isPrime(5);
		assertEquals(true, res);
	}
	@Test
	public void testIsPrime_3571() 
	{
		Boolean res = Loop.isPrime(3571);
		assertEquals(true, res);
	}
	@Test
	public void testIsPrime_minus1() 
	{
		Boolean res = Loop.isPrime(-1);
		assertEquals(false, res);
	}
	@Test
	public void testRootOfPositiveWholeNumber0() 
	{
		long res = Loop.rootOfPositiveWholeNumber(0);
		assertEquals(0, res);
	}
	@Test
	public void testRootOfPositiveWholeNumber1() 
	{
		long res = Loop.rootOfPositiveWholeNumber(1);
		assertEquals(1, res);
	}
	@Test
	public void testRootOfPositiveWholeNumber2() 
	{
		long res = Loop.rootOfPositiveWholeNumber(9);
		assertEquals(3, res);
	}
	@Test
	public void testFactorial_0() 
	{
		long res = Loop.factorial(0);
		assertEquals(1, res);
	}
	@Test
	public void testFactorial_1() 
	{
		long res = Loop.factorial(1);
		assertEquals(1, res);
	}
	@Test
	public void testFactorial_2() 
	{
		long res = Loop.factorial(2);
		assertEquals(2, res);
	}
	@Test
	public void testFactorial_3() 
	{
		long res = Loop.factorial(3);
		assertEquals(6, res);
	}
	@Test
	public void testFactorial_6() 
	{
		long res = Loop.factorial(6);
		assertEquals(720, res);
	}
	@Test
	public void testFactorial_minus_1() 
	{
		long res = Loop.factorial(-1);
		assertEquals(1, res);
	}
	
	@Test
	public void testSumma_15() 
	{
		long res = Loop.sumofnumbers(15);
		assertEquals(6, res);
	}
	@Test
	public void testSumma_5() 
	{
		long res = Loop.sumofnumbers(5);
		assertEquals(5, res);
	}
	@Test
	public void testSumma_999() 
	{
		long res = Loop.sumofnumbers(999);
		assertEquals(27, res);
	}
	@Test
	public void testSumma_0() 
	{
		long res = Loop.sumofnumbers(0);
		assertEquals(0, res);
	}
	@Test
	public void testSumma_minus5() 
	{
		long res = Loop.sumofnumbers(-5);
		assertEquals(5, res);
	}
	@Test
	public void testSumma_minus51() 
	{
		long res = Loop.sumofnumbers(-51);
		assertEquals(6, res);
	}
	@Test
	public void testReverse_159() 
	{
		long res = Loop.reverse(159);
		assertEquals(951, res);
	}
	@Test
	public void testReverse_111() 
	{
		long res = Loop.reverse(111);
		assertEquals(111, res);
	}
	@Test
	public void testReverse_0() 
	{
		long res = Loop.reverse(0);
		assertEquals(0, res);
	}
}



