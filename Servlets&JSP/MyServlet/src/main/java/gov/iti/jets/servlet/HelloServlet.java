package gov.iti.jets.servlet;

import java.io.*;
import jakarta.servlet.*;

public class HelloServlet implements Servlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String dbAddress = config.getInitParameter("DatabaseAddress");
        String username = config.getInitParameter("userName");
        String password = config.getInitParameter("password");

        out.println("<h1>Hello from MyServlet</h1>");
        out.println("<p>Database Address: " + dbAddress + "</p>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p>Password: " + password + "</p>");
        out.close();
    }

    @Override
    public String getServletInfo() { return "Hello Servlet with init params"; }

    @Override
    public void destroy() {}
}