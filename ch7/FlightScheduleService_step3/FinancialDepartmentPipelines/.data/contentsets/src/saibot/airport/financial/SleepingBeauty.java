package saibot.airport.financial;

public class SleepingBeauty {
    
    public static String takeANap(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
        }
        return "Wide awake again";
    }
}
