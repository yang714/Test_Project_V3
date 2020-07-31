package Control;

import Interface_package.Action;
import Test_HIB.User1Entity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ChangePwController {
    static String xml = "Project.xml";
    static ApplicationContext ap= new ClassPathXmlApplicationContext(xml);
    String returnpage = null;

    @RequestMapping("/ChangePw_Controller")
    public String ChangePw(HttpServletRequest request, HttpServletResponse response) {

        String new_user_pw = request.getParameter("new_us_pw");
        HttpSession sessionsa = request.getSession(false);
        System.out.println("new_us_pw "+new_user_pw +"  "+(String)sessionsa.getAttribute("login_um_id"));
        if (new_user_pw != "") {
//            ApplicationContext ap = new ClassPathXmlApplicationContext(xml);
            Action AC = (Action) ap.getBean("Test");//<bean id="Test" class="user_Model.user_Action"></bean>
            User1Entity um = (User1Entity) ap.getBean("HIBuser_M");//<bean id="user_M" class="user_Model.user_M"></bean>
//            HttpSession sessionsa = request.getSession(false);
            //*****************************//

            um.setUserName((String)sessionsa.getAttribute("login_um_id"));
            um.setUserPw(new_user_pw);
            AC.chang_pw(um);
            //*********************************//
            request.setAttribute("message", "密碼改成功");
            returnpage = "index";
        }
        else{
            request.setAttribute("messagepw", "不可為空白");
            returnpage ="change_pw";
        }
        return  returnpage;
    }
}
