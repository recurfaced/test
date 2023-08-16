<!DOCTYPE html>
<html>
<head>
    <title>Chef Orders</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.0/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script type="text/javascript">
        var stompClient = null;

        function connect() {
            console.log("connecting working");
            disconnect();
            var socket = new SockJS('/chef');
            stompClient = Stomp.over(socket);
            console.log("15 work");
            stompClient.connect({}, function(frame) {
                console.log("17");
                stompClient.subscribe('/my-topic', function(order) {
                    console.log("Received order: " + JSON.parse(order.body));
                    showOrder(JSON.parse(order.body));
                });
                console.log("23");
            });
        }

        function disconnect() {
            if(stompClient != null) {
                stompClient.disconnect();
            }
        }

        function showOrder(order) {
            console.log("showOrder working:" + order);
            var response = document.getElementById('response');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';

            for (var i = 0; i < order.length; i++) {
                var item = order[i];
                var itemText = "Product: " + item.productName + ", Count: " + item.count + ", Price: " + item.price;
                var itemElement = document.createElement('div');
                itemElement.appendChild(document.createTextNode(itemText));
                p.appendChild(itemElement);
            }

            response.appendChild(p);
        }
    </script>
</head>
<body onload="console.log('Connecting to WebSocket...'); connect()" onunload="disconnect()">
<div>
    <h1>Chef Orders</h1>
    <div id="response"></div>
</div>
</body>
</html>