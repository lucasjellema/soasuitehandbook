package nl.amis.event.tennis;

import com.bea.wlevs.ede.api.RunnableBean;
import com.bea.wlevs.ede.api.StreamSender;
import com.bea.wlevs.ede.api.StreamSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TennisMatchAdapter implements RunnableBean, StreamSource {

    public TennisMatchAdapter() {
        super();
        points.addAll(Arrays.asList(0,0,1,1,0,1,1,1
                                    ,1,0,0,0,0
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
        // games won by 1,0,1,0,0,0,0,0,1

    }
    private static final int SLEEP_MILLIS = 120;

private int counter=0;
    private String message;
    private boolean suspended;

private List<Integer> points = new ArrayList<Integer>() ;

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
                    wait(SLEEP_MILLIS);
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
        if (counter< points.size()) {
        event.setPlayer(this.points.get(counter++));
        eventSender.sendInsertEvent(event);
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
