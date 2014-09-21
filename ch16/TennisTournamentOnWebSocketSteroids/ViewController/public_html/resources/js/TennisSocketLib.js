var websocketSession;

var matches = [];



function f_onmessage(evt) {
    websocketMessages = document.getElementById('websocketMessages');
    // add new message on top of console
    websocketMessages.innerHTML =  evt.data + '<br/>'+websocketMessages.innerHTML ;
    
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
           matchTD.innerHTML ="<table id=\"matchTbl"+tennisEvent.matchId+"\"><tr><td><b>"+tennisEvent.lineUp+"</b><br/></td></tr>"+
           "<tr><td><tr><td id=\"points"+tennisEvent.matchId+"\"></td></tr>"
           +"<tr><td id=\"score"+tennisEvent.matchId+"\"></td></tr></table>";
        matches[tennisEvent.matchId] = {"lineUp":tennisEvent.lineUp,"matchId":tennisEvent.matchId, totalPoints0:0,  totalPoints1:0, player0:"", player1:""};
        }
        if ("RALLY_POINT" == tennisEvent.eventType) {
      //      websocketMessages.innerHTML = websocketMessages.innerHTML + "rALLY WON BY " + tennisEvent.wonBy + " in " + tennisEvent.matchId + '<br/>';
          matchTD = document.getElementById('points'+tennisEvent.matchId);
          matchTD.innerHTML = matchTD.innerHTML+ "-"+tennisEvent.wonBy;
          if (tennisEvent.wonBy=="0"){
             matches[tennisEvent.matchId].totalPoints0++; 
          }
          else {
            matches[tennisEvent.matchId].totalPoints1++; 
          }
          matchTD.innerHTML = "Total Points <br/>"+ matches[tennisEvent.matchId].totalPoints0+ "-"+matches[tennisEvent.matchId].totalPoints1;
        }
        if ("GAME_POINT" == tennisEvent.eventType) {
            websocketMessages.innerHTML = websocketMessages.innerHTML + "GAME WON BY " + tennisEvent.wonBy 
            + " in " + tennisEvent.matchId + " score: "+ tennisEvent.score+ '<br/>';
matchTD = document.getElementById('score'+tennisEvent.matchId);
matchTD.innerHTML = matchTD.innerHTML+ tennisEvent.wonBy+"-";
        }
        if ("SET_POINT" == tennisEvent.eventType) {
            websocketMessages.innerHTML = websocketMessages.innerHTML + "SET WON BY " + tennisEvent.wonBy 
            + " in " + tennisEvent.matchId + " score: "+ tennisEvent.score+ '<br/>';
matchTD = document.getElementById('score'+tennisEvent.matchId);
matchTD.innerHTML = matchTD.innerHTML+ "set for "+tennisEvent.wonBy+"<br/>";
        }
        if ("MATCH_POINT" == tennisEvent.eventType) {
            websocketMessages.innerHTML = websocketMessages.innerHTML + "MATCH WON BY " + tennisEvent.wonBy 
            + " in " + tennisEvent.matchId+ " score: "+ tennisEvent.score+ '<br/>';
matchTD = document.getElementById('score'+tennisEvent.matchId);
matchTD.innerHTML = matchTD.innerHTML+ "MATCH COMPLETE for <u>"+tennisEvent.wonBy+"</u><br/>";
        }
        if ("INTERRUPTED" == tennisEvent.eventType) {
            websocketMessages.innerHTML = websocketMessages.innerHTML + "MATCH SEEMS INTERRUPTED "
            + " in " + tennisEvent.matchId+ '<br/>';
matchTD = document.getElementById('score'+tennisEvent.matchId);
matchTD.innerHTML = matchTD.innerHTML+ "MATCH SEEMS INTERRUPTED <br/>";
        }
        //INTERRUPTED

}