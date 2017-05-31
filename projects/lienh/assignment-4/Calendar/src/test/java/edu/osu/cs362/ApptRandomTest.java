package edu.osu.cs362;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setDescription","isValid"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	
    /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start appt testing...");
		 
		 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =10;//System.currentTimeMillis();
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				 int startHour=13;
				 int startMinute=30;
				 int startDay=10;
				 int startMonth=4;
				 int startYear=2017;
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 //Construct a new Appointment object with the initial data	 
				 Appt appt = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);
				for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}else if(methodName.equals("isValid")){
						   Appt temp = new Appt(
								   ValuesGenerator.getRandomIntBetween(random, -24, 24),
								   ValuesGenerator.getRandomIntBetween(random, -60, 60),
								   ValuesGenerator.getRandomIntBetween(random, -31, 31),
								   ValuesGenerator.getRandomIntBetween(random, -15, 15),
								   2016,
								   "Title",
								   "Description");
					   }else if(methodName.equals("setDescription")){
							Appt temp = new Appt(
									10,
									10,
									10,
									10,
									2016,
									"Title",
									ValuesGenerator.getString(random));
					   }
					
				}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}

		 System.out.println("Done testing appt...");
	 }

	 @Test
	  public void testValidFunc() throws Throwable {
	     int ghour = 5, bhour = 30;
	     int gminute = 20, bminute = 90;
	     int gday = 15, bday = 40;
	     int gmonth = 10, bmonth = 14;
	     String title = "Birthday";
	     String description = "It's my birthday";

	     Appt badHour = new Appt(bhour, gminute, gday, gmonth, 2016, title, description);
	     assertEquals(badHour.getValid(), false);

         Appt badMinute = new Appt(ghour, bminute, gday, gmonth, 2016, title, description);
         assertEquals(badMinute.getValid(), false);

         Appt badDay= new Appt(ghour, gminute, bday, gmonth, 2016, title, description);
         assertEquals(badDay.getValid(), false);

         Appt badMonth = new Appt(ghour, gminute, gday, bmonth, 2016, title, description);
         assertEquals(badMonth.getValid(), false);

         Appt app = new Appt(ghour, gminute, gday, gmonth, 2017, title, description);
         assertEquals(app.getValid(), true);
     }
    @Test
    public void testSetDescriptionFunc() throws Throwable {
	     String title = "Title";
	     String goodDesc = "This is a description";
	     String badDesc = null;

	     Appt good = new Appt(10, 10, 10, 10, 2016, title, goodDesc);
	     assertEquals(good.getDescription(), "This is a description");

	     Appt bad = new Appt(10, 10, 10, 10, 2016, title, badDesc);
	     assertEquals(bad.getDescription(), "");
    }

	
}
