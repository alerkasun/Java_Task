package array;

import static org.junit.Assert.*;

import java.util.Arrays;

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
	public void testsumOddElementOneElement() {
		int res = Array.getSum(new int[] {1});
		assertEquals(0, res);
	}
	@Test
	public void testsumOddElementTwoElement() {
		int res = Array.getSum(new int[] {1, 2});
		assertEquals(2, res);
	}
	@Test
	public void testsumOddElementTheeElement() {
		int res = Array.getSum(new int[] {1, 2, 3});
		assertEquals(2, res);
	}
	
	@Test
	public void testsumOddElementNegative() {
		int res = Array.getSum(new int[] {1, 2, 3, -4});
		assertEquals(-2, res);
	}
	@Test
	public void testsumOddElementNull() {
		int res = Array.getSum(new int[] {1, 0, 3, 0});
		assertEquals(0, res);
	}
	@Test
	public void testreverse2Elements() {
		int[] res = Array.reverse(new int[]{1, 5});
		System.out.println( Arrays.toString( res ) );
		assertTrue(Arrays.equals(res, new int[]{5,1}));
	}
	@Test
	public void testreverseTheeElements() {
		int[] res = Array.reverse(new int[]{1, 5, 9});
		System.out.println( Arrays.toString( res ) );
		assertTrue(Arrays.equals(res, new int[]{9, 5, 1}));
	}
	
	@Test
	public void testreverseFourElements() {
		int[] res = Array.reverse(new int[]{1, 5, 9, 98});
		System.out.println( Arrays.toString( res ) );
		assertTrue(Arrays.equals(res, new int[]{98, 9, 5, 1}));
	}
	@Test
	public void testreverseAllOne() {
		int[] res = Array.reverse(new int[]{1, 1, 1, 1});
		System.out.println( Arrays.toString( res ) );
		assertTrue(Arrays.equals(res, new int[]{1, 1, 1, 1}));
	}
	@Test
	public void testreverseAllElementNegative() {
		int[] res = Array.reverse(new int[]{-1, -9, -15, -61});
		assertTrue(Arrays.equals(res, new int[]{-61, -15, -9, -1}));
	}
}
