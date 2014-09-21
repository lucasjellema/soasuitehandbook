package nl.amis.event.tennis;

public class TennisAggregateEvent {
    private Integer currentMatchCount;
    private Float   averageTimePerPoint;
    private Integer totalPointsCount;
    private Float longestRallyDuration;


    public void setLongestRallyDuration(Float longestRallyDuration) {
        this.longestRallyDuration = longestRallyDuration;
    }

    public Float getLongestRallyDuration() {
        return longestRallyDuration;
    }

    public void setCurrentMatchCount(Integer currentMatchCount) {
        this.currentMatchCount = currentMatchCount;
    }

    public Integer getCurrentMatchCount() {
        return currentMatchCount;
    }

    public void setAverageTimePerPoint(Float averageTimePerPoint) {
        this.averageTimePerPoint = averageTimePerPoint;
    }

    public Float getAverageTimePerPoint() {
        return averageTimePerPoint;
    }

    public void setTotalPointsCount(Integer totalPointsCount) {
        this.totalPointsCount = totalPointsCount;
    }

    public Integer getTotalPointsCount() {
        return totalPointsCount;
    }

    public TennisAggregateEvent() {
        super();
    }
}
