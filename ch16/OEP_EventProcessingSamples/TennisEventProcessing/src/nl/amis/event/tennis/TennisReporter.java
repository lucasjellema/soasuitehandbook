package nl.amis.event.tennis;

import com.bea.wlevs.ede.api.StreamSink;

public class TennisReporter implements StreamSink {

    /* (non-Javadoc)
     * @see com.bea.wlevs.ede.api.StreamSink#onInsertEvent(java.lang.Object)
     */
    public void onInsertEvent(Object event) {
        if (event instanceof TennisMatchEvent) {
            TennisMatchEvent tennisMatchEvent = (TennisMatchEvent) event;
            if (tennisMatchEvent.getPointType() == 0) {
       //        System.out.println("Match Id "+tennisMatchEvent.getMatchId()+":  Normal point for : " + tennisMatchEvent.getPlayer()); //+" - score: "+tennisMatchEvent.getScore());
            }
            if (tennisMatchEvent.getPointType() == 1) {
                System.out.println("Match Id "+tennisMatchEvent.getMatchId()+":  Game for : " + tennisMatchEvent.getPlayer()+" - score: "+tennisMatchEvent.getScore() );
            }
            if (tennisMatchEvent.getPointType() == 2) {
                System.out.println("Match Id "+tennisMatchEvent.getMatchId()+":  Set for : " + tennisMatchEvent.getPlayer()+" - score: "+tennisMatchEvent.getScore());
            }
            if (tennisMatchEvent.getPointType() == 3) {
                System.out.println("Match Id "+tennisMatchEvent.getMatchId()+":  Match Won By: " + tennisMatchEvent.getPlayer()+" - score: "+tennisMatchEvent.getScore());
            }
            
            if (tennisMatchEvent.getPointType() > 3) {
            System.out.println("Special : " + tennisMatchEvent.getPointType());
            }
        }
    }
}

