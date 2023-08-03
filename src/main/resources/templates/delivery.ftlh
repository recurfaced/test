<!doctype html>
<html lang="en">
<head>
</head>
<body>
<h1>Ваш заказ</h1>
<p>Название заказа: ${order.deliveryName}</p>
<p>Город доставки: ${order.deliveryCity}</p>
<p>Улица: ${order.deliveryStreet}</p>
<p>Аппартамент: ${order.deliveryApartment}</p>

<h2>Список продуктов:</h2>
<#list productList as product>
    <p>${product.productName}</p>
    <p>Количество: ${product.count}</p>
    <p>Цена: ${product.price}</p>
    <br>
</#list>

<p id="totalAmount"></p>

<button type="button" onclick="makePayment()">Оплатить</button>
<p id="paymentStatus"></p>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        var totalAmount = 0;
        <#list productList as product>
        totalAmount += (${product.count} * ${product.price});
        </#list>

        var totalAmountElement = document.getElementById('totalAmount');
        totalAmountElement.textContent = 'Итого: ' + totalAmount + ' руб.';
    });

    function makePayment() {
        var isPaymentSuccessful = true;
        var paymentStatusElement = document.getElementById('paymentStatus');

        if (isPaymentSuccessful) {
            paymentStatusElement.textContent = 'Оплата прошла успешно! Ваш заказ подтвержден.';
        } else {
            paymentStatusElement.textContent = 'Произошла ошибка при оплате. Пожалуйста, попробуйте еще раз или обратитесь к службе поддержки.';
        }
    }
</script>
</body>
</html>