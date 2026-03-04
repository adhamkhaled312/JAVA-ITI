package gov.iti.jets.servlet;

import java.io.*;
import jakarta.servlet.*;

public class SetterAttributeServlet implements Servlet {
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
        ServletContext context = config.getServletContext();
        context.setAttribute("username", "adham");
        context.setAttribute("password", 123456);
        String country = context.getInitParameter("Country");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h3>User information set from " + country + "</h3>");
    }

    @Override
    public String getServletInfo() { return "Hello Servlet with init params"; }

    @Override
    public void destroy() {}
}