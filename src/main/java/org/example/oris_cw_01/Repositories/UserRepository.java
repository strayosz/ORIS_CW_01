package org.example.oris_cw_01.Repositories;

import org.example.oris_cw_01.Models.User;
import org.example.oris_cw_01.Utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    public List<User> getUsers() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        List<User> users = new ArrayList<>();
        String sql = """
                        select account_id, login, name, surname, role, status, biography
                        from accounts
                        """;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            users.add(mapUser(resultSet));
        }

        statement.close();
        resultSet.close();
        connection.close();

        return users;
    }

    public Optional<User> findUserById(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = """
            select account_id, login, name, surname, role, status, biography
            from accounts
            where account_id = ?
            """;
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();

        User user = null;
        if(resultSet.next()){
            user = mapUser(resultSet);
        }
        System.out.println(user);

        statement.close();
        resultSet.close();
        connection.close();

        return Optional.ofNullable(user);
    }

    public void updateUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        connection.setAutoCommit(false);

        String sql = """
            update accounts
            set login = ?, name = ?, surname = ?, role = ?, status = ?, biography = ?
            where account_id = ?;
            """;

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getLogin());
        statement.setString(2, user.getName());
        statement.setString(3, user.getSurname());
        statement.setString(4, user.getRole());
        statement.setString(5, user.getStatus());
        statement.setString(6, user.getBiography());
        statement.setLong  (7, user.getId());
        statement.executeUpdate();

        connection.commit();
        connection.close();
    }

    public void addUser(User user) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getConnection();
        connection.setAutoCommit(false);

        String sql = """
            insert into accounts(login, name, surname, role, status, biography) values (?, ?, ?, ?, ?, ?);
            """;

        setUser(sql, connection, user);

        connection.commit();
        connection.close();
    }

    private User mapUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId        (resultSet.getLong  ("account_id"));
        user.setLogin     (resultSet.getString("login"));
        user.setName      (resultSet.getString("name"));
        user.setSurname   (resultSet.getString("surname"));
        user.setRole      (resultSet.getString("role"));
        user.setStatus    (resultSet.getString("status"));
        user.setBiography (resultSet.getString("biography"));
        return user;
    }

    private void setUser(String sql, Connection connection, User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getLogin());
        statement.setString(2, user.getName());
        statement.setString(3, user.getSurname());
        statement.setString(4, user.getRole());
        statement.setString(5, user.getStatus());
        statement.setString(6, user.getBiography());
        statement.executeUpdate();
        statement.close();
    }
}
