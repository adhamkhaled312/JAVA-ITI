package gov.iti.jets.servlet;

import java.io.*;
import jakarta.servlet.*;

public class GetterAttributeServlet implements Servlet {
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
        String username = (String) context.getAttribute("username");
        Integer password = (Integer) context.getAttribute("password");
        String country = context.getInitParameter("Country");

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();


        out.println("{");
        out.println("  \"username\": \"" + username + "\",");
        out.println("  \"password\": " + password + ",");
        out.println("  \"country\": \"" + country + "\"");
        out.println("}");
    }

    @Override
    public String getServletInfo() { return "Hello Servlet with init params"; }

    @Override
    public void destroy() {}
}