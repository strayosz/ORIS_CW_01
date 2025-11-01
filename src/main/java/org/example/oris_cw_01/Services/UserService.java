package org.example.oris_cw_01.Services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.oris_cw_01.Models.User;
import org.example.oris_cw_01.Repositories.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public void getAll(HttpServletRequest request){
        List<User> users = null;
        try {
            users = userRepository.getUsers();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("users", users);
    }

    public void findUserById(HttpServletRequest request, HttpServletResponse response) {
        String requestId = request.getParameter("id");
        Long id;
        try {
            id = Long.valueOf(requestId);
            try {
                if (userRepository.findUserById(id).isPresent()) {
                    User user = userRepository.findUserById(id).get();
                    request.setAttribute("user", user);
                    request.getRequestDispatcher("/showOne.ftl").forward(request, response);
                } else {
                    request.setAttribute("errormessage", "Пользователь с таким айди не существует");
                    try {
                        request.getRequestDispatcher("/home.ftl").forward(request, response);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            request.setAttribute("errormessage", "Введите данные корректно");
            try {
                request.getRequestDispatcher("/home.ftl").forward(request, response);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void updateUserById(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(request.getParameter("id"));
        try {
            User user = userRepository.findUserById(id).get();
            String login = request.getParameter("login");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String role = request.getParameter("role");
            String status = request.getParameter("status");
            String biography = request.getParameter("biography");

            setUser(user, login, name, surname, role, status, biography);

            userRepository.updateUser(user);
            request.getRequestDispatcher("/home.ftl").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addUser(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String role = request.getParameter("role");
        String status = request.getParameter("status");
        String biography = request.getParameter("biography");

        if (login == null || login.isEmpty()
                || name == null || name.isEmpty()
                || surname == null || surname.isEmpty()
                || role == null || role.isEmpty()
                || status == null || status.isEmpty()
                || biography == null || biography.isEmpty()) {
            request.setAttribute("errormessage", "Введите данные корректно");
            try {
                request.getRequestDispatcher("/add.ftl").forward(request, response);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        } else {
            User user = new User();
            setUser(user, login, name, surname, role, status, biography);
            try {
                userRepository.addUser(user);
                request.getRequestDispatcher("/show").forward(request, response);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void setUser(User user, String login, String name, String surname, String role, String status, String biography){
        user.setLogin(login);
        user.setName(name);
        user.setSurname(surname);
        user.setRole(role);
        user.setStatus(status);
        user.setBiography(biography);
    }

}