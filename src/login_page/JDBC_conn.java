package login_page;

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

@WebServlet(urlPatterns = "/index")

public class JDBC_conn extends HttpServlet {
//    @Resource(name="Test")
//     Action AC;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        System.out.println("Test--->"+AC);
        if(request.getParameter("summit") != null){//login
            System.out.println(request.getParameter("summit"));
            try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

            String user_id=request.getParameter("us_id");//index
            String user_pw=request.getParameter("us_pw");
            System.out.println(user_id+ "   "+ user_pw);
            if(user_id!="" & user_pw!=""){
                String xml= "Project.xml";
                ApplicationContext ap=new ClassPathXmlApplicationContext(xml);
                Action AC=(Action) ap.getBean("Test");//<bean id="Test" class="user_Model.user_Action"></bean>
                user_M um=(user_M) ap.getBean("user_M");//<bean id="user_M" class="user_Model.user_M"></bean>
                um.setId(user_id);
                um.setPw(user_pw);
//                String A="";
                int[] A = new int[0];
                try {
                 A = AC.check(um);
                 if(A==null){
                     request.setAttribute("message","帳號or密碼錯誤");
//                response.sendRedirect("index.jsp");
                     request.getRequestDispatcher("index.jsp").forward(request, response);
                 }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                um.setUM_number(A[0]);
                System.out.print("jdbc_conn  " +A[0]+"  "+A[1]);
//                if(A.equals("pag_user"))
                if(um.getUM_number()!=5){
                    request.setAttribute("um",um);

                    request.getSession().setAttribute("login_um_id",um.getId());
                    request.getSession().setAttribute("login_um_pw",um.getPw());
                    request.getSession().setAttribute("login_um_id_number",A[0]);
                    request.getSession().setAttribute("user_id",A[1]);
                    request.setAttribute("message",null);
                    System.out.println("");
                    request.setAttribute("ID_number",um.getUM_number());
                    RequestDispatcher rd=request.getRequestDispatcher("/User_page.jsp");
                    rd.forward(request,response);

                }
//                else if(A.equals("pag_Master")){
//                    System.out.println("test...master");
//                }
                else{
                    request.getSession().invalidate();
                    request.setAttribute("message","帳號or密碼錯誤");
//                response.sendRedirect("index.jsp");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
            else{
                request.getSession().invalidate();
                request.setAttribute("message","帳號or密碼不可為空");
//                response.sendRedirect("index.jsp");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

            }

        else if(request.getParameter("Sign_up") != null){//Sign_up
            response.sendRedirect("Sign_up.jsp");
            }



    }


}
