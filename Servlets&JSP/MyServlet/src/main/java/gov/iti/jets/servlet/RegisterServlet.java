package gov.iti.jets.servlet;

import java.io.IOException;

import gov.iti.jets.dao.UserDao;
import gov.iti.jets.entity.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
    ServletConfig config;
    
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        User user=  new User();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        UserDao dao = new UserDao();
        if(dao.register(user)){
            response.sendRedirect("login.html");
        }
        else{
            response.sendRedirect("register.html?error=true");
        }

    }

}
