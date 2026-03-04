package gov.iti.jets.servlet;

import java.io.IOException;

import gov.iti.jets.entity.LoginBean;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ControllerServlet extends HttpServlet {
    ServletConfig config;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LoginBean bean = new LoginBean();
        bean.setUsername(username);
        bean.setPassword(password);

        request.setAttribute("loginBean",bean);

        if(bean.validate()){
            HttpSession session = request.getSession(true);
            request.getRequestDispatcher("login-success.jsp").forward(request,response);
        }
        else{
            request.getRequestDispatcher("login-failed.jsp").forward(request,response);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("file.jsp");
    }
}
