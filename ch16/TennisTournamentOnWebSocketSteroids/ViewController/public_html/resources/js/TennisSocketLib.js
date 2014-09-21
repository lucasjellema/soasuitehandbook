var websocketSession;




function f_onmessage(evt) {
    websocketMessages = document.getElementById('websocketMessages');
    websocketMessages.innerHTML = websocketMessages.innerHTML + evt.data + '<br/>';
    
    if (evt.data.indexOf("tennisEvent") > 0 && (evt.data.indexOf("received your message") ==-1)) {
        var json = JSON.parse(evt.data);
        var tennisEvent = json.tennisEvent;
        processTennisEvent(tennisEvent);
    }
}

function open() {
    if (!websocketSession) {
        var url = 'ws://' + document.location.host + document.location.pathname + 'tennisSocket';
        websocketSession = new WebSocket(url);
        websocketSession.onmessage = f_onmessage;
    }
}

function close() {
    if (websocketSession) {
        websocketSession.close();
    }
}

function sendMessage(msg) {
    websocketSession.send(msg);
}

function processTennisEvent(tennisEvent) {
           // websocketMessages.innerHTML = websocketMessages.innerHTML + "Tennis Event " + tennisEvent.eventType + " for match " + tennisEvent.matchId + '<br/>';
        if ("NEW_MATCH" == tennisEvent.eventType) {
            websocketMessages.innerHTML = websocketMessages.innerHTML + "NEW MATCH STARTS " + tennisEvent.lineUp 
            + " in " + tennisEvent.matchId + '<br/>';
matchTD = document.getElementById('match'+tennisEvent.matchId);
matchTD.innerHTML ="<b>"+tennisEvent.lineUp+"</b><br/>";
        }
        if ("RALLY_POINT" == tennisEvent.eventType) {
      //      websocketMessages.innerHTML = websocketMessages.innerHTML + "rALLY WON BY " + tennisEvent.wonBy + " in " + tennisEvent.matchId + '<br/>';
        }
        if ("GAME_POINT" == tennisEvent.eventType) {
            websocketMessages.innerHTML = websocketMessages.innerHTML + "GAME WON BY " + tennisEvent.wonBy 
            + " in " + tennisEvent.matchId + " score: "+ tennisEvent.score+ '<br/>';
matchTD = document.getElementById('match'+tennisEvent.matchId);
matchTD.innerHTML = matchTD.innerHTML+ tennisEvent.wonBy+"-";
        }
        if ("SET_POINT" == tennisEvent.eventType) {
            websocketMessages.innerHTML = websocketMessages.innerHTML + "SET WON BY " + tennisEvent.wonBy 
            + " in " + tennisEvent.matchId + " score: "+ tennisEvent.score+ '<br/>';
matchTD = document.getElementById('match'+tennisEvent.matchId);
matchTD.innerHTML = matchTD.innerHTML+ "set for "+tennisEvent.wonBy+"<br/>";
        }
        if ("MATCH_POINT" == tennisEvent.eventType) {
            websocketMessages.innerHTML = websocketMessages.innerHTML + "MATCH WON BY " + tennisEvent.wonBy 
            + " in " + tennisEvent.matchId+ " score: "+ tennisEvent.score+ '<br/>';
matchTD = document.getElementById('match'+tennisEvent.matchId);
matchTD.innerHTML = matchTD.innerHTML+ "MATCH COMPLETE for <u>"+tennisEvent.wonBy+"</u><br/>";
        }
        //INTERRUPTED

}