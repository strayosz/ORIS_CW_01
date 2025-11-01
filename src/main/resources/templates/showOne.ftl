<!DOCTYPE html>
<html lang="ru">
<div>
    <form action="/ORIS_CW_01_war_exploded/update" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <div>
            <label>Логин</label>
            <input type="text" name="login" value = "${user.login}">
        </div>
        <div>
            <label>Имя</label>
            <input type="text" name="name" value = "${user.name}">
        </div>
        <div>
            <label>Фамилия</label>
            <input type="text" name="surname" value = "${user.surname}">
        </div>
        <div>
            <label>Роль</label>
            <input type="text" name="role" value = "${user.role}">
        </div>
        <div>
            <label>Статус</label>
            <input type="text" name="status" value = "${user.status}">
        </div>
        <div>
            <label>Биография</label>
            <input type="text" name="biography" value = "${user.biography}">
        </div>
        <input type="submit" value="Сохранить">
    </form>
</div>
</html>