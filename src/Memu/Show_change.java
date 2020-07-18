package Memu;


import Memu_interface.Memu_ACT;
import Memu_model.Memu_M;
import Test_show_total.Show_T;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Show_Change_memu")//MEMU PAGE
public class Show_change extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doPost(req, resp);
System.out.println("Show_Change_memu");
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String xml= "Project.xml";
        ApplicationContext ap=new ClassPathXmlApplicationContext(xml);
        Memu_ACT AC=(Memu_ACT) ap.getBean("Memu_A");//<bean id="Test" class="user_Model.user_Action"></bean>
        Memu_M mm=(Memu_M) ap.getBean("Memu_M");//<bean id="user_M" class="user_Model.user_
        try {
//          Memu_M[] show_model= AC.Show_memu(mm);
            ArrayList<Memu_M> show_model=AC.Show_memu(mm);
            //-----------------
            Memu_M[] Food_kind=AC.Food_kind(mm);

            //-----------------
            request.setAttribute("show_memu_model",show_model);
//            request.setAttribute("leng_show_memu_model",show_model.length);
            request.setAttribute("leng_show_memu_model",show_model.size());
            request.setAttribute("Food_kind",Food_kind);
            RequestDispatcher rd=request.getRequestDispatcher("/Show_memu.jsp");
            rd.forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
