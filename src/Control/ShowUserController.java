package Control;

import Interface_package.Action;
import Test_HIB.User1Entity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@Controller
public class ShowUserController {
    static String xml = "Project.xml";
    static ApplicationContext ap= new ClassPathXmlApplicationContext(xml);
    String returnpage = null;
    @RequestMapping("/ShowUser_Manage")
    public String  ShowUserManage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException {
        int del_id_number=Integer.parseInt(request.getParameter("user_infor"));
        Action AC=(Action) ap.getBean("Test");//<bean id="Test" class="user_Model.user_Action"></bean>
        User1Entity um=(User1Entity) ap.getBean("HIBuser_M");//<bean id="user_M" class="user_Model.user_M"></bean>
        um.setId(del_id_number);
        AC.Delete(um);
        return "forward:Userpage_ShowU";
    }
}
