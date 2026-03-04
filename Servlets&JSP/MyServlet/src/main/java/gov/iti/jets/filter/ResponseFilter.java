package gov.iti.jets.filter;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class ResponseFilter implements Filter {
    FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<center>pageHeader<hr>");
        chain.doFilter(request,response);
        out.println("<hr><center>pageFooter");
    }
}
