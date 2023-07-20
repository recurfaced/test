<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Products</title>
</head>
<body>
<h1>Product List</h1>
<table>
    <#list products as product>
        <tr>
            <td><a href="/product/${product.id?c}"><img src="/static${product.imagePath}" alt="Product Image" width="100" height="100"></a></td>
            <td>${product.id}</td>
            <td>${product.nameBurger}</td>
            <td>${product.price}</td>
        </tr>
    </#list>
</table>

</body>
</html>