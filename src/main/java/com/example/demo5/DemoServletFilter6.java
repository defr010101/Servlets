package com.example.demo5;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(filterName = "DemoServletFilter6", urlPatterns = "/demo6")
public class DemoServletFilter6 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        final String name = request.getParameter("name");

        if (name == null) {
            request.getRequestDispatcher("/error").forward(request, response);
        }

        chain.doFilter(request, response);
    }
}
