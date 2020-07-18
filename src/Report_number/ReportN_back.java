package Report_number;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/RNbackM")
public class ReportN_back extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("food_type");
        request.getSession().removeAttribute("show_memu");
        request.getSession().removeAttribute("CHtype");
        request.getSession().removeAttribute("chooseMM");
        request.removeAttribute("getRAC");

        RequestDispatcher rd=request.getRequestDispatcher("User_page.jsp");
        rd.forward(request,response);
        super.doPost(request, response);
    }
}
