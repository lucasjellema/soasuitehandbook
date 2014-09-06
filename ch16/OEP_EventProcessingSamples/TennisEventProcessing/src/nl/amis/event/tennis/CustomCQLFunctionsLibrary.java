package nl.amis.event.tennis;

public class CustomCQLFunctionsLibrary {
    public CustomCQLFunctionsLibrary() {
        super();
    }
    
    public Object gameScore(int score0, int score1) {
        String score ="Deuce";
        if (score0+score1 < 7) {
            score = 
              (score0==4?"G": ((score0==2)?"30":((score0==1)?"15":"0")))
              + "-"
              + (score1==4?"G": ((score1==2)?"30":((score1==1)?"15":"0")))
                ;
          
        }
        return score;
        }
}
