package dates.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dates.Dates;
import dates.Dates.Day;

/**
 * 
 * @author ywu660
 *This class will test the Dates class the DayOfWeek method by using the 
 *branch coverage and condition coverage 
 *
 *
 *Cannot achieve 100% branch and condition coverage,this is due to the for loop has
 *infeasible branch and for loop cannot have false condition.No condition will allow the input
 *not go inside the for loop.
 *If we want to go inside the for loop we need to have invalid month.
 *However, the invalid inputs will throw exceptions before it goes to the
 *for loop condition so it will always find the month, always go into the loop.
 *
 */
public class BranchTests {
	
	//1.Leap year
	/**
	 * This method will test the leap year when divided by 400. The output should 
	 * be Thursday.
	 */
	@Test
	public void TestLeapYearDevidedBy400(){
		assertEquals(Day.Thursday,dates.Dates.dayOfWeek(2000,12, 7));
	}
	/**
	 * This test will test the condition when the input year is divided by 4,
	 * is still leap year.The output for that should be Monday.
	 */
	@Test
	public void TestLeapYearDevidedBy4(){
		
		assertEquals(Day.Monday,dates.Dates.dayOfWeek(2016,2, 29));
	}
	/**
	 * This test will test when the year is not leap year and the month is Feb
	 * The input is valid and output should be Thursday.
	 */
	
	@Test
	public void TestNormalYear(){
		assertEquals(Day.Thursday,dates.Dates.dayOfWeek(2019,2,28));
	}
	
	
	//2.Invalid input
	/**
	 * This test will test invalid input when the year is smalle than 1753.
	 * The method should send exception.
	 */
	@Test
	public void TestInvalidNotLeapYear(){
		try{
			assertEquals(Day.Tuesday,dates.Dates.dayOfWeek(1700,3, 26));
			fail("Year cannot by smaller than 1753");
		}catch(IllegalArgumentException e){
			assertEquals("Invalid date: year=1700, month=3, day=26",e.getMessage());
			
		}
		
	}
	
	/**
	 * This test will test the invalid input when the month is greater than 12.
	 * The method should send exception.
	 */
	
	@Test
	public void TestInvalidMonthGreaterThan12(){
		try{
			assertEquals(Day.Tuesday,dates.Dates.dayOfWeek(2019,13, 26));
			fail("Month cannot by greater than 12");
		}catch(IllegalArgumentException e){
			assertEquals("Invalid date: year=2019, month=13, day=26",e.getMessage());
			
		}
		
	
	}
	/**
	 * This test will test the invalid input when the month is smaller than 1
	 * The method should send exception.
	 */

	@Test
	public void TestInvalidMonthSmallerThan1(){
		try{
			assertEquals(Day.Tuesday,dates.Dates.dayOfWeek(2019,-1, 23));
			fail("Month cannot by smaller than 1");
		}catch(IllegalArgumentException e){
			assertEquals("Invalid date: year=2019, month=-1, day=23",e.getMessage());
			
		}
	
	}
	/**
	 * This test will test the invalid input when the date of month is smaller than 1.
	 * The method should send exception.
	 */
	@Test
	public void TestInvalidSmallDay(){
		try{
			assertEquals(Day.Tuesday,dates.Dates.dayOfWeek(2019,3, -1));
			fail("Day cannot by smaller than 1");
		}catch(IllegalArgumentException e){
			assertEquals("Invalid date: year=2019, month=3, day=-1",e.getMessage());
			
		}
	}
	/**
	 * This test will test invalid input when the date month is greater than the 
	 * maximum days of that month, the method should send exception.
	 */
	@Test
	public void TestInvalidLargeDay(){
		try{
			assertEquals(Day.Tuesday,dates.Dates.dayOfWeek(2019,3,35));
			fail("Day cannot by greater than 31");
		}catch(IllegalArgumentException e){
			assertEquals("Invalid date: year=2019, month=3, day=35",e.getMessage());
			
		}
	}
	
	/**
	 * This test will test invalid input when leap year adn the month is Feb,
	 * should throw exception.
	 */
	
	@Test
	public void TestInvalidFebLeapDate(){
		try{
			assertEquals(Day.Tuesday,dates.Dates.dayOfWeek(2016,2,30));
			fail("Day cannot by greater than 29 for leap febulary");
		}catch(IllegalArgumentException e){	
			assertEquals("Invalid date: year=2016, month=2, day=30",e.getMessage());
			
		}
	}
	
	
	/**
	 * This test will test the default constructor, a Dates object should be created.
	 */
	@Test
	public void TestConstructor(){
		Dates test = new Dates();
		assertEquals("class dates.Dates" ,test.getClass().toString());
	}
	
	
	

}
