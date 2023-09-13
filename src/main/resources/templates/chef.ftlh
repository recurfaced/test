<!DOCTYPE html>
<html>
<head>
    <title>Chef Orders</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.0/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script type="text/javascript">
        var stompClient = null;
        var productList = [];

        function connect() {
            console.log("Connecting to WebSocket...");
            disconnect();
            var socket = new SockJS('/chef');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                console.log("Connected to WebSocket");
                stompClient.subscribe('/my-topic', function(order) {
                    var data = JSON.parse(order.body);
                    console.log("прилетело"+ order.body);
                    var newProductList = data;
                    console.log("Новый лист "+ newProductList)
                    productList = newProductList;
                    console.log("лист: " + productList)
                    displayProductList(productList);
                });
            });
        }

        function disconnect() {
            if(stompClient != null) {
                stompClient.disconnect();
                console.log("Disconnected from WebSocket");
            }
        }

        function displayProductList(productList) {
            console.log("Отображение списка продуктов:", productList);
            var productListContainer = document.getElementById('product-list-container');

            productList.forEach(function(product) {
                console.log("Обработка продукта:", product);
                var productElement = document.createElement('div');
                productElement.innerHTML = "<p>Продукт: " + product.productName + "</p>" +
                    "<p>Цена: " + product.price + "</p>" +
                    "<p>Количество: " + product.count + "</p>";

                productListContainer.appendChild(productElement);
            });
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