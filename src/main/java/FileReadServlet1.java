/**
 * @Author: r00t4dm
 * @Date: 2021/9/13 4:04 下午
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "FileReadServlet1", value = "/FileReadServlet1")
public class FileReadServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File file = new File(request.getRealPath("/") + request.getParameter("name")) ;

        FileInputStream in = new FileInputStream(file);
        int tempbyte;

        while ((tempbyte = in.read()) != -1) {
            response.getWriter().print(tempbyte);
        }

        in.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
