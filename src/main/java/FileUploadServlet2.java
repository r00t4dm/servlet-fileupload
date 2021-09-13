/**
 * @Author: r00t4dm
 * @Date: 2021/9/13 3:01 下午
 */

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "FileUploadServlet2", value = "/FileUploadServlet2")
public class FileUploadServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("adsf");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletContext().getRealPath("/");

        File file  = new File(path);

        if (!file.exists()){
            file.mkdir();
        }

        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

        try {
            List<FileItem> list = fileUpload.parseRequest(request);

            for (FileItem fileItem : list) {
                if (fileItem.isFormField()) {
                    System.out.println(fileItem.getFieldName());
                }
                else {
                    String filename = fileItem.getName();
                    fileItem.write(new File(file, filename));
                    fileItem.delete();
                }
            }

            System.out.println("success");

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
