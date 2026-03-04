package gov.iti.jets.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/octet-stream");
        resp.setHeader("content-disposition","attachment;filename=adham.jsp");

        PrintWriter out = resp.getWriter();

        InputStream is = req.getServletContext().getResourceAsStream("/name.jsp");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);

        String line;
        while((line = reader.readLine())!=null){
            out.println(line);
        }

    }
}
