package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title=null;
		 String description=null;
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);

		appt.setTitle("Birthday Party");
		appt.setDescription("This is my birthday party.");
		appt.toString();
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }
	 /*
	 ** Tests the set methods work as expected
	*/
	 @Test
	  public void test02() throws Throwable {
	 	Appt appt = new Appt(13,30,10,4,2017,"Party", "Get funky");
	 	appt.setStartHour(24);
	 	appt.setStartHour(-1);
	 	appt.setStartHour(13);
	 	appt.setStartMinute(60);
	 	appt.setStartMinute(-1);
	 	appt.setStartMinute(30);
	 	appt.setStartDay(32);
	 	appt.setStartDay(-1);
	 	appt.setStartDay(10);
	 	appt.setStartMonth(13);
	 	appt.setStartMonth(-1);
	 	appt.setStartMonth(4);
	}



	
}
