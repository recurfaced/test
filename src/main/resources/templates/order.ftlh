<!doctype html>
<html lang="en">
<head>

</head>
<body>
оформление заказов

<form action="/order/create" method="post" enctype="application/json" onsubmit="setProductId()">
    Заказ: <input type="text" name="deliveryName"/><br>
    Город: <input type="text" name="deliveryCity"/><br>
    Улица: <input type="text" name="deliveryStreet"/><br>
    Аппартамент: <input type="text" name="deliveryApartment"/><br>
    ccNumber: <input type="text" name="ccNumber"/><br>
    ccExpiration: <input type="text" name="ccExpiration"/><br><br>
    ccCVV: <input type="text" name="ccCVV"/><br><br>
    <input type="hidden" name="productData" id="productData" value="">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Оформить заказ"/>
</form>

<script>
    function getProductDataFromLocalStorage() {
        var storedProducts = localStorage.getItem("products");

        if (storedProducts) {
            var products = JSON.parse(storedProducts);
            var productIds = Object.keys(products);
            var productData = [];

            if (productIds.length > 0) {

                productIds.forEach(function(productId) {
                    var product = JSON.parse(products[productId]);
                    var productObject = {
                        productId: productId,
                        count: product.count || 0
                    };
                    productData.push(productObject);
                });
            }

            return productData;
        }

        return [];
    }

    function setProductId() {
        var productData = getProductDataFromLocalStorage();
        document.getElementById("productData").value = JSON.stringify(productData);
    }

    var productData = getProductDataFromLocalStorage();
    console.log("Product Data:", productData);
    setProductId();
</script>
</body>
</html>