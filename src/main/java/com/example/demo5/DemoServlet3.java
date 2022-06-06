package com.example.demo5;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "DemoServlet3", value = "/demo3")
public class DemoServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title> page 3 </title>");
        out.println("</head>");
        out.println("<body>");

        final Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            out.println("<h3>" +
                    headerName +
                    ": " +
                    request.getHeader(headerName) +
                    "</h3>");
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
