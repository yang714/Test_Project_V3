package User_page;

import Interface.Action;
import Test_show_total.Show_T;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import user_Model.user_M;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/show_user_D")
public class Delete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int del_id_number=Integer.parseInt(request.getParameter("user_infor"));
        System.out.println(del_id_number);
//        super.doPost(req, resp);
        String xml= "Project.xml";
        ApplicationContext ap=new ClassPathXmlApplicationContext(xml);
        Action AC=(Action) ap.getBean("Test");//<bean id="Test" class="user_Model.user_Action"></bean>
        user_M um=(user_M) ap.getBean("user_M");//<bean id="user_M" class="user_Model.user_M"></bean>
        um.setId_number(del_id_number);
        try {


                AC.Delete(um);

//            AC.Delete(um);
            System.out.println("finish");
            RequestDispatcher rd=request.getRequestDispatcher("/Show_U");
            rd.forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
