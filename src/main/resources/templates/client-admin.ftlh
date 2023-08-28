<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Client Admin</title>
</head>
<body>
<h1>Client Admin</h1>
<div id="orders-container">
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.0/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script>
    var stompAdminClient = null;
    var productList = [];

    function connectAdminWebSocket() {
        var socket = new SockJS('/client-admin');
        stompAdminClient = Stomp.over(socket);
        stompAdminClient.connect({}, function (frame) {
            stompAdminClient.subscribe('/admin-topic', function (orderData) {
                var data = JSON.parse(orderData.body);
                var newOrder = data.order;
                var newProductList = data.productList;

                productList = newProductList;

                displayOrder(newOrder);
                displayProductList(productList);
            });
        });
    }

    function displayOrder(order) {
        var ordersContainer = document.getElementById('orders-container');
        var orderElement = document.createElement('div');
        orderElement.innerHTML = "<p>Заказ: " + order.deliveryName + "</p>" +
            "<p>Город: " + order.deliveryCity + "</p>" +
            "<p>Улица: " + order.deliveryStreet + "</p>" +
            "<p>Аппартамент: " + order.deliveryApartment + "</p>";
        ordersContainer.appendChild(orderElement);
    }

    function displayProductList(productList) {
        var productListContainer = document.getElementById('product-list-container');
        productListContainer.innerHTML = ''; // Очистим предыдущее содержимое

        productList = JSON.parse(productList); // Преобразуем JSON-строку в объект

        productList.forEach(function(product) {
            var productElement = document.createElement('div');
            productElement.innerHTML = "<p>Продукт: " + product.productName + "</p>" +
                "<p>Цена: " + product.price + "</p>" +
                "<p>Количество: " + product.count + "</p>";

            productListContainer.appendChild(productElement);
        });



        var sendAllToChefButton = document.createElement('button');
        sendAllToChefButton.textContent = "Отправить все заказы повару";
        sendAllToChefButton.onclick = function() {
            sendAllProductsToChef();
        };
        productListContainer.appendChild(sendAllToChefButton);
    }

    function sendAllProductsToChef() {
        stompAdminClient.send('/my-topic', {}, JSON.stringify(productList));
        console.log("Отправлено повару: " + JSON.stringify(productList));
    }

    connectAdminWebSocket();
</script>

<div id="product-list-container">
</div>

</body>
</html>