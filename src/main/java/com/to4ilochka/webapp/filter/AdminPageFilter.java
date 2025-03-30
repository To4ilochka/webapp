package com.to4ilochka.webapp.filter;

import com.to4ilochka.webapp.model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = "/jsp/admin_page.jsp")
public class AdminPageFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();

        if (session.getAttribute("user") != null && session.getAttribute("user") instanceof User user) {
            if (user.isAdmin()) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        resp.sendRedirect(req.getContextPath() + "/jsp/log_in.jsp");
    }
}
