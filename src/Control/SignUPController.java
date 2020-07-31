package Control;

import Interface_package.Action;
import Test_HIB.User1Entity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignUPController {
    static ApplicationContext ap;
    static String xml = "Project.xml";
    String returnpage = null;

    @RequestMapping("/Signupp")
    public String Signupp(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String suuser_id = request.getParameter("suus_id");
        String suuser_pw = request.getParameter("suus_pw");
        int suuser_id_number = Integer.parseInt(request.getParameter("select_UorM"));
        if (suuser_id != "" & suuser_pw != "") {
            String xml = "Project.xml";
            ApplicationContext ap = new ClassPathXmlApplicationContext(xml);
            Action AC = (Action) ap.getBean("Test");//<bean id="Test" class="user_Model.user_Action"></bean>
            User1Entity suum = (User1Entity) ap.getBean("HIBuser_M");//<bean id="user_M" class="user_Model.user_M"></bean>
            suum.setUserName(suuser_id);
            suum.setUserPw(suuser_pw);
            suum.setUserOrMaster(suuser_id_number);
            boolean after_check = AC.check_ID(suum);
            if (after_check != true) {
                AC.insert(suum);

                if (request.getSession().getAttribute("login_um_id_number") != null) {
                    if ((int) request.getSession().getAttribute("login_um_id_number") == 0) {
                        returnpage = "User_page";
                    }
                } else if (request.getSession().getAttribute("login_um_id_number") == null) {
                    request.setAttribute("message", "註冊成功");
                    returnpage = "index";
                }
            } else {
                request.setAttribute("message", "有重複");
                returnpage = "Sign_up";

            }
        } else {
            request.getSession().invalidate();//KILL Session()
            request.setAttribute("message", "帳號or密碼不可為空");
//                response.sendRedirect("index.jsp");
            returnpage = "Sign_up";
        }
        return returnpage;
    }

    @RequestMapping("/backk")
    public String back(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getSession().getAttribute("login_um_id_number") != null) {
            if ((int) request.getSession().getAttribute("login_um_id_number") == 0) {
                returnpage = "User_page";
            }
        }
        else {
            returnpage = "index";
        }

        return returnpage;
    }
}
