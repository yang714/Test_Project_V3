package Check_Out;


import Interface.Action;
import Table_Model.Table_model;
import order_interface.order_inf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import user_Model.user_M;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Check_show")
public class check_out_show extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String xml= "Project.xml";
        ApplicationContext ap=new ClassPathXmlApplicationContext(xml);
        order_inf AC=(order_inf) ap.getBean("Table_A");//<bean id="Test" class="user_Model.user_Action"></bean>
        Table_model tm=(Table_model) ap.getBean("Table_model");//<bean id="user_M" class="user_Model.user_M"></bean>
        try {
            Table_model[] TNN= AC.Table_namenumber(tm);
            for(Table_model i:TNN){
                System.out.println("name_number"+i.getTablenamenumber()+" id"+i.getTable_ID());
            }


//            request.setAttribute("table_name_id",TNN);
            request.getSession().setAttribute("table_name_id",TNN);
            RequestDispatcher RD=request.getRequestDispatcher("Check_out/check_out.jsp");
            RD.forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Check_show  +showhere+");

        super.doPost(request,response);
    }
}
