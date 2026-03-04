package gov.iti.jets.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import gov.iti.jets.dao.UserDao;
import gov.iti.jets.entity.User;

public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.html");
            return;
        }

        User user = (User) session.getAttribute("loggedIn");
        String keyword = request.getParameter("keyword");

        request.setAttribute("loggedUser", user);

        if (keyword != null && !keyword.isEmpty()) {
            UserDao dao = new UserDao();
            List<User> users = dao.search(keyword);
            request.setAttribute("users", users);
        }
        request.getRequestDispatcher("/search.jsp").forward(request,response);


    }
}