package User_page;

import Interface.Action;
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

@WebServlet("/Show_U")
public class Show extends HttpServlet {

//    @Resource(name="user_M")
//    user_M um;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String xml= "Project.xml";
        ApplicationContext ap=new ClassPathXmlApplicationContext(xml);
        Action AC=(Action) ap.getBean("Test");//<bean id="Test" class="user_Model.user_Action"></bean>
        user_M um=(user_M) ap.getBean("user_M");//<bean id="user_M" class="user_Model.user_
        try {
            user_M[] show_model= AC.Show_user(um);
            request.setAttribute("show_model",show_model);
            request.setAttribute("leng_show_model",show_model.length);
            RequestDispatcher rd=request.getRequestDispatcher("/Show_U.jsp");
            rd.forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

//        response.sendRedirect("Show_U.jsp");
    }
}
