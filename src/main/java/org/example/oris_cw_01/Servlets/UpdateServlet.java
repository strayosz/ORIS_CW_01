package org.example.oris_cw_01.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.oris_cw_01.Services.UserService;

import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    private final UserService userService = new UserService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        userService.updateUserById(request, response);
    }

}
