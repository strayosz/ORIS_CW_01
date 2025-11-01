<!DOCTYPE html>
<html lang="ru">
<div>
    <table>
        <thead>
        <tr>
            <th>Айди</th>
            <th>Логин</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Роль</th>
            <th>Статус</th>
            <th>Биография</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td data-label="Айди">${user.id}</td>
                <td data-label="Логин">${user.login}</td>
                <td data-label="Имя">${user.name}</td>
                <td data-label="Фамилия">${user.surname}</td>
                <td data-label="Роль">${user.role}</td>
                <td data-label="Статус">${user.status}</td>
                <td data-label="Биография">${user.biography}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</html>