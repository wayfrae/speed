"use strict";

var Echo = Echo || {};

Echo.sendMessage = function() {
	var echo = $("#echo");
	var message = echo.val();
	
	if (message != "") {
		Echo.socket.send(message);
		
		echo.val("");
	}
};

Echo.connect = function(host) {
	if ("WebSocket" in window) {
		Echo.socket = new WebSocket(host);
	} else if ("MozWebSocket" in window) {
		Echo.socket = new MozWebSocket(host);
	} else {
		console.log("Error: WebSocket is not supported by this browser.");
		return;
	}
	
	Echo.socket.onopen = function() {
		console.log("Info: connection opened");
		
		$("#echo").keydown(function (evt) {
			if (evt.keyCode == 13) {
				Echo.sendMessage();
			}
		});
	};
	
	Echo.socket.onclose = function() {
		console.log("Info: connection closed");
	};
	
	Echo.socket.onmessage = function(message) {
		console.log("message: " + message.data);
		$("#echoBack").text(message.data);
	};
};

Echo.initialize = function() {
	var ep = ":20202";
	
	if (window.location.protocol == "http") {
		console.log(window.location.host);
		Echo.connect("http://" + window.location.host.replace(":8080", ep));
	} else {
		Echo.connect("https://" + window.location.host.replace(":8080", ep));
	}
};

Echo.initialize();