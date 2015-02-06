package springgreeter;

public class RealDecorator implements Decorator {
    @Override
    public String prettifyString(String input) {
       return input.toUpperCase()+"!!";
    }
}
