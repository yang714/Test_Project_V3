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
public class SignInController {
    static ApplicationContext ap;
    static String xml= "Project.xml";
    @RequestMapping("/indexx")
    public String SignIn(HttpServletRequest request , HttpServletResponse response)throws  Exception{
        String returnpage = null;
        if(request.getParameter("summit") != null){//login
            String user_id=request.getParameter("us_id");//index
            String user_pw=request.getParameter("us_pw");
            if(user_id!="" & user_pw!=""){
            ap=new ClassPathXmlApplicationContext(xml);
            Action AC=(Action) ap.getBean("Test");
            User1Entity um=(User1Entity ) ap.getBean("HIBuser_M");
            um.setUserName(user_id);
            um.setUserPw(user_pw);
            int[] A;
            A = AC.check(um);
            if(A==null){
                request.setAttribute("message","帳號or密碼錯誤");
                returnpage="index";
            }
            else{
                um.setUserOrMaster(A[0]);
                if(um.getUserOrMaster()!=5){
                    request.getSession().setAttribute("login_um_id",um.getUserName());
                    request.getSession().setAttribute("login_um_pw",um.getUserPw());
                    request.getSession().setAttribute("login_um_id_number",A[0]);
                    request.getSession().setAttribute("user_id",A[1]);
                    request.setAttribute("message",null);
                    request.setAttribute("ID_number",um.getUserOrMaster());
                    returnpage="User_page";
                }
                else{
                    request.getSession().invalidate();
                    request.setAttribute("message","帳號or密碼錯誤");
                    returnpage="index";
                }
            }

           }
        else{
            request.getSession().invalidate();
            request.setAttribute("message","帳號or密碼不可為空");
            returnpage="index";
        }
        
     
    }
        else if(request.getParameter("Sign_up") != null){
            returnpage="Sign_up";
        }
        return  returnpage;
    }
}
