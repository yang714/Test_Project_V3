package Report;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DOT")
public class select_dateortotal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date=request.getParameter("date");
        String total=request.getParameter("total");
        System.out.println(" date "+ date+"  total "+total);
        if(total!=null ){
            request.setAttribute("type","total");
            request.getSession().setAttribute("type","total");
            RequestDispatcher rd=request.getRequestDispatcher("Report_FF.jsp");
            rd.forward(request,response);


        }
        else if(date!=null){
            request.setAttribute("type","date");
            request.getSession().setAttribute("type","date");
            RequestDispatcher rd=request.getRequestDispatcher("Report_FF.jsp");
            rd.forward(request,response);
        }

//        RequestDispatcher rd=request.getRequestDispatcher("Report_FF.jsp");
//        rd.forward(request,response);
//        super.doPost(request, respone);


    }


}
