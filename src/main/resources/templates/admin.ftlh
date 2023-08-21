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
<h3>Создать новый товар</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Название бургера: <input type="text" name="nameBurger"/><br>
    Котлета: <input type="text" name="VealCutlet"/><br>
    Майонез: <input type="text" name="Mayonnaise"/><br>
    Салат: <input type="text" name="LettuceLeaf"/><br>
    Горчица гринго: <input type="text" name="AmericanMustard"/><br>
    Красный лук: <input type="text" name="RedOnion"/><br><br>
    Огурцы: <input type="text" name="Pickles"/><br><br>
    Соус барбекю: <input type="text" name="BarbecueSauce"/><br><br>
    Фотография: <input type="file" name="file"/><br><br>
    Описание: <input type="text" name="description"/><br><br>
    Цена: <input type="number" name="price"/><br><br>
    Калории: <input type="number" name="calories"/><br><br>
    Жиры: <input type="number" name="fats"/><br><br>
    Белки: <input type="number" name="squirrels"/><br><br>
    Углеводы: <input type="number" name="carbs"/><br><br>

    <select name="productType">
        <option value="cold_appetizers">Холодные закуски</option>
        <option value="salads">Салат</option>
        <option value="hot_dishes">Горячее</option>
    </select>
    <br><br>

    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>