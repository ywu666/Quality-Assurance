package dates.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dates.Dates.Day;
/**
 * @author ywu660
 *The du-path for isLaepYear. The du-path is line 51,58,59,61,63,65.
 *The isLeapYear def at line51 and use as predicate at line65.
 *
 *This test is not cover by the equivalent tests and condition/branch coverage tests.
 *For branch coverage,the unit test TestInvalidNotLeapYear test both the special year 
 *that divided by 100 which def the isLeapyear(execute line 51) but it didn't use at
 *line 65 due to 1700 is smaller than 1753.
 */
public class DataflowTest {
	@Test
	public void TestNotLeapYearDevidedBy100(){
		assertEquals(Day.Friday,dates.Dates.dayOfWeek(2100,12,10));
	}

}
