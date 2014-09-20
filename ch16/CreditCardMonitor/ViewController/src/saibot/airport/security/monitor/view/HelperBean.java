package saibot.airport.security.monitor.view;

public class HelperBean {
    String[] colors = new String[]{"lime","olive","red","blue","green","orange","yellow","silver","black","#FF00FF","#00FF00","#800000","darkblue","olive","#ADD8E6","#00FFFF"};

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public String[] getColors() {
        return colors;
    }

    public HelperBean() {
        super();
    }
}
