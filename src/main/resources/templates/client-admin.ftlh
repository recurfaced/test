<!DOCTYPE html>
<html>
<head>
    <title>Admin orders</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.0/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script type="text/javascript">
        var stompClient = null;

        function connect() {
            console.log("connecting working");
            disconnect();
            var socket = new SockJS('/client-admin');
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

            for (var i = 0; i < order.length; i++) {
                var item = order[i];
                var itemContainer = document.createElement('div');
                itemContainer.classList.add('product-item');

                var itemText = "Название продукта: " + item.productName + ", Количество: " + item.count + ", Цена: " + item.price;
                var itemElement = document.createElement('p');
                itemElement.appendChild(document.createTextNode(itemText));
                itemContainer.appendChild(itemElement);

                response.appendChild(itemContainer);
            }

            // Создаем кнопку "Подтвердить заказ" и добавляем обработчик для нее
            var confirmButton = document.createElement('button');
            confirmButton.textContent = 'Подтвердить заказ';
            confirmButton.addEventListener('click', function() {
                // Здесь можно добавить логику для подтверждения заказа
                alert('Заказ подтвержден!');
            });

            response.appendChild(confirmButton);
        }

    </script>
</head>
<body onload="console.log('Connecting to WebSocket...'); connect()" onunload="disconnect()">
<div>
    <h1>Admin Orders</h1>
    <div id="response"></div>
</div>
</body>
</html>