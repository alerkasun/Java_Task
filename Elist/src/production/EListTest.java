package production;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith (Parameterized.class)
public class EListTest 
{
	EList ee = null;
	public EListTest(String str) throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		this.ee = (EList) Class.forName(str).newInstance();
	}
	
	@Parameters ( name = "{index} is {0}")
	public static Iterable<Object[]> data1() 
	{
		return Arrays.asList(new Object[][] { 
			{"production.AList0"}, 
			{"production.AList1"}, 
			{"production.AList2"}
		});
	}
	
	// ------size
	@Test
	public void testSize_null() 
	{
		int[] ini = null;
		ee.init(ini);
		int act = ee.size();
		assertEquals(0, act);
	}
	
	@Test
	public void testSize_0() 
	{
		int[] ini = {};
		ee.init(ini);
		int act = ee.size();
		assertEquals(0, act);
	}
	@Test
	public void testSize_1() 
	{
		int[] ini = {10};
		ee.init(ini);
		int act = ee.size();
		assertEquals(1, act);
	}
	@Test
	public void testSize_2() 
	{
		int[] ini = {10,20};
		ee.init(ini);
		int act = ee.size();
		assertEquals(2, act);
	}
	@Test
	public void testSize_many() 
	{
		int[] ini = {10,20,30,77,11,97,24};
		ee.init(ini);
		int act = ee.size();
		assertEquals(7, act);
	}

	// toArray
	
	@Test
	public void testToArray_null() 
	{
		int[] ini = null;
		ee.init(ini);
		int[] act = ee.toArray();
		int[] exp = {};
		assertArrayEquals(exp, act);
	}
	@Test
	public void testToArray_0() 
	{
		int[] ini = {};
		ee.init(ini);
		int[] act = ee.toArray();
		int[] exp = {};
		assertArrayEquals(exp, act);
	}
	@Test
	public void testToArray_1() 
	{
		int[] ini = {10};
		ee.init(ini);
		int[] act = ee.toArray();
		int[] exp = {10};
		assertArrayEquals(exp, act);
	}
	@Test
	public void testToArray_2() 
	{
		int[] ini = {10,20};
		ee.init(ini);
		int[] act = ee.toArray();
		int[] exp = {10,20};
		assertArrayEquals(exp, act);
	}
	@Test
	public void testToArray_many() 
	{
		int[] ini = {10,20,30,77,11,97,24};
		ee.init(ini);
		int[] act = ee.toArray();
		int[] exp = {10,20,30,77,11,97,24};
		assertArrayEquals(exp, act);
	}

	// addStart

	@Test
	public void testAddStart_null() 
	{
		int[] ini = null;
		ee.init(ini);
		ee.addStart(7);
		assertEquals(1, ee.size());
		int[] act = ee.toArray();
		int[] exp = {7};
		assertArrayEquals(exp, act);
	}
	@Test
	public void testAddStart_0() 
	{
		int[] ini = {};
		ee.addStart(7);
		assertEquals(1, ee.size());
		int[] act = ee.toArray();
		int[] exp = {7};
		assertArrayEquals(exp, act);
	}
	@Test
	public void testAddStart_1() 
	{
		int[] ini = {10};
		ee.init(ini);
		ee.addStart(7);
		assertEquals(2, ee.size());
		int[] act = ee.toArray();
		int[] exp = {7,10};
		assertArrayEquals(exp, act);
	}
	@Test
	public void testAddStart_2() 
	{
		int[] ini = {10,20};
		ee.init(ini);
		ee.addStart(7);
		assertEquals(3, ee.size());
		int[] act = ee.toArray();
		int[] exp = {7,10,20};
		assertArrayEquals(exp, act);
	}
	@Test
	public void testAddStart_many() 
	{
		int[] ini = {10,20,30,77,11,97,24};
		ee.init(ini);
		ee.addStart(7);
		assertEquals(8, ee.size());
		int[] act = ee.toArray();
		int[] exp = {7,10,20,30,77,11,97,24};
		assertArrayEquals(exp, act);
	}

	// addEnd
	@Test
	public void testAddEnd_null() 
	{
		int[] ini = null;
		ee.init(ini);
		ee.addEnd(7);
		assertEquals(1, ee.size());
		int[] act = ee.toArray();
		int[] exp = {7};
		assertArrayEquals(exp, act);
	}

	@Test
	public void testAddEnd_0() 
	{
		int[] exp = {0};
		ee.addEnd(0);
		assertArrayEquals(exp,ee.toArray());
	}
	
	@Test
	public void testAddEnd_1() 
	{
		int[] ini = {10};
		ee.init(ini);
		ee.addEnd(7);
		assertEquals(2, ee.size());
		int[] act = ee.toArray();
		int[] exp = {10,7};
		assertArrayEquals(exp, act);
	}
	@Test
	public void testAddEnd_2() 
	{
		int[] ini = {10,20};
		ee.init(ini);
		ee.addEnd(7);
		assertEquals(3, ee.size());
		int[] act = ee.toArray();
		int[] exp = {10,20,7};
		assertArrayEquals(exp, act);
	}
	@Test
	public void testAddEnd_many() 
	{
		int[] ini = {10,20,30,77,11,97,24};
		ee.init(ini);
		ee.addEnd(7);
		assertEquals(8, ee.size());
		int[] act = ee.toArray();
		int[] exp = {10,20,30,77,11,97,24,7};
		assertArrayEquals(exp, act);
	}

	//------add pos
	@Test
	public void testAddPos() {
		int[] act = {1,2};
		int[] exp = {1,2};
		ee.init(act);
		ee.addPos(0, 2);
		assertArrayEquals(exp,ee.toArray());
	}

	@Test
	public void testDelStart() {
		int[] act = {1,2};
		int[] exp = {2};
		ee.init(act);
		ee.delStart();
		assertArrayEquals(exp,ee.toArray());
	}

	@Test
	public void testDelEnd() {
		int[] act = {1,2};
		int[] exp = {1};	
		ee.init(act);
		ee.delEnd();
		assertArrayEquals(exp,ee.toArray());
	}

	@Test
	public void testDelPos() {
		int[] act = {1,2,3,4};
		int[] exp = {1,2,4};
		ee.init(act);
		ee.delPos(3);
		assertArrayEquals(exp,ee.toArray());
	}

	@Test
	public void testGetMin_null()
	{
		int[] act = null;
		ee.init(act);
		assertEquals(0, ee.minValue());
	}
	
	@Test
	public void testGetMin_0()
	{
		int[] act = {};
		ee.init(act);
		assertEquals(0, ee.minValue());
	}
	
	@Test
	public void testGetMin_1()
	{
		int[] act = {32};
		ee.init(act);
		assertEquals(32, ee.minValue());
	}
	
	@Test
	public void testGetMin_2()
	{
		int[] act = {32,54};
		
		ee.init(act);
		assertEquals(32, ee.minValue());
	}
	
	@Test
	public void testGetMin_many()
	{
		int[] act = {32,54,13,42,23,66,23};
		
		ee.init(act);
		assertEquals(13, ee.minValue());
	}

	@Test
	public void testGetMaxIndex_null()
	{
		int[] act = null;
		
		ee.init(act);
		assertEquals(0, ee.maxValue());
	}
	
	@Test
	public void testGetMaxIndex_0()
	{
		int[] act = {};
		
		ee.init(act);
		assertEquals(0, ee.maxValue());
	}
	
	@Test
	public void testGetMaxIndex_1()
	{
		int[] act = {32};
		
		ee.init(act);
		assertEquals(1, ee.maxIndex());
	}
	

	@Test
	public void testGetMinIndex_null()
	{
		int[] act = null;
		
		ee.init(act);
		assertEquals(0, ee.minIndex());
	}
	
	@Test
	public void testGetMinIndex_0()
	{
		int[] act = {};
		
		ee.init(act);
		assertEquals(0, ee.minIndex());
	}
	
	@Test
	public void testGetMinIndex_1()
	{
		int[] act = {32};

		ee.init(act);
		assertEquals(1, ee.minIndex());
	}
	
	@Test
	public void testGetMinIndex_2()
	{
		int[] act = {32,54};
		
		ee.init(act);
		assertEquals(1, ee.minIndex());
	}
	
	@Test
	public void testGetMinIndex_many()
	{
		int[] act = {32,54,13,42,23,66,23};
		
		ee.init(act);
		assertEquals(3, ee.minIndex());
	}

	@Test
	public void testGetMaxIndex_2()
	{
		int[] act = {32,54};
		
		ee.init(act);
		assertEquals(2, ee.maxIndex());
	}
	
		@Test
		public void testGetMaxIndex_many()
		{
			int[] act = {32,54,13,42,23,66,23};
			
			ee.init(act);
			assertEquals(6, ee.maxIndex());
		}
	

		@Test
		public void testReverse_null()
		{
			int[] act = null;
			int[] exp = null;
			
			ee.init(act);
			ee.reverse();
			assertArrayEquals(exp,act);
		}
		
		@Test
		public void testReverse_0()
		{
			int[] act = {};
			int[] exp = {};
			
			ee.init(act);
			assertArrayEquals(exp,ee.toArray());
		}

@Test
		public void testPartChange_null()
		{
			int[] act = null;
			int[] exp = null;
			
			ee.init(act);
			ee.changeparts();
			assertArrayEquals(exp,act);
		}

@Test
public void testSortBuble_null()
{
	int[] act = null;
	int[] exp = null;
	
	ee.init(act);
	exp = ee.toArray();
	ee.sortBubble();
	assertArrayEquals(exp,ee.toArray());
}

@Test
public void testSortBuble_0()
{
	int[] act = {};
	int[] exp = {};
	
	ee.init(act);
	exp = ee.toArray();
	ee.sortBubble();
	assertArrayEquals(exp,ee.toArray());
}

@Test
public void testSortBuble_1()
{
	int[] act = {6};
	int[] exp = {6};
	
	ee.init(act);
	ee.sortBubble();
	assertArrayEquals(exp,ee.toArray());
}

@Test
public void testSortBuble_2()
{
	int[] act = {6,4};
	int[] exp = {4,6};
	
	ee.init(act);
	ee.sortBubble();
	assertArrayEquals(exp,ee.toArray());
}

@Test
public void testSortBuble_many()
{
	int[] act = {7,6,8,9,5,2,3,1,4};
	int[] exp = {1,2,3,4,5,6,7,8,9};
	
	ee.init(act);
	ee.sortBubble();
	assertArrayEquals(exp,ee.toArray());
}

	@Test
	public void testSortSelectNull() 
	{
		int[] act = null;
		int[] exp = null;
		
		ee.init(act);
		exp = ee.toArray();
		ee.sortBubble();
		assertArrayEquals(exp,ee.toArray());
	}
	
	/*------------------- sortInsert -------------------*/ 	
	@Test
	public void testSortInsert_null()
	{
		int[] act = null;
		int[] exp = null;
				
		ee.init(act);
		exp = ee.toArray();
		ee.sortInsert();
		assertArrayEquals(exp,ee.toArray());
	}
			
	@Test
	public void testSortInsert_0()
	{
		int[] act = {};
		int[] exp = {};
				
		ee.init(act);
		exp = ee.toArray();
		ee.sortInsert();
		assertArrayEquals(exp,ee.toArray());
	}
			
	@Test
	public void testSortInsert_1()
	{
		int[] act = {6};
		int[] exp = {6};
				
		ee.init(act);
		ee.sortInsert();
		assertArrayEquals(exp,ee.toArray());
	}
			
	@Test
	public void testSortInsert_2()
	{
		int[] act = {6,4};
		int[] exp = {4,6};
				
		ee.init(act);
		ee.sortInsert();
		assertArrayEquals(exp,ee.toArray());
	}
			
	@Test
	public void testSortInsert_many()
	{
		int[] act = {7,6,8,9,5,2,3,1,4};
		int[] exp = {1,2,3,4,5,6,7,8,9};
				
		ee.init(act);
		ee.sortInsert();
		assertArrayEquals(exp,ee.toArray());
	}
}

