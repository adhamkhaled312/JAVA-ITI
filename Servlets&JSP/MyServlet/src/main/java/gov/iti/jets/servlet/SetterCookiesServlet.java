package gov.iti.jets.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class SetterCookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookie = new Cookie("user", "Adham");
        response.addCookie(cookie);
        response.sendRedirect("GetterCookiesServlet");
    }
}