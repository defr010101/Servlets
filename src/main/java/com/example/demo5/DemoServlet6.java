package com.example.demo5;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DemoServlet6", value = "/demo6")
public class DemoServlet6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        final String name = request.getParameter("name");

        out.println("""
                <html>
                    <head>
                        <title> page 6 </title>
                    </head>
                    <body>
                """);
        out.println("<h1> Hello, " + name + " </h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
