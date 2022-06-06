package com.example.demo5;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DemoServlet4", value = "/demo4")
public class DemoServlet4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title> page 4 </title>");
        out.println("</head>");
        out.println("<body>");

        HttpSession session = request.getSession(false);
        if (session == null) {
            session = request.getSession();
            session.setMaxInactiveInterval(10);

            session.setAttribute("name", "Mikhail");
        }

        final String name = (String) session.getAttribute("name");
        out.println("<h3> Hello, " + name + " </h3>");

        session.setAttribute("name", name.isEmpty() ? "Mikhail" : name.substring(1));

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
