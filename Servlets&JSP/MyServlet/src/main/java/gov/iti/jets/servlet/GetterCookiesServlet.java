package gov.iti.jets.servlet;

import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class GetterCookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("<p>" + c.getName() + " = " + c.getValue() + "</p>");
            }
        } else {
            out.println("<p>No cookies found</p>");
        }
    }
}