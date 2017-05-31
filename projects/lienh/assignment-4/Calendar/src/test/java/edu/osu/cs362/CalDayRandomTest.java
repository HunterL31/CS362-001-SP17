package edu.osu.cs362;


import org.junit.Test;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[] {"addAppt"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name
	}

	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
    @Test
	public void randomTest() throws Throwable {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		GregorianCalendar cal = new GregorianCalendar();
		CalDay newcal = new CalDay(cal);

		System.out.println("Start cal day testing...");


		for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			long randomseed = 10;//System.currentTimeMillis();
			//			System.out.println(" Seed:"+randomseed );
			Random random = new Random(randomseed);

			for (int i = 0; i < NUM_TESTS; i++) {
				String methodName = ApptRandomTest.RandomSelectMethod(random);
				if (methodName.equals("addAppt")){
					Appt temp = new Appt(
							ValuesGenerator.getRandomIntBetween(random, -24, 24),
							ValuesGenerator.getRandomIntBetween(random, -60, 60),
							ValuesGenerator.getRandomIntBetween(random, -31, 31),
							ValuesGenerator.getRandomIntBetween(random, -15, 15),
							2016,
							"Title",
							"Description");
					newcal.addAppt(temp);
				}
			}

			elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			if((iteration%10000)==0 && iteration!=0 )
				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

		}
		Appt app = new Appt(0, 0, 0, 0, 2016, "T", "D");
		newcal.addAppt(app);
		System.out.println("Done testing cal day...");
	}
}
