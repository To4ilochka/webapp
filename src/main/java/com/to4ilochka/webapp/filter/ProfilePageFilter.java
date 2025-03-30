package com.to4ilochka.webapp.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = "/jsp/profile_page.jsp")
public class ProfilePageFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();

        if (session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/jsp/log_in.jsp");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
