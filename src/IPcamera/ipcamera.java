package IPcamera;

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
import java.io.FileNotFoundException;
import java.io.IOException;

@WebServlet("/IPC")
public class ipcamera extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String xml= "Project.xml";
       String rtsp= request.getParameter("rtsp");
        ApplicationContext ap=new ClassPathXmlApplicationContext(xml);
        VLC_EX VLC=(VLC_EX) ap.getBean("VLC_EX");//<bean id="Test" class="user_Model.user_Action"></bean>
//        user_M um=(user_M) ap.getBean("user_M");//<bean id="user_M" class="user_Model.user_M"></bean>
        VLC.testzc();

        RequestDispatcher rd=request.getRequestDispatcher("User_page.jsp");
        rd.forward(request, response);
        super.doPost(request, response);
    }
}
