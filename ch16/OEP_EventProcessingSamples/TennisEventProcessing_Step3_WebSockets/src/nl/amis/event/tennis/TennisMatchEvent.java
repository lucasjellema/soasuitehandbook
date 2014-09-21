package nl.amis.event.tennis;

public class TennisMatchEvent {
    
    private int player;
    private int pointType;  // game, set, match
    private String score;
    private int matchId;

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public void setPointType(int pointType) {
        this.pointType = pointType;
    }

    public int getPointType() {
        return pointType;
    }

    public TennisMatchEvent() {
        super();
    }
}
