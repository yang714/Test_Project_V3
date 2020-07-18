package Order_table_page;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/OutOrder")
public class Out_orderpage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("request.getParameter(\"out\")"+request.getParameter("out"));
        request.getSession().removeAttribute("select_table_name");
        request.getSession().removeAttribute("select_table_number");
        response.sendRedirect("User_page.jsp");
//        RequestDispatcher rd=request.getRequestDispatcher("User_page.jsp");
//        rd.forward(request,response);
//        super.doPost( request, response);
    }
}
