<!DOCTYPE html>
<html lang="ru">
<div style="color:red">${errormessage!}</div>
<div>
    <form action="/ORIS_CW_01_war_exploded/add" method="post">
        <div>
            <label>Логин</label>
            <input type="text" name="login">
        </div>
        <div>
            <label>Имя</label>
            <input type="text" name="name">
        </div>
        <div>
            <label>Фамилия</label>
            <input type="text" name="surname">
        </div>
        <div>
            <label>Роль</label>
            <input type="text" name="role">
        </div>
        <div>
            <label>Статус</label>
            <input type="text" name="status">
        </div>
        <div>
            <label>Биография</label>
            <input type="text" name="biography">
        </div>
        <input type="submit" value="Сохранить">
    </form>
</div>
</html>