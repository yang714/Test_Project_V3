package Report;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/RbackM")
public class Report_back extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getSession().getAttribute("d1");
        request.getSession().removeAttribute("d1");
        request.getSession().removeAttribute("d2");
        request.getSession().removeAttribute("type");
//        request.getSession().getAttribute("type");
        RequestDispatcher rd=request.getRequestDispatcher("User_page.jsp");
        rd.forward(request,response);
        super.doPost(request, response);
    }
}
