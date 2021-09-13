/**
 * @Author: r00t4dm
 * @Date: 2021/9/13 3:18 下午
 */

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "FileUploadServlet3", value = "/FileUploadServlet3")
public class FileUploadServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String contentType = request.getContentType();

        if (contentType != null && contentType.startsWith("multipart/")) {
            String dir = request.getSession().getServletContext().getRealPath("/");
            File uploadDir = new File(dir);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            Collection<Part> parts = request.getParts();

            for (Part part : parts) {
                String fileName = part.getSubmittedFileName();

                if (fileName != null) {
                    File uploadFile = new File(uploadDir, fileName);
//                    System.out.println(IOUtils.toString(part.getInputStream()));
                    IOUtils.write(IOUtils.toString(part.getInputStream()), new FileOutputStream(uploadFile));
                    System.out.println(part.getName() + uploadFile.getAbsolutePath());
                }

                else {
                    System.out.println(part.getName() +" : " + IOUtils.toString(part.getInputStream()));
                }
            }
        }
    }
}
