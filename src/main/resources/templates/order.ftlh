<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HomePage</title>
</head>
<body>
оформление заказов

<form action="/order/create" method="post" enctype="multipart/form-data">
    Заказ: <input type="text" name="deliveryName"/><br>
    Город: <input type="text" name="deliveryCity"/><br>
    Улица: <input type="text" name="deliveryStreet"/><br>
    Аппартамент: <input type="text" name="deliveryApartment"/><br>
    ccNumber: <input type="text" name="ccNumber"/><br>
    ccExpiration: <input type="text" name="ccExpiration"/><br><br>
    ccCVV: <input type="text" name="ccCVV"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Оформить заказ"/>
</form>
<script>
    var storedProducts = localStorage.getItem("products");

    if (storedProducts) {
        var products = JSON.parse(storedProducts);
        var productIds = Object.keys(products);

        productIds.forEach(function(productId) {
            console.log("Product ID:", productId);
        });
    } else {
        console.log("No data found in localStorage");
    }
</script>
</body>
</html>