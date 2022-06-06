package com.example.demo5;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

@WebServlet(name = "DemoServlet2", value = "/demo2")
public class DemoServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title> page 2 </title>");
        out.println("</head>");
        out.println("<body>");

        final Map<String, String[]> parameterMap = request.getParameterMap();

        for (Map.Entry<String, String[]> parameterEntry : parameterMap.entrySet()) {
            out.println("<h2> " +
                    parameterEntry.getKey() +
                    ": " +
                    Arrays.deepToString(parameterEntry.getValue()) +
                    "</h2>");
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
