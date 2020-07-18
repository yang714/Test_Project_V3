package Check_Out;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/check_outback")
public class check_out_back extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getSession().removeAttribute("table_name_id");
//        request.getSession().removeAttribute("check_outorder");
        request.getSession().removeAttribute("table_id");
        request.getSession().removeAttribute("Check");
        request.getSession().removeAttribute("PARAM");
        request.getSession().removeAttribute("check_outorder");
        request.getSession().removeAttribute("After_Discount");

        RequestDispatcher rd=request.getRequestDispatcher("/Check_out/check_out.jsp");
        rd.forward(request,response);
        super.doPost(request, response);
    }
}
