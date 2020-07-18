package User_page;

import Interface.Action;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import user_Model.user_M;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/U_action_changepw")
public class user_page_changepw extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user_pw=request.getParameter("us_pw");
        String new_user_pw=request.getParameter("new_us_pw");
       if(new_user_pw!="") {
           try {
               Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               String xml = "Project.xml";
               ApplicationContext ap = new ClassPathXmlApplicationContext(xml);
               Action AC = (Action) ap.getBean("Test");//<bean id="Test" class="user_Model.user_Action"></bean>
               user_M um = (user_M) ap.getBean("user_M");//<bean id="user_M" class="user_Model.user_M"></bean>
               HttpSession sessionsa = request.getSession(false);
               um.setId((String) sessionsa.getAttribute("login_um_id"));
               um.setPw(new_user_pw);
               AC.chang_pw(um);
               request.setAttribute("message", "密碼改成功");
               RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
               rd.forward(request, response);

           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }
       }
       else{
           request.setAttribute("messagepw", "不可為空白");
           RequestDispatcher rd = request.getRequestDispatcher("/change_pw.jsp");
           rd.forward(request, response);
       }


//        System.out.println("ID   "+um.getId()+"       OLE  "+um.getOld_pw()+"  NEW "+um.getPw());

    }

}
