package nl.amis.event.tennis;

import java.io.IOException;

import java.net.URI;

import java.net.URISyntaxException;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;

@ClientEndpoint 

public class TennisSocketMediator {
    
    private Session tennisSocketSession;
    private String webSocketEndpoint ="ws://10.10.10.21:7001/TennisTournamentOnWebSocketSteroids-ViewController-context-root/tennisSocket";
    public TennisSocketMediator() {
        super();
       

    }


    private void initiateWebSocket() {
        System.out.println("Socket mediator under construction");

        javax.websocket.WebSocketContainer container = 
        javax.websocket.ContainerProvider.getWebSocketContainer();

        try {
            System.out.println("step 2 : connect ");
        //            container.connectToServer(TennisSocketMediator.class, new URI());
        //
        //            container = ContainerProvider.getWebSocketContainer();

            //WS1 is the context-root of my web.app
            //ratesrv is the  path given in the ServerEndPoint annotation on server implementation
              tennisSocketSession=container.connectToServer(TennisSocketMediator.class, URI.create(webSocketEndpoint)); 
            System.out.println("connected ");
        }  catch (IOException e) {
            System.out.println("IOsyntax "+e.getMessage());
        } catch (DeploymentException e) {
            System.out.println("Deployment "+e.getMessage());
            e.printStackTrace();
        }
    }
    @OnOpen
    public void myOnOpen (Session session) {
       System.out.println ("WebSocket opened: "+session.getId());
    }
    @OnMessage
    public void myOnMessage (String txt) {
       System.out.println ("WebSocket received message: "+txt);
    }
    public void sendMessageToTennisSocket(String message) {
        if (tennisSocketSession==null) {
            System.out.println("Should initiate socket channel");
            initiateWebSocket();
            System.out.println("Done initiating web socket channel");
        }
        if (tennisSocketSession!=null) {
        try {
            RemoteEndpoint.Basic other = tennisSocketSession.getBasicRemote();
            other.sendText(message);
            } catch (IOException e) {
            System.out.println("IO send message fails "+e.getMessage());
            }
        } else  {
        System.out.println("no session to send message through ");
        }
    }
}

