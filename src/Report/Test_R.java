package Report;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/REP")
public class Test_R extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("REP-->test");
        String date=request.getParameter("date");
        String total=request.getParameter("total");
        System.out.println(" date "+ date+"  total "+total);
        String d1=request.getParameter("date1");
        String d2=request.getParameter("date2");
        System.out.println("date1 "+d1+"  date2 "+d2);
        String ft=request.getParameter("food_type");
        super.doPost(request, resp);
    }
}
