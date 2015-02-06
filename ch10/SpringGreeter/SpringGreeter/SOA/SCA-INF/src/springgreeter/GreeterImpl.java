package springgreeter;

public class GreeterImpl implements Greeter {
    
    private Decorator decorator;

    public void setDecorator(Decorator decorator) {
        this.decorator = decorator;
    }

    @Override
    public String greet(String input) {        
        return decorator.prettifyString("Hello "+input);
    }
}
