/**
 * @Author: r00t4dm
 * @Date: 2021/9/13 4:15 下午
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet(name = "FileReadServlet2", value = "/FileReadServlet2")
public class FileReadServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        byte[] bytes = Files.readAllBytes(Paths.get(name));
        response.getWriter().print(new String(bytes));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
