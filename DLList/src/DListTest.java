import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith (Parameterized.class)
public class DListTest 
{
	DList dL = null;
	
	public DListTest(String str) throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		this.dL = (DList) Class.forName(str).newInstance();
	}
	
	@Parameters ( name = "{index} is {0}")
	public static Iterable<Object[]> data1() 
	{
		return Arrays.asList(new Object[][] { 
			{"DList0"}, 
			{"DList1"}, 
			{"DList2"},
			{"LDList2"}
		});
	}
/*--------------------------------------------------*/
/*--------------------- size -----------------------*/ 
/*--------------------------------------------------*/
	
	@Test
	public void testSize_null() 
	{
		int[] act = null;
		dL.init(act);
		assertEquals(0,dL.size());
	}
	
	@Test
	public void testSize_0() 
	{
		int[] act = new int[0];
		dL.init(act);
		assertEquals(0,dL.size());	
	}
	
	@Test
	public void testSize_1()
	{
		int[] act = {1};
		dL.init(act);
		assertEquals(1,dL.size());
	}
	
	@Test
	public void testSize_2()
	{
		int[] act = {1,2};
		dL.init(act);
		assertEquals(2,dL.size());	
	}
	
	@Test
	public void testSize_many() 
	{
		int[] act = {1,2,3,4,5,6,7};
		dL.init(act);
		assertEquals(7,dL.size());	
	}
/*--------------------------------------------------*/
/*--------------------- toArray --------------------*/ 
/*--------------------------------------------------*/
		@Test
		public void testToArray_null() 
		{
			int[] act = null;
			int[] exp = new int[0];
			dL.init(act);
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testToArray_0() 
		{
			int[] act = new int[0];
			int[] exp = new int[0];
			dL.init(act);
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testToArray_1()
		{
			int[] act = {1};
			int[] exp = {1};
			dL.init(act);
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testToArray_2()
		{
			int[] act = {1,2};
			int[] exp = {1,2};
			dL.init(act);
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testToArray_many() 
		{
			int[] act = {1,2,3,4,5,6,7};
			int[] exp = {1,2,3,4,5,6,7};
			dL.init(act);
			assertArrayEquals(exp,dL.toArray());	
		}	
/*--------------------------------------------------*/
/*------------------ addStart ----------------------*/ 
/*--------------------------------------------------*/	
		@Test
		public void testAddStart_0() 
		{
			int[] exp = {0};
			dL.addStart(0);
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testAddStart_1()
		{
			int[] exp = {1};
			dL.addStart(1);;
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testAddStart_2()
		{
			int[] exp = {2,1};
			dL.addStart(1);
			dL.addStart(2);
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testAddStart_many() 
		{
			int[] exp = {1,2,3,4,5,6,7};
			dL.addStart(7);
			dL.addStart(6);
			dL.addStart(5);
			dL.addStart(4);
			dL.addStart(3);
			dL.addStart(2);
			dL.addStart(1);
			assertArrayEquals(exp,dL.toArray());	
		}
/*--------------------------------------------------*/
/*------------------ addEnd ------------------------*/ 
/*--------------------------------------------------*/
		@Test
		public void testAddEnd_0() 
		{
			int[] exp = {0};
			dL.addEnd(0);
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testAddEnd_1()
		{
			int[] exp = {1};
			dL.addEnd(1);;
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testAddEnd_2()
		{
			int[] exp = {1,2};
			dL.addEnd(1);
			dL.addEnd(2);
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testAddEnd_many() 
		{
			int[] exp = {1,2,3,4,5,6,7};
			dL.addEnd(1);
			dL.addEnd(2);
			dL.addEnd(3);
			dL.addEnd(4);
			dL.addEnd(5);
			dL.addEnd(6);
			dL.addEnd(7);
			assertArrayEquals(exp,dL.toArray());	
		}
/*--------------------------------------------------*/
/*-------------------- addPos ----------------------*/ 
/*--------------------------------------------------*/		
		@Test
		public void testAddPos_0() 
		{	int[] act = {1,2};
			int[] exp = {1,2};
			dL.init(act);
			dL.addPos(0, 2);
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testAddPos_1()
		{
			int[] act = {1,2};
			int[] exp = {2,1,2};
			dL.init(act);
			dL.addPos(1, 2);
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testAddPos_2()
		{
			int[] act = {1,2,3};
			int[] exp = {4,4,1,2,3};
			dL.init(act);
			dL.addPos(1,4);
			dL.addPos(2,4);
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test 
		public void testAddPos_outOfB()
		{
			int[] act = {1,2,3};
			int[] exp = {1,2,3};
			dL.init(act);
			dL.addPos(5,4);
			assertArrayEquals(exp, act);
		}
		
		@Test
		public void testAddPos_many() 
		{	int[] act = {1,2,3,4,5,6,7};
			int[] exp = {2,3,4,5,6,7,8,1,2,3,4,5,13,6,7};
			dL.init(act);
			dL.addPos(1,2);
			dL.addPos(2,3);
			dL.addPos(3,4);
			dL.addPos(4,5);
			dL.addPos(5,6);
			dL.addPos(6,7);
			dL.addPos(7,8);
			dL.addPos(13,13);
			assertArrayEquals(exp,dL.toArray());	
		}
/*--------------------------------------------------*/
/*-------------------- delStart --------------------*/ 
/*--------------------------------------------------*/	
		@Test
		public void testDelStart_1() 
		{	int[] act = {1,2};
			int[] exp = {2};
			dL.init(act);
			dL.delStart();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testDelStart_2()
		{
			int[] act = {1,2,3};
			int[] exp = {3};
			dL.init(act);
			dL.delStart();
			dL.delStart();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testDelStart_empty()
		{
			int[] act = {};
			int[] exp = {};
			dL.init(act);
			dL.delStart();
			
			assertArrayEquals(exp,dL.toArray());
		}
/*--------------------------------------------------*/
/*-------------------- delEnd ----------------------*/ 
/*--------------------------------------------------*/	
		@Test
		public void testDelEnd_1() 
		{	int[] act = {1,2};
			int[] exp = {1};	
			dL.init(act);
			dL.delEnd();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testDelEnd_2()
		{
			int[] act = {1,2,3};
			int[] exp = {1};
			dL.init(act);
			dL.delEnd();
			dL.delEnd();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testDelEnd_empty()
		{
			int[] act = {};
			int[] exp = {};
			dL.init(act);
			dL.delEnd();
			
			assertArrayEquals(exp,dL.toArray());
		}

/*--------------------------------------------------*/
/*-------------------- delPos ----------------------*/ 
/*--------------------------------------------------*/	
		@Test
		public void testDelPos_1() 
		{	int[] act = {1,2,3,4};
			int[] exp = {1,2,4};
			dL.init(act);
			dL.delPos(3);
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testDelPos_2()
		{
			int[] act = {1,2,3};
			int[] exp = {2};
			dL.init(act);
			dL.delPos(3);
			dL.delPos(1);
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testDelPos_empty()
		{
			int[] act = {};
			int[] exp = {};
			
			dL.init(act);
			dL.delPos(1);
			
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testDelPos_outOfBounds()
		{
			int[] act = {1,2,3};
			int[] exp = {1,2,3};
			
			dL.init(act);
			dL.delPos(5);
			assertArrayEquals(exp,dL.toArray());
		}
/*--------------------------------------------------*/
/*-------------------- getMin ----------------------*/ 
/*--------------------------------------------------*/	
		@Test
		public void testGetMin_null()
		{
			int[] act = null;
			
			dL.init(act);
			assertEquals(0, dL.getMin());
		}
		
		@Test
		public void testGetMin_0()
		{
			int[] act = {};
			
			dL.init(act);
			assertEquals(0, dL.getMin());
		}
		
		@Test
		public void testGetMin_1()
		{
			int[] act = {32};
			
			dL.init(act);
			assertEquals(32, dL.getMin());
		}
		
		@Test
		public void testGetMin_2()
		{
			int[] act = {32,54};
			
			dL.init(act);
			assertEquals(32, dL.getMin());
		}
		
		@Test
		public void testGetMin_many()
		{
			int[] act = {32,54,13,42,23,66,23};
			
			dL.init(act);
			assertEquals(13, dL.getMin());
		}
/*--------------------------------------------------*/
/*-------------------- getMin ----------------------*/ 
/*--------------------------------------------------*/	
		@Test
		public void testGetMax_null()
		{
			int[] act = null;
			
			dL.init(act);
			assertEquals(0, dL.getMax());
		}
		
		@Test
		public void testGetMax_0()
		{
			int[] act = {};
			
			dL.init(act);
			assertEquals(0, dL.getMax());
		}
		
		@Test
		public void testGetMax_1()
		{
			int[] act = {32};
			
			dL.init(act);
			assertEquals(32, dL.getMax());
		}
		
		@Test
		public void testGetMax_2()
		{
			int[] act = {32,54};
			
			dL.init(act);
			assertEquals(54, dL.getMax());
		}
		
		@Test
		public void testGetMax_many()
		{
			int[] act = {32,54,13,42,23,66,23};
			
			dL.init(act);
			assertEquals(66, dL.getMax());
		}
/*--------------------------------------------------*/
/*------------------ getMinIndex -------------------*/ 
/*--------------------------------------------------*/	
		@Test
		public void testGetMinIndex_null()
		{
			int[] act = null;
			
			dL.init(act);
			assertEquals(0, dL.getMinIndex());
		}
		
		@Test
		public void testGetMinIndex_0()
		{
			int[] act = {};
			
			dL.init(act);
			assertEquals(0, dL.getMinIndex());
		}
		
		@Test
		public void testGetMinIndex_1()
		{
			int[] act = {32};
	
			dL.init(act);
			assertEquals(1, dL.getMinIndex());
		}
		
		@Test
		public void testGetMinIndex_2()
		{
			int[] act = {32,54};
			
			dL.init(act);
			assertEquals(1, dL.getMinIndex());
		}
		
		@Test
		public void testGetMinIndex_many()
		{
			int[] act = {32,54,13,42,23,66,23};
			
			dL.init(act);
			assertEquals(3, dL.getMinIndex());
		}
/*--------------------------------------------------*/
/*------------------ getMaxIndex -------------------*/ 
/*--------------------------------------------------*/	
		@Test
		public void testGetMaxIndex_null()
		{
			int[] act = null;
			
			dL.init(act);
			assertEquals(0, dL.getMaxIndex());
		}
		
		@Test
		public void testGetMaxIndex_0()
		{
			int[] act = {};
			
			dL.init(act);
			assertEquals(0, dL.getMaxIndex());
		}
		
		@Test
		public void testGetMaxIndex_1()
		{
			int[] act = {32};
			
			dL.init(act);
			assertEquals(1, dL.getMaxIndex());
		}
		
		@Test
		public void testGetMaxIndex_2()
		{
			int[] act = {32,54};
			
			dL.init(act);
			assertEquals(2, dL.getMaxIndex());
		}
		
		@Test
		public void testGetMaxIndex_many()
		{
			int[] act = {32,54,13,42,23,66,23};
			
			dL.init(act);
			assertEquals(6, dL.getMaxIndex());
		}
		
/*--------------------------------------------------*/
/*-------------------- reverse ---------------------*/ 
/*--------------------------------------------------*/	
		@Test
		public void testReverse_null()
		{
			int[] act = null;
			int[] exp = null;
			
			dL.init(act);
			dL.reverse();
			assertArrayEquals(exp,act);
		}
		
		@Test
		public void testReverse_0()
		{
			int[] act = {};
			int[] exp = {};
			
			dL.init(act);
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testReverse_1()
		{
			int[] act = {1};
			int[] exp = {1};
			
			dL.init(act);
			dL.reverse();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testReverse_2()
		{
			int[] act = {1,2};
			int[] exp = {2,1};
			
			dL.init(act);
			dL.reverse();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testReverse_many()
		{
			int[] act = {1,2,3,4,5,6,7};
			int[] exp = {7,6,5,4,3,2,1};
			
			dL.init(act);
			dL.reverse();
			assertArrayEquals(exp, dL.toArray());
		}
/*--------------------------------------------------*/
/*------------------- partChange -------------------*/ 
/*--------------------------------------------------*/	
		@Test
		public void testPartChange_null()
		{
			int[] act = null;
			int[] exp = null;
			
			dL.init(act);
			dL.partChange();
			assertArrayEquals(exp,act);
		}
		
		@Test
		public void testPartChange_0()
		{
			int[] act = {};
			int[] exp = {};
			
			dL.init(act);
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testPartChange_1()
		{
			int[] act = {1};
			int[] exp = {1};
			
			dL.init(act);
			dL.partChange();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testPartChange_2()
		{
			int[] act = {1,2};
			int[] exp = {2,1};
			
			dL.init(act);
			dL.partChange();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testPartChange_many()
		{
			int[] act = {10,2,3,4,5,6,7,8};
			int[] exp = {5,6,7,8,10,2,3,4};
			
			dL.init(act);
			dL.partChange();
			assertArrayEquals(exp, dL.toArray());
		}
		
		@Test
		public void testPartChange_manynoE()
		{
			int[] act = {1,2,3,4,5,6,7};
			int[] exp = {4,5,6,7,1,2,3};
			
			dL.init(act);
			dL.partChange();
			assertArrayEquals(exp, dL.toArray());
		}
/*--------------------------------------------------*/
/*-------------------- evenSum ---------------------*/ 
/*--------------------------------------------------*/	
		@Test
		public void testEvenSum_null()
		{
			int[] act = null;
			
			dL.init(act);
	
			assertEquals(0,dL.evenSum());
		}
		
		@Test
		public void testEvenSum_0()
		{
			int[] act = {};
			
			dL.init(act);
			assertEquals(0,dL.evenSum());
		}
		
		@Test
		public void testEvenSum_1()
		{
			int[] act = {1};
			
			dL.init(act);
			
			assertEquals(0,dL.evenSum());
		}
		
		@Test
		public void testEvenSum_2()
		{
			int[] act = {1,2};
			
			dL.init(act);
			assertEquals(2,dL.evenSum());
		}
		
		@Test
		public void testEvenSum_many()
		{
			int[] act = {1,2,3,4,5,6,7};
			
			dL.init(act);
			assertEquals(12, dL.evenSum());
		}
/*--------------------------------------------------*/
/*-------------------- oddSum ----------------------*/ 
/*--------------------------------------------------*/	
		@Test
		public void testOddSum_null()
		{
			int[] act = null;
			
			dL.init(act);
	
			assertEquals(0,dL.oddSum());
		}
		
		@Test
		public void testOddSum_0()
		{
			int[] act = {};
			
			dL.init(act);
			assertEquals(0,dL.oddSum());
		}
		
		@Test
		public void testOddSum_1()
		{
			int[] act = {1};
			
			dL.init(act);
			
			assertEquals(1,dL.oddSum());
		}
		
		@Test
		public void testOddSum_2()
		{
			int[] act = {1,2};
			
			dL.init(act);
			assertEquals(1,dL.oddSum());
		}
		
		@Test
		public void testOddSum_many()
		{
			int[] act = {1,2,3,4,5,6,7};
			
			dL.init(act);
			assertEquals(16, dL.oddSum());
		}
/*--------------------------------------------------*/
/*------------------- sortBuble --------------------*/ 
/*--------------------------------------------------*/	
		@Test
		public void testSortBuble_null()
		{
			int[] act = null;
			int[] exp = null;
			
			dL.init(act);
			exp = dL.toArray();
			dL.sortBuble();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testSortBuble_0()
		{
			int[] act = {};
			int[] exp = {};
			
			dL.init(act);
			exp = dL.toArray();
			dL.sortBuble();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testSortBuble_1()
		{
			int[] act = {6};
			int[] exp = {6};
			
			dL.init(act);
			dL.sortBuble();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testSortBuble_2()
		{
			int[] act = {6,4};
			int[] exp = {4,6};
			
			dL.init(act);
			dL.sortBuble();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testSortBuble_many()
		{
			int[] act = {7,6,8,9,5,2,3,1,4};
			int[] exp = {1,2,3,4,5,6,7,8,9};
			
			dL.init(act);
			dL.sortBuble();
			assertArrayEquals(exp,dL.toArray());
		}
/*--------------------------------------------------*/
/*------------------- sortSelect -------------------*/ 
/*--------------------------------------------------*/	
		@Test
		public void testSortSelect_null()
		{
			int[] act = null;
			int[] exp = null;
			
			dL.init(act);
			exp = dL.toArray();
			dL.sortSelect();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testSortSelect_0()
		{
			int[] act = {};
			int[] exp = {};
			
			dL.init(act);
			exp = dL.toArray();
			dL.sortSelect();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testSortSelect_1()
		{
			int[] act = {6};
			int[] exp = {6};
			
			dL.init(act);
			dL.sortSelect();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testSortSelect_2()
		{
			int[] act = {6,4};
			int[] exp = {4,6};
			
			dL.init(act);
			dL.sortSelect();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testSortSelect_many()
		{
			int[] act = {7,6,8,9,5,2,3,1,4};
			int[] exp = {1,2,3,4,5,6,7,8,9};
			
			dL.init(act);
			dL.sortSelect();
			assertArrayEquals(exp,dL.toArray());
		}
/*--------------------------------------------------*/
/*------------------- sortInsert -------------------*/ 
/*--------------------------------------------------*/	
		@Test
		public void testSortInsert_null()
		{
			int[] act = null;
			int[] exp = null;
			
			dL.init(act);
			exp = dL.toArray();
			dL.sortInsert();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testSortInsert_0()
		{
			int[] act = {};
			int[] exp = {};
			
			dL.init(act);
			exp = dL.toArray();
			dL.sortInsert();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testSortInsert_1()
		{
			int[] act = {6};
			int[] exp = {6};
			
			dL.init(act);
			dL.sortInsert();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testSortInsert_2()
		{
			int[] act = {6,4};
			int[] exp = {4,6};
			
			dL.init(act);
			dL.sortInsert();
			assertArrayEquals(exp,dL.toArray());
		}
		
		@Test
		public void testSortInsert_many()
		{
			int[] act = {7,6,8,9,5,2,3,1,4};
			int[] exp = {1,2,3,4,5,6,7,8,9};
			
			dL.init(act);
			dL.sortInsert();
			assertArrayEquals(exp,dL.toArray());
		}
		

}
