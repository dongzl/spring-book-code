import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author dongzonglei
 * @description
 * @date 2019-06-25 17:03
 */
@WebServlet("/myAnnotationServlet")
public class AnnotationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AnnotationServlet 在处理get（）请求...");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html; charset=utf-8");
        out.println("<strong>Annotation Servlet!</strong><br>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AnnotationServlet 在处理post（）请求...");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html; charset=utf-8");
        out.println("<strong>Annotation Servlet!</strong><br>");
    }
}
