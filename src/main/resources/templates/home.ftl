<!DOCTYPE html>
<html lang="ru">
<div>
<form action="/ORIS_CW_01_war_exploded/show" method="get">
    <input type="submit" value="Показать всех">
</form>
</div>

<div style="color:red">${errormessage!}</div>
<div>
    <form action="/ORIS_CW_01_war_exploded/showone" method="post">
        <div>
            <label>Айди</label>
            <input type="text" name="id">
        </div>
        <input type="submit" value="Показать пользователя">
    </form>
</div>
<div>
    <form action="/ORIS_CW_01_war_exploded/add" method="get">
        <input type="submit" value="Добавить пользователя">
    </form>
</div>
</html>