package nl.amis.tennis.view;

import java.util.Set;

import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/tennisSocket")
public class TennisEventsWebSocketEndPoint {
    public TennisEventsWebSocketEndPoint() {
        super();
    }

    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(final Session session) {
        try {
            session.getBasicRemote().sendText("session opened - add session to set ");
            sessions.add(session);
            session.getBasicRemote().sendText("sessions set contains "+sessions.size()+" elements");
        } catch (Exception ex) {
            Logger.getLogger(TennisEventsWebSocketEndPoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @OnMessage
    public void onMessage(final String message, final Session client) {
        try {
            client.getBasicRemote().sendText("received your message ..."+message);
        } catch (IOException ex) {
            Logger.getLogger(TennisEventsWebSocketEndPoint.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Session s:sessions) {
            try {
                s.getBasicRemote().sendText(message);
                client.getBasicRemote().sendText("send message to client " +s.getId());
                
            } catch (IOException e) {
                try {
                    client.getBasicRemote().sendText("Failed to send message to client " + e.getMessage());
                } catch (IOException f) {
                }

            }
        }//for clients
    }

    @OnClose
    public void onClose(final Session session) {
        try {
            session.getBasicRemote().sendText("WebSocket Session closed");
            sessions.remove(session);
        } catch (Exception ex) {
            Logger.getLogger(TennisEventsWebSocketEndPoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
