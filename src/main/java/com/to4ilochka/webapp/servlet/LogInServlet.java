package com.to4ilochka.webapp.servlet;

import com.to4ilochka.webapp.db.dao.UserDAO;
import com.to4ilochka.webapp.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/log_in")
public class LogInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User inputUser = new User(req.getParameter("login"), req.getParameter("password"));
        User dbUser = UserDAO.getInstance().getByLogin(req.getParameter("login"));

        if (dbUser != null) {
            if (inputUser.equals(dbUser)) {
                HttpSession session = req.getSession();
                session.setAttribute("user", dbUser);
                resp.sendRedirect(req.getContextPath() + "/jsp/profile_page.jsp");
                return;
            }
        }
        req.setAttribute("errorMessage", "incorrect username or password");
        req.getRequestDispatcher("/jsp/log_in.jsp").forward(req, resp);
    }
}