package gov.iti.jets.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class LoggingFilter implements Filter {
    FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig=filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletContext context = filterConfig.getServletContext();
        context.log(request.getRemoteHost());
        System.out.println(request.getRemoteHost());
        chain.doFilter(request,response);
    }
}
