package gov.iti.jets.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;


public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("file");
        String path = req.getServletContext().getRealPath("") + File.separator+"uploads";
        File uploadDirectory = new File(path);
        if(!uploadDirectory.exists()){
            uploadDirectory.mkdir();
        }
        filePart.write(path+File.separator+filePart.getSubmittedFileName());
        resp.sendRedirect("file.jsp");
    }
}
