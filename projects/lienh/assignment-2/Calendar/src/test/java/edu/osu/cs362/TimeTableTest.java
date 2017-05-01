package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 TimeTable t = new TimeTable();
		 GregorianCalendar g1 = new GregorianCalendar(2017, 10, 6);
		 GregorianCalendar g2 = new GregorianCalendar(2017, 10, 8);
		 Appt appt = new Appt(13, 30, 7, 10, 2017, "Birthday Party", "This is my birthday party");
		 LinkedList<Appt> list = new LinkedList<Appt>();
		 list.add(appt);

		 t.getApptRange(list, g1, g2);
		 t.deleteAppt(list, appt);
		 t.deleteAppt(list, null);
		 t.deleteAppt(null, appt);
	 }

}
