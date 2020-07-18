package login_page;

import Interface.Action;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import user_Model.user_M;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Signup")
public class JDBC_insert extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String suuser_id=request.getParameter("suus_id");
        String suuser_pw=request.getParameter("suus_pw");

        int suuser_id_number=Integer.parseInt(request.getParameter("select_UorM"));
        if(suuser_id!="" & suuser_pw!=""){
            String xml= "Project.xml";
            ApplicationContext ap=new ClassPathXmlApplicationContext(xml);
            Action AC=(Action) ap.getBean("Test");//<bean id="Test" class="user_Model.user_Action"></bean>
            user_M suum=(user_M) ap.getBean("user_M");//<bean id="user_M" class="user_Model.user_M"></bean>
            suum.setId(suuser_id);
            suum.setPw(suuser_pw);
            suum.setUM_number(suuser_id_number);
            boolean after_check=AC.check_ID(suum);
            if(after_check!=true) {
                try {
                    AC.insert(suum);
//                    request.getSession().invalidate();//KILL Session()
////                    response.sendRedirect("index.jsp");
//                    request.setAttribute("message","註冊成功");
//                    request.getRequestDispatcher("index.jsp").forward(request, response);

                    if(request.getSession().getAttribute("login_um_id_number")!=null){
                        if( (int)request.getSession().getAttribute("login_um_id_number")==0){
                            request.setAttribute("message","註冊成功");
                            request.getRequestDispatcher("User_page.jsp").forward(request, response);
                        }
                    }

                    else if(request.getSession().getAttribute("login_um_id_number")==null) {
                        request.getSession().invalidate();//KILL Session()
                        request.setAttribute("message","註冊成功");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            else{
                request.setAttribute("message","有重複");
                request.getRequestDispatcher("Sign_up.jsp").forward(request, response);
                System.out.println("重複...INSERT");
            }
        }
        else{
            request.getSession().invalidate();//KILL Session()
            request.setAttribute("message","帳號or密碼不可為空");
//                response.sendRedirect("index.jsp");
            request.getRequestDispatcher("Sign_up.jsp").forward(request, response);
        }



    }
}
