package edu.osu.cs362;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;
import sun.awt.image.ImageWatched;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
    private static final int NUM_TESTS=20;

    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"deleteAppt"};// The list of the of methods to be tested in the Appt class

        int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n] ; // return the method name
    }

    /**
     * Generate Random Tests that tests TimeTable Class.
     */

    @Test
    public void randomTest() throws Throwable {
        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
        TimeTable t = new TimeTable();
        GregorianCalendar cal = new GregorianCalendar();
        CalDay newcal = new CalDay(cal);
        LinkedList<Appt> applist = newcal.getAppts();

        System.out.println("Start time table testing...");
        //t.deleteAppt(applist, )


        for (int iteration = 0; elapsed < TestTimeout; iteration++) {
            long randomseed = 10;//System.currentTimeMillis();
            //			System.out.println(" Seed:"+randomseed );
            Random random = new Random(randomseed);

            for (int i = 0; i < NUM_TESTS; i++) {
                    Appt temp = new Appt(
                            ValuesGenerator.getRandomIntBetween(random, -24, 24),
                            10,
                            10,
                            10,
                            2016,
                            "Title",
                            "Description");
                    newcal.addAppt(temp);
                    applist = newcal.getAppts();
            }
            for (int i = 0; i < NUM_TESTS; i++) {
                    t.deleteAppt(applist, applist.get(i));
            }

            elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
            if((iteration%10000)==0 && iteration!=0 )
                System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

        }
        LinkedList<Appt> badlist = null;
        Appt badapp = null;
        Appt goodapp = new Appt(10, 10, 10, 10, 2016, "T", "D");
        newcal.addAppt(badapp);
        newcal.addAppt(goodapp);
        applist = newcal.getAppts();
        t.deleteAppt(badlist, goodapp);
        t.deleteAppt(applist, badapp);
        t.deleteAppt(applist, goodapp);
        System.out.println("Done testing cal day...");
    }
}
