package saibot.airport.flightscheduleservice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.XMLGregorianCalendar;

public class FlightScheduleProcessor {
    
    public static int calculateNumberOfFlights(String startDateString, String endDateString, int numberOfDaysPerWeek) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        int numberOfFlights = 0;
        if (endDateString == null||endDateString.length()==0) {
            numberOfFlights = 1;
        } else {
            if (endDateString.equals(startDateString)) {
                numberOfFlights = 1;
            } else {
        
        try {
            Date startDate = formatter.parse(startDateString);
            Date endDate = formatter.parse(endDateString);
            long dayDiff = getDateDiff(startDate, endDate, TimeUnit.DAYS);
            numberOfFlights = (int)(dayDiff* numberOfDaysPerWeek/7);

        } catch (ParseException e) {
        }
            }
        }
        return numberOfFlights;
    }
    

    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }
}
