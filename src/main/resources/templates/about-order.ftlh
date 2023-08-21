<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>About-order</title>
    <link rel="stylesheet" href="/static/styles/homePage.css">
</head>
<body>
<h1>Детали заказа</h1>
<div id="productList"></div>

<h1>Детали заказа</h1>
<div id="productList">
    <#list productList as product>
        <p>Название продукта: ${product.productName}, Количество: ${product.count}, Цена: ${product.price}</p>
    </#list>
</div>

<script>
    // Извлекаем параметры URL, включая productList
    const urlParams = new URLSearchParams(window.location.search);
    const productListParam = urlParams.get("productList");

    // Парсим полученный JSON productList
    const productList = JSON.parse(decodeURIComponent(productListParam));

    // Отображаем productList на странице
    const productListDiv = document.getElementById("productList");
    if (productListDiv) {
        const productListHTML = productList.map(product => {
            return `<p>Название продукта: ${product.productName}, Количество: ${product.count}, Цена: ${product.price}</p>`;
        }).join("");
        productListDiv.innerHTML = productListHTML;
    }
</script>
</body>
</html>