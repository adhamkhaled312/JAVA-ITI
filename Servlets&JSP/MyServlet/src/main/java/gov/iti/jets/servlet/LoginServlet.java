package gov.iti.jets.servlet;

import java.io.IOException;

import gov.iti.jets.dao.UserDao;
import gov.iti.jets.entity.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    ServletConfig config;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

        UserDao dao = new UserDao();
        User user = dao.login(request.getParameter("username"),request.getParameter("password"));
        if(user != null){
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedIn", user);
            response.sendRedirect("SearchServlet");
        }
        else{
            response.sendRedirect("login.html?error=true");
        }
    }

}
