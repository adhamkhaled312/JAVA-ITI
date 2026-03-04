package gov.iti.jets.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce){
        ServletContext context= sce.getServletContext();
        context.setAttribute("numberOfVisits",0);
        context.setAttribute("onlineUsers",0);
    }

}
