package nl.amis.event.tennis;

import com.bea.wlevs.ede.api.StreamSink;

public class TennisReporter implements StreamSink {

    /* (non-Javadoc)
     * @see com.bea.wlevs.ede.api.StreamSink#onInsertEvent(java.lang.Object)
     */
    public void onInsertEvent(Object event) {
        if (event instanceof TennisMatchEvent) {
            TennisMatchEvent tennisMatchEvent = (TennisMatchEvent) event;
            if (tennisMatchEvent.getPointType() == -1) {
                System.out.println("New Match has begun: " + tennisMatchEvent.getScore());
            }
            if (tennisMatchEvent.getPointType() == -2) {
                System.out.println("!!! Match seems to be interrupted: " + tennisMatchEvent.getScore());
            }
//            if (tennisMatchEvent.getPointType() == 0) {
//                System.out.println("Match Id " + tennisMatchEvent.getMatchId() + ":  Normal point for : " +
//                                   tennisMatchEvent.getPlayer()); //+" - score: "+tennisMatchEvent.getScore());
//            }
            //            if (tennisMatchEvent.getPointType() == 5) {
            //            System.out.println("Match Id "+tennisMatchEvent.getMatchId()+":  " +tennisMatchEvent.getScore());
            //            }
            //            if (tennisMatchEvent.getPointType() == 1) {
            //                System.out.println("Match Id "+tennisMatchEvent.getMatchId()+":  Game for : " + tennisMatchEvent.getPlayer()+" - score: "+tennisMatchEvent.getScore() );
            //            }
                        if (tennisMatchEvent.getPointType() == 2) {
                            System.out.println("Match Id "+tennisMatchEvent.getMatchId()+":  Set for : " + tennisMatchEvent.getPlayer()+" - score: "+tennisMatchEvent.getScore());
                        }
                        if (tennisMatchEvent.getPointType() == 3) {
                            System.out.println("Match Id "+tennisMatchEvent.getMatchId()+":  Match Won By: " + tennisMatchEvent.getPlayer()+" - score: "+tennisMatchEvent.getScore());
                        }
            //
            //            if (tennisMatchEvent.getPointType() > 13) {
            //            System.out.println("Special : " + tennisMatchEvent.getPointType());
            //            }
        }
        if (event instanceof TennisAggregateEvent) {
            TennisAggregateEvent tae = (TennisAggregateEvent) event;
            System.out.println("Half Minute Status Update:");
            System.out.println("**************************");
            System.out.println("> Total number of current matches: " + tae.getCurrentMatchCount());

            System.out.println("> Current average time per point: " + tae.getAverageTimePerPoint()/1000 +" seconds");
            System.out.println("> Total number of points played in the tournament: " + tae.getTotalPointsCount());
            System.out.println("> Duration of longest rally played in tournament: " + tae.getLongestRallyDuration()/1000+" seconds ");
        }
    }
}

