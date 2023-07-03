<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>BuySell</title>
</head>
<body>
<h4>Подробная инфа о бургере</h4>
<img src="/static${products.imagePath}" alt="Product Image" width="100" height="100">
<b>Название бургера:</b>${products.nameBurger}<br>
<b>Описание:</b>${products.description}<br>
<b>Цена:</b>${products.price}<br>
<b>Ингредиенты:</b>
<ul>
    <#list products.ingredients as ingredient>
        <li>${ingredient.americanMustard}</li>
        <li>${ingredient.barbecueSauce}</li>
        <li>${ingredient.lettuceLeaf}</li>
        <li>${ingredient.mayonnaise}</li>
        <li>${ingredient.pickles}</li>
        <li>${ingredient.redOnion}</li>
        <li>${ingredient.vealCutlet}</li>
    </#list>

    <#list products.nutritionalValues as nutritionalValue>
        <li>${nutritionalValue.calories}</li>
        <li>${nutritionalValue.fats}</li>
        <li>${nutritionalValue.carbs}</li>
        <li>${nutritionalValue.squirrels}</li>
    </#list>
</ul>
</body>
</html>