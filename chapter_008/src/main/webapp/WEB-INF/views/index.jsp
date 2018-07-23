<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <h1>My First Bootstrap Page</h1>
    <p>This is some text.</p>
</div>
<form action="/action_page.php">
    <div class="form-group">
        <label for="firstName">Имя:</label>
        <input type="text" class="form-control" id="firstName">
    </div>
    <div class="form-group">
        <label for="secondName">Фамилия:</label>
        <input type="text" class="form-control" id="secondName">
    </div>
    <input type="radio" id="Man"
           name="Sex" value="Man">
    <label for="Man">Мужчина</label>
    <input type="radio" id="Woman"
           name="Sex" value="Woman">
    <label for="Woman">Женщина</label>
    <div class="form-group">
        <label for="description">Описание: </label>
        <input type="text" class="form-control" id="description">
    </div>
    <div class="checkbox">
        <label><input type="checkbox"> Remember me</label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
<div class="table-responsive">
    <table class="table">
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Пол</th>
        <th>Описание</th>
    </table>
</div>
</body>
</html>
