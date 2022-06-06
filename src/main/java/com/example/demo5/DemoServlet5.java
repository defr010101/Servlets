package com.example.demo5;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DemoServlet5", value = "/demo5")
public class DemoServlet5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title> page 5 </title>");
        out.println("</head>");
        out.println("<body>");

        final Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            out.println("<h3> " + cookie.getName() + "</h3>");
            out.println("<h3> " + cookie.getValue() + "</h3>");
            out.println("<h3> " + cookie.getComment() + "</h3>");
            out.println("<h3> " + cookie.getDomain() + "</h3>");
            out.println("<h3> " + cookie.getPath() + "</h3>");
            out.println("<h3> " + cookie.getMaxAge() + "</h3>");
            out.println("<h3> " + cookie.getVersion() + "</h3>");
        }

        response.addCookie(
                new Cookie(
                        "cookie" + cookies.length,
                        Double.toString(Math.random())
                )
        );

        out.println("</body>");
        out.println("</html>");
    }
}
