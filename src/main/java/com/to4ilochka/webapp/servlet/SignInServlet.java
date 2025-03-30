package com.to4ilochka.webapp.servlet;

import com.to4ilochka.webapp.db.dao.UserDAO;
import com.to4ilochka.webapp.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/sign_in")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("login"), req.getParameter("password"));

        if (UserDAO.getInstance().insert(user)) {
            req.setAttribute("sign_in_success", "You are successfully signed in");
        } else {
            req.setAttribute("loginAlreadyTaken", "This login is already taken");
        }

        req.getRequestDispatcher("/jsp/sign_in.jsp").forward(req, resp);
    }
}
