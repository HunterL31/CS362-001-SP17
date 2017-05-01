package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		 GregorianCalendar g = new GregorianCalendar(2017, 10, 7);
		 CalDay cal = new CalDay(g);
		 CalDay invCal = new CalDay();
		 Appt appt = new Appt(13, 30, 7, 10, 2017, "Birthday Party", "This is my birthday party");
		 Appt appt2 = new Appt(14, 30, 7, 10, 2017, "Birthday Party", "This is my birthday party");
		 Appt appt3 = new Appt(14, 30, 7, 10, 2017, "Birthday Party", "This is my birthday party");
		 appt.setStartMonth(20);
		 appt.setStartYear(2017);
		 appt.setStartHour(13);
		 appt.setStartDay(7);
		 appt.setStartMinute(30);
		 cal.addAppt(appt);
		 cal.addAppt(appt2);
		 cal.addAppt(appt3);
		 cal.getSizeAppts();
		 cal.iterator();
		 cal.toString();
	 }
	
}
