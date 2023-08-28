<!DOCTYPE html>
<html>
<head>
    <title>Chef Orders</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.0/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script type="text/javascript">
        var stompClient = null;

        function connect() {
            console.log("Connecting to WebSocket...");
            disconnect();
            var socket = new SockJS('/chef');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                console.log("Connected to WebSocket");
                stompClient.subscribe('/my-topic', function(order) {
                    console.log("заказ пришел" + order.body);
                    var orderData = JSON.parse(order.body);
                    console.log("Received order: ", orderData);
                    showOrder(orderData);
                });
            });
        }

        function disconnect() {
            if(stompClient != null) {
                stompClient.disconnect();
                console.log("Disconnected from WebSocket");
            }
        }

        function showOrder(orderData) {
            console.log("showOrder working:", orderData);
            var productListContainer = document.getElementById('product-list-container');

            for (var i = 0; i < orderData.length; i++) {
                var item = orderData[i];
                var itemContainer = document.createElement('div');
                itemContainer.classList.add('product-item');

                var itemText = "Название продукта: " + item.productName + ", Количество: " + item.count + ", Цена: " + item.price;
                var itemElement = document.createElement('p');
                itemElement.appendChild(document.createTextNode(itemText));
                itemContainer.appendChild(itemElement);

                var processButton = document.createElement('button');
                processButton.textContent = "В процессе";
                processButton.onclick = (function(index) {
                    return function() {
                        asProcessing(index);
                    };
                })(i);

                itemContainer.appendChild(processButton);

                var readyButton = document.createElement('button');
                readyButton.textContent = "Готово";
                readyButton.onclick = (function(index) {
                    return function() {
                        asReady(index);
                    };
                })(i);

                itemContainer.appendChild(readyButton);

                productListContainer.appendChild(itemContainer);
            }
        }

        function asProcessing(index){
            console.log("заказ " + index + " в процессе приготовления");
        }

        function asReady(index){
            console.log("заказ "+index+" готов");
        }
    </script>
</head>
<body onload="connect()" onunload="disconnect()">
<div>
    <h1>Chef Orders</h1>
    <div id="product-list-container">
    </div>
</div>
</body>
</html>