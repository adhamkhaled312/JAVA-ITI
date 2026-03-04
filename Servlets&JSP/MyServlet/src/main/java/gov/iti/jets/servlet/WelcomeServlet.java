package gov.iti.jets.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {
    ServletConfig config;
    
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        String name = (String) request.getAttribute("name");
        String role = (String) request.getAttribute("role");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        config.getServletContext().getRequestDispatcher("/header.html").include(request, response);
        out.println("<h1>Welcome, " + name + "!</h1>");
        out.println("<p>Your role is: <b>" + role + "</b></p>");
        config.getServletContext().getRequestDispatcher("/footer.html").include(request, response);


    }

}
