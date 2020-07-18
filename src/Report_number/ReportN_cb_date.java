package Report_number;

import Memu_interface.Memu_ACT;
import Memu_model.Memu_M;
import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/RPCBD")
public class ReportN_cb_date extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String xml= "Project.xml";
        ApplicationContext ap=new ClassPathXmlApplicationContext(xml);
        Report_NA RAC=(Report_NA) ap.getBean("ReportN_A");
        String chooseMM=request.getParameter("chooseMM");
        String year=request.getParameter("getYear");
        String Mon=request.getParameter("getMonth");
        
        System.out.println("year: "+year+"   Month"+Mon);
//        System.out.println("-->  "+request.getParameterValues("Check_out_box"));
//        for(String I:request.getParameterValues("Check_out_box")){
//            System.out.println("I-->  "+I);
//        }

//        request.getParameterValues("Check_out_box");
        JSONObject getRAC= null;

        System.out.println("chooseMM===> "+chooseMM);
        if(chooseMM.equals("Meal_SUB")){
            try {
                getRAC = RAC.Report_Meal(Integer.valueOf(year),Integer.valueOf(Mon),request.getParameterValues("Check_out_box"));

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else if(chooseMM.equals("Memu_SUB")){
            try {
                getRAC = RAC.Report_Memu(Integer.valueOf(year),Integer.valueOf(Mon),request.getParameterValues("Check_out_box"));

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        request.setAttribute("getRAC",getRAC);
        request.getSession().setAttribute("chooseMM",chooseMM);
        request.getSession().setAttribute("year",year);
        request.getSession().setAttribute("Mon",Mon);
//        request.getSession().setAttribute("ReportN_data",getRAC);
        RequestDispatcher rd=request.getRequestDispatcher("Report_Number.jsp");
        rd.forward(request,response);
//        super.doPost(request, response);
    }
}
