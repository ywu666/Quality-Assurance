package dates.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dates.Dates.Day;
/**
 * @author ywu660
 *The input will separate into 3 partitions, the date after the doomsday,the day before the 
 *doomsday and the day at dooms day.
 *
 *The day before and after doomsday is already test by the branch coverage.
 *This equivalent test will test the boundary value at doomsday.This means the position is equal to
 *0 inside the dayOFweek method which is the boundary case that the Branch tests or
 *data-flow test doesn't test.
 */
public class EquivalenceTest {

	@Test
	public void TestAtBoomsday(){
		assertEquals(Day.Thursday,dates.Dates.dayOfWeek(2019,12,12));
	}

}
