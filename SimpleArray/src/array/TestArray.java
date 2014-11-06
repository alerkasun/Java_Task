package array;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestArray {

	@Test(expected = IllegalArgumentException.class)
	public void testnull() {
		Array.minElement(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test0() {
		Array.minElement(new int[] {});
	}
	
	@Test
	public void test1() {
		int res = Array.minElement(new int[] {1});
		assertEquals(1, res);
	}
	@Test
	public void test2() {
		int res = Array.minElement(new int[] {5,6});
		assertEquals(5, res);
	}
	@Test
	public void test3() {
		int res = Array.minElement(new int[] {127,128, 699});
		assertEquals(127, res);
	}
	@Test
	public void test4() {
		int res = Array.minElement(new int[] {78, 25, 31, 25});
		assertEquals(25, res);
	}
	@Test
	public void test5() {
		int res = Array.minElement(new int[] {178, 189, 3198, 2985});
		assertEquals(178, res);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void maxTestNull() {
		Array.maxElement(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void maxTest_0() {
		Array.maxElement(new int[] {});
	}
	
	@Test
	public void testmax1() {
		int res = Array.maxElement(new int[] {8});
		assertEquals(8, res);
	}
	
	@Test
	public void testmax2() {
		int res = Array.maxElement(new int[] {8, 99});
		assertEquals(99, res);
	}
	
	@Test
	public void testmax3() {
		int res = Array.maxElement(new int[] {8, 99, 98});
		assertEquals(99, res);
	}
	
	@Test
	public void testmax4() {
		int res = Array.maxElement(new int[] {1, -2, 3, -9});
		assertEquals(3, res);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMaxIndexElementNull() {
		Array.maxElement(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMaxIndexElement_0() {
		Array.maxElement(new int[] {});
	}
	
	
	@Test
	public void testMaxIndexElement_1() {
		int res = Array.maxIndexElement(new int[] {1});
		assertEquals(0, res);
	}
	
	@Test
	public void testMaxIndexElement_2() {
		int res = Array.maxIndexElement(new int[] {1, 90});
		assertEquals(1, res);
	}
	
	@Test
	public void testMaxIndexElement_3() {
		int res = Array.maxIndexElement(new int[] {1, 90, 2525});
		assertEquals(2, res);
	}
	
	@Test
	public void testMaxIndexElement_4() {
		int res = Array.maxIndexElement(new int[] {1000, 90, 225, -9});
		assertEquals(0, res);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testMinIndexElementNull() {
		Array.maxElement(null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testMinIndexElement_0() {
		Array.maxElement(new int[] {});
	}
	@Test
	public void testMinIndexElement_1() {
		int res = Array.minIndexElement(new int[] {1000});
		assertEquals(0, res);
	}
	@Test
	public void testMinIndexElement_2() {
		int res = Array.minIndexElement(new int[] {1, 9});
		assertEquals(0, res);
	}
	@Test
	public void testMinIndexElement_3() {
		int res = Array.minIndexElement(new int[] {1, 9, 2});
		assertEquals(0, res);
	}
	
	@Test
	@Ignore
	public void testsumOddElement() {
		int res = Array.sumOddElement(new int[] {1, 9, 2, 5, 7, 1, 1});
		System.out.println(res);
		assertEquals(0, res);
	}
}
