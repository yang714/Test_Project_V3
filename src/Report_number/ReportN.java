package Report_number;

import Memu_interface.Memu_ACT;
import Memu_model.Memu_M;
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

@WebServlet("/RPN")
public class ReportN extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String xml= "Project.xml";
        ApplicationContext ap=new ClassPathXmlApplicationContext(xml);
        Memu_ACT AC=(Memu_ACT) ap.getBean("Memu_A");//<bean id="Test" class="user_Model.user_Action"></bean>
        Memu_M mm=(Memu_M) ap.getBean("Memu_M");//<bean id="user_M" class="user_Model.user_
        Report_NA RAC=(Report_NA) ap.getBean("ReportN_A");
        System.out.println("request.getParameter(\"Meal\")"+request.getParameter("Meal"));
        System.out.println("request.getParameter(\"Memu\")"+request.getParameter("Memu"));
        if(request.getParameter("Meal")!=null){
             request.getSession().setAttribute("CHtype",request.getParameter("Meal"));
//            request.setAttribute("CHtype",request.getParameter("Meal"));

            try {
                Memu_M[] Food_kind=AC.Food_kind(mm);
                request.setAttribute("food_type",Food_kind);
                request.getSession().setAttribute("food_type",Food_kind);//

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else if(request.getParameter("Memu")!=null){
            request.getSession().setAttribute("CHtype",request.getParameter("Memu"));
//            request.setAttribute("CHtype",request.getParameter("Memu"));
            try {
                ArrayList<Memu_M> Show_memu= AC.Show_memu(mm);
                request.setAttribute("show_memu",Show_memu);
                request.getSession().setAttribute("show_memu",Show_memu);//
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        try {
            ArrayList<Integer>AY= RAC.Report_GETY();
            request.getSession().setAttribute("getYear",AY);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


//        try {
//            Memu_M[] Show_memu= AC.Show_memu(mm);
//            ArrayList<Memu_M> Show_memu= AC.Show_memu(mm);
//            Memu_M[] Food_kind=AC.Food_kind(mm);
//            request.setAttribute("show_memu",Show_memu);
//            request.getSession().setAttribute("show_memu",Show_memu);//
//            request.setAttribute("food_type",Food_kind);
//            request.getSession().setAttribute("food_type",Food_kind);//
//            RequestDispatcher rd=request.getRequestDispatcher("Report_FF.jsp");
//            rd.forward(request,response);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        RequestDispatcher rd=request.getRequestDispatcher("Report_Number.jsp");
        rd.forward(request,response);
        super.doPost(request, response);
    }
}
