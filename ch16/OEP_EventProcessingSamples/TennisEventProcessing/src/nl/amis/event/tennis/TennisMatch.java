package nl.amis.event.tennis;

public class TennisMatch {
    
    private String matchIdentifier;
    private String player0;
    private String player1;

    public void setMatchIdentifier(String matchIdentifier) {
        this.matchIdentifier = matchIdentifier;
    }

    public TennisMatch(String matchIdentifier, String player0, String player1) {
        super();
        this.matchIdentifier = matchIdentifier;
        this.player0 = player0;
        this.player1 = player1;
    }

    public String getMatchIdentifier() {
        return matchIdentifier;
    }

    public void setPlayer0(String player0) {
        this.player0 = player0;
    }

    public String getPlayer0() {
        return player0;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer1() {
        return player1;
    }

    public TennisMatch() {
        super();
    }
}
