<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HomePage</title>
    <link rel="stylesheet" href="${"/static/styles/homePage.css"}">
</head>
<body>
<#if user.email??>
    <h3>${user.name}</h3>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти">
    </form>
    <#if user.isAdmin()>
        <a href="/admin-control">Панель администратора</a>
    </#if>
<#else>
    <a href="/login">Войти</a>
</#if>




<#--<form action="/admin" method="get">
    <button>перейти к панели админа</button>
</form>-->
</body>
</html>