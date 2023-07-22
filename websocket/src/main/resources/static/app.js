function connect() {
	var socket = new WebSocket('ws://localhost:8080/chatApp');
	ws = Stomp.over(socket);

	ws.connect({}, function(frame) {
		ws.subscribe("/queue/errors", function(message) {
			alert("Error " + message.body);
		});

		ws.subscribe("/queue/reply", function(message) {
			showGreeting(message.body);
		});
	}, function(error) {
		alert("STOMP error " + error);
	});
}

function disconnect() {
    if (ws != null) {
        ws.close();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
	var data = JSON.stringify({
		'name' : $("#name").val()
	})
	ws.send("/app/chatApp", {}, data);
}

function showGreeting(message) {
    $("#greetings").append(" " + message + "");
}

$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#connect").click(function() {
		connect();
	});
	$("#disconnect").click(function() {
		disconnect();
	});
	$("#send").click(function() {
		sendName();
	});
});