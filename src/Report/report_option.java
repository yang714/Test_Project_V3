package Report;

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

//@WebServlet("/RP")//testing in-->INselect_dateortotal
public class report_option extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String xml= "Project.xml";
        ApplicationContext ap=new ClassPathXmlApplicationContext(xml);
        Memu_ACT AC=(Memu_ACT) ap.getBean("Memu_A");//<bean id="Test" class="user_Model.user_Action"></bean>
        Memu_M mm=(Memu_M) ap.getBean("Memu_M");//<bean id="user_M" class="user_Model.user_
       ////////
        String date=request.getParameter("date");
        String total=request.getParameter("total");
        System.out.println(" dateRP--> "+ date+"  totalRP--> "+total);
        //////////

        try {
//            Memu_M[] Show_memu= AC.Show_memu(mm);
            ArrayList<Memu_M>Show_memu= AC.Show_memu(mm);
            Memu_M[] Food_kind=AC.Food_kind(mm);
            request.setAttribute("show_memu",Show_memu);
            request.getSession().setAttribute("show_memu",Show_memu);//
            request.setAttribute("food_type",Food_kind);
            request.getSession().setAttribute("food_type",Food_kind);//
            RequestDispatcher rd=request.getRequestDispatcher("Report_FF.jsp");
            rd.forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //-----------------


        super.doPost(request, response);
    }
}
