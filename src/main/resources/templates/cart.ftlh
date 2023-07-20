<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HomePage</title>
</head>
<body>
<h4>Корзина</h4>
<form action="/order" method="get">
    <button>перейти к оформлению</button>
</form>
<p id="productIdDisplay"></p>

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