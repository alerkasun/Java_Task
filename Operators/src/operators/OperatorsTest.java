package operators;

import static org.junit.Assert.*;
import org.junit.Test;

public class OperatorsTest {

	@Test
	public void testOperatorsCountOdd()
	{
		int res = Operators.count(3, 5);
		assertEquals(8, res);
	}

	@Test
	public void testOperatorsCountEven()
	{
		int res = Operators.count(4, 3);
		assertEquals(12, res);
	}
	@Test
	public void testOperatorsCountNillWithNill()
	{
		int res = Operators.count(0, 0);
		assertEquals(0, res);
	}
	@Test
	public void testOperatorsCountNillWithNegative()
	{
		int res = Operators.count(0, -5);
		assertEquals(0, res);
	}
	@Test
	public void testOperatorsCountNegativeWithNill()
	{
		int res = Operators.count(-5, 0);
		assertEquals(-5, res);
	}
	@Test
	public void testOperatorsCountNegativeWithPositiveMultiplication()
	{
		int res = Operators.count(-4, 2);
		assertEquals(-8, res);
	}
	@Test
	public void testOperatorsCountNegativeWithNegativeMultiplication()
	{
		int res = Operators.count(-4, -2);
		assertEquals(8, res);
	}
	@Test
	public void testOperatorsCountNegativeWithPositiveAddition()
	{
		int res = Operators.count(-3, 2);
		assertEquals(-1, res);
	}
	@Test
	public void testOperatorsCountNegativeWithNegativeAddition()
	{
		int res = Operators.count(-5, -2);
		assertEquals(-7, res);
	}

	@Test
	public void testOperatorsCountPositiveWithPositiveAddition()
	{
		int res = Operators.count(3, 900);
		assertEquals(903, res);
	}
	@Test
	public void testOperatorsCountPositiveWithPositiveMultiplication()
	{
		int res = Operators.count(2, 900);
		assertEquals(1800, res);
	}
	@Test
	public void testOperatorsKoordinatsFirst()
	{
		String res = Operators.koordinats(2, 2);
		assertEquals("First", res);
	}
	@Test
	public void testOperatorsKoordinatsSecond()
	{
		String res = Operators.koordinats(-2, 2);
		assertEquals("Second", res);
	}
	@Test
	public void testOperatorsKoordinatsThird()
	{
		String res = Operators.koordinats(-2, -2);
		assertEquals("Third", res);
	}
	@Test
	public void testOperatorsKoordinatsFourth()
	{
		String res = Operators.koordinats(2, -2);
		assertEquals("Fourth", res);
	}
	@Test
	public void testOperatorsKoordinatsOnXAxisNegative()
	{
		String res = Operators.koordinats(0, -2);
		assertEquals("The point on the X axis", res);
	}
	@Test
	public void testOperatorsKoordinatsOnXAxis()
	{
		String res = Operators.koordinats(0, 2);
		assertEquals("The point on the X axis", res);
	}
	@Test
	public void testOperatorsKoordinatsOnYAxisNegative()
	{
		String res = Operators.koordinats(-2, 0);
		assertEquals("The point on the Y axis", res);
	}
	@Test
	public void testOperatorsKoordinatsOnYAxis()
	{
		String res = Operators.koordinats(5, 0);
		assertEquals("The point on the Y axis", res);
	}
	@Test
	public void testOperatorsSumOfPositivePPP()
	{
		int res = Operators.SumOfPositive(5, 5, 5);
		assertEquals(15, res);
	}
	@Test
	public void testOperatorsSumOfPositiveNPP()
	{
		int res = Operators.SumOfPositive(-5, 5, 5);
		assertEquals(10, res);
	}
	@Test
	public void testOperatorsSumOfPositivePNP()
	{
		int res = Operators.SumOfPositive(5, -5, 5);
		assertEquals(10, res);
	}
	@Test
	public void testOperatorsSumOfPositivePPN()
	{
		int res = Operators.SumOfPositive(5, 5, -5);
		assertEquals(10, res);
	}
	@Test
	public void testOperatorsSumOfPositivePNN()
	{
		int res = Operators.SumOfPositive(5, -5, -5);
		assertEquals(5, res);
	}
	@Test
	public void testOperatorsSumOfPositiveNPN()
	{
		int res = Operators.SumOfPositive(-5, 5, -5);
		assertEquals(5, res);
	}
	@Test
	public void testOperatorsSumOfPositiveNNP()
	{
		int res = Operators.SumOfPositive(-5, -5, 5);
		assertEquals(5, res);
	}
	@Test
	public void testOperatorsSumOfPositiveNNN()
	{
		int res = Operators.SumOfPositive(-5, -5, -5);
		assertEquals(0, res);
	}
	@Test
	public void testOperatorsRating0()
	{
		String res = Operators.rating(0);
		assertEquals("F", res);
	}
	@Test
	public void testOperatorsRating1()
	{
		String res = Operators.rating(1);
		assertEquals("F", res);
	}
	@Test
	public void testOperatorsRating18()
	{
		String res = Operators.rating(18);
		assertEquals("F", res);
	}
	@Test
	public void testOperatorsRating19()
	{
		String res = Operators.rating(19);
		assertEquals("F", res);
	}
		@Test
	public void testOperatorsRating20()
	{
		String res = Operators.rating(20);
		assertEquals("E", res);
	}
			@Test
	public void testOperatorsRating21()
	{
		String res = Operators.rating(21);
		assertEquals("E", res);
	}
			@Test
	public void testOperatorsRating38()
	{
		String res = Operators.rating(38);
		assertEquals("E", res);
	}
			@Test
	public void testOperatorsRating39()
	{
		String res = Operators.rating(39);
		assertEquals("E", res);
	}
			@Test
	public void testOperatorsRating40()
	{
		String res = Operators.rating(40);
		assertEquals("D", res);
	}
			@Test
	public void testOperatorsRating58()
	{
		String res = Operators.rating(58);
		assertEquals("D", res);
	}
				@Test
	public void testOperatorsRating59()
	{
		String res = Operators.rating(59);
		assertEquals("D", res);
	}
			@Test
	public void testOperatorsRating60()
	{
		String res = Operators.rating(60);
		assertEquals("C", res);
	}
			@Test
	public void testOperatorsRating61()
	{
		String res = Operators.rating(61);
		assertEquals("C", res);
	}
			@Test
	public void testOperatorsRating73()
	{
		String res = Operators.rating(73);
		assertEquals("C", res);
	}
			@Test
	public void testOperatorsRating74()
	{
		String res = Operators.rating(74);
		assertEquals("C", res);
	}
			@Test
	public void testOperatorsRating75()
	{
		String res = Operators.rating(75);
		assertEquals("B", res);
	}
				@Test
	public void testOperatorsRating76()
	{
		String res = Operators.rating(76);
		assertEquals("B", res);
	}
			@Test
	public void testOperatorsRating88()
	{
		String res = Operators.rating(88);
		assertEquals("B", res);
	}
			@Test
	public void testOperatorsRating89()
	{
		String res = Operators.rating(89);
		assertEquals("B", res);
	}
						@Test
	public void testOperatorsRating90()
	{
		String res = Operators.rating(90);
		assertEquals("A", res);
	}
			@Test
	public void testOperatorsRating91()
	{
		String res = Operators.rating(91);
		assertEquals("A", res);
	}
				@Test
	public void testOperatorsRating99()
	{
		String res = Operators.rating(99);
		assertEquals("A", res);
	}
					@Test
	public void testOperatorsRating100()
	{
		String res = Operators.rating(100);
		assertEquals("A", res);
	}
						@Test
	public void testOperatorsRating101()
	{
		String res = Operators.rating(101);
		assertEquals("Error", res);
	}
						@Test
	public void testOperatorsRatingMinus1()
	{
		String res = Operators.rating(-1);
		assertEquals("Error", res);
	}

}
