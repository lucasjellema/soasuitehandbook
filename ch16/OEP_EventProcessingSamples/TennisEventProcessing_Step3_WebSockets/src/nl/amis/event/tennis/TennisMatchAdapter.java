package nl.amis.event.tennis;

import com.bea.wlevs.ede.api.RunnableBean;
import com.bea.wlevs.ede.api.StreamSender;
import com.bea.wlevs.ede.api.StreamSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TennisMatchAdapter implements RunnableBean, StreamSource {

int numberOfMatches=0;

    public TennisMatchAdapter() {
        super();
        // MATCH 0
        matchPoints.add(Arrays.asList(0,0,1,1,0,1,1,1
                                    ,1,0,0,0,1,0
                                    ,1,1,1,1
                                    ,0,0,1,1,0,1,0,0
                                    ,1,0,0,0,0
                                    ,0,0,1,1,0,1,0,0
                                    ,1,0,0,0,0
                                    ,0,0,1,1,0,1,0,0
        ,1,1,0,1,1
        ,1,1,1,0,0,0,1,0,0,1,0,1,1,0,1,1
        ,0,0,0,0
        ,0,0,0,0
        ,0,0,0,0
        ,0,0,1,1,0,0
        ,1,1,0,1,1
       ,1,0,0,1,0,1,1,1
        ,1,0,1,0,1,1
        ,1,1,0,1,1
        ,1,0,0,1,1,1
                                      ,0,1,1,1,1
                                      ,0,0,0,0
                                      ,1,1,0,0,1,1
                                      ,0,0,1,1,1,0,0,0
                                      ,1,1,0,0,1,1
        ,1,0,1,1,1
        ,0,0,1,0,1,1,1,1
        ));
       //MATCH 1
        matchPoints.add(Arrays.asList(        1,0,0,1,1,1
                                      ,0,1,1,1,1
                                      ,0,0,0,1,0
                                      ,1,1,0,0,1,1
                                      ,0,0,1,1,1,0,0,0
                                      ,1,1,0,0,1,1
        ,1,0,1,1,1
        ,0,0,1,0,1,1,1
,0,1,1,0,1,1,1
                                    ,1,0,1,0,0,0
                                    ,1,1,1,1
                                    ,0,0,1,1,0,1,0,0
                                    ,1,0,0,0,0
                                    ,0,0,1,1,0,1,0,0
                                    ,1,0,0,0,0
                                    ,0,0,1,1,0,1,0,0
        ,1,1,0,1,1
        ,1,1,1,0,0,0,1,0,0,1,0,1,1,0,1,1
        ,0,0,0,0
        ,0,0,0,0
        ,0,0,0,0
        ,0,0,1,1,0,0
        ,1,1,0,1,1
        ,1,0,0,1,0,1,1,1
        ,1,0,1,0,1,1
        ,1,1,0,1,1
        ));
        //MATCH 2 - interrupted
         matchPoints.add(Arrays.asList(        1,0,0,1,1,1
                                       ,0,1,1,1,1
                                       ,0,0,0,1,0
                                       ,1,1,0,0,1,1
                                       ,0,0,1,1,1,0,0,0
         ));
         numberOfMatches= matchPoints.size();
         for (int i=0;i<numberOfMatches;i++) {
             counters.add(0);
         }
//        counters.addAll( Arrays.asList(new Integer[]{0,0,0}));
    }
    private static final int SLEEP_MILLIS = 120;
    private static Random rand = new Random();


    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
     
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    private List<Integer> counters = new ArrayList<Integer>() ;
    private String message;
    private boolean suspended;
    
    private List<List<Integer>> matchPoints = new ArrayList<List<Integer>>() ;


    private StreamSender eventSender;

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
        suspended = false;
        while (!isSuspended()) { // Generate messages forever...

            generateTennisMatchEvent();

            try {
                synchronized (this) {
                    wait(randInt(SLEEP_MILLIS/2, SLEEP_MILLIS*2));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private void generateTennisMatchEvent() {
        
        TennisMatchEvent event = new TennisMatchEvent();
        
        int matchId = randInt(0,numberOfMatches-1);
        
        List<Integer> points = matchPoints.get(matchId);
   
        if (counters.get(matchId)< points.size()) {
          event.setPlayer(points.get(counters.get(matchId)));
          counters.set(matchId, counters.get(matchId)+1);
          event.setMatchId(matchId);
          event.setPointType(0);
          eventSender.sendInsertEvent(event);
        } else {
//            System.out.println("Out of match Events for match id "+matchId);
        }
    }

    /* (non-Javadoc)
     * @see com.bea.wlevs.ede.api.StreamSource#setEventSender(com.bea.wlevs.ede.api.StreamSender)
     */
    public void setEventSender(StreamSender sender) {
        eventSender = sender;
    }

    /* (non-Javadoc)
     * @see com.bea.wlevs.ede.api.SuspendableBean#suspend()
     */
    public synchronized void suspend() {
        suspended = true;
    }

    private synchronized boolean isSuspended() {
        return suspended;
    }

}
