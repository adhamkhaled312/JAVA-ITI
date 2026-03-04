package gov.iti.jets.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer onlineUsers = (Integer) context.getAttribute("onlineUsers");
        context.setAttribute("onlineUsers", onlineUsers + 1);
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer onlineUsers = (Integer) context.getAttribute("onlineUsers");
        context.setAttribute("onlineUsers", onlineUsers - 1);
    }

}
