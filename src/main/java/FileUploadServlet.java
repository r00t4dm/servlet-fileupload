/**
 * @Author: r00t4dm
 * @Date: 2021/9/13 2:39 下午
 */

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("asdfasdfasdf");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            if (ServletFileUpload.isMultipartContent(request)) {
                ServletFileUpload fileUpload = new ServletFileUpload();
                FileItemIterator fileItemIterator = fileUpload.getItemIterator(request);

                String dir = request.getServletContext().getRealPath("/");

                File uploadFile = new File(dir);

                if (!uploadFile.exists()) {
                    uploadFile.mkdir();
                }

                while (fileItemIterator.hasNext()) {
                    FileItemStream fileItemStream = fileItemIterator.next();
                    String fieldName = fileItemStream.getFieldName();

                    if (fileItemStream.isFormField()) {
                        String fieldValue = Streams.asString(fileItemStream.openStream());
                        System.out.println(fieldName + "=" + fieldValue);
                    }

                    else {
                        String fileName = fileItemStream.getName();
                        File uploadFile2 = new File(uploadFile, fileName);
                        FileOutputStream fos = new FileOutputStream(uploadFile2);
                        Streams.copy(fileItemStream.openStream(), fos, true);
                        System.out.println("success");
                    }
                }
            }
        }

        catch (Exception e) {

        }

    }
}
