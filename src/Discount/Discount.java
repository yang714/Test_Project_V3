package Discount;

import Table_Model.Table_model;
import order_interface.order_inf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/Discount","/Discountdel"})
public class Discount extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //

        String xml= "Project.xml";
        ApplicationContext ap=new ClassPathXmlApplicationContext(xml);
        Discount_inf DAC=(Discount_inf) ap.getBean("Discount_A");//<bean id="Test" class="user_Model.user_Action"></bean>
        Discount_M DM=(Discount_M) ap.getBean("Discount_model");

        String Discount_name=request.getParameter("Dname");
        String Discount_percent=request.getParameter("Dpercent");
        request.setAttribute("add_Discount",request.getParameter("add_Discount"));
        request.setAttribute("Show_delete",request.getParameter("Show_delete"));
        request.setAttribute("DelDiscount",request.getParameter("DelDiscount"));
        System.out.println("Dname: "+Discount_name+"    Dpercent "+Discount_percent+"  "+request.getParameter("add_Discount"));

//            Class.forName("org.springframework.jdbc.datasource.DriverManagerDataSource");
        try {
            if(request.getAttribute("add_Discount")!=null) {
                System.out.println("-*--------request.getAttribute(\"add_Discount\")------"+ request.getAttribute("add_Discount"));
                DAC.addnewDis(Discount_name, Discount_percent);
                System.out.println("add");
                request.removeAttribute("add_Discount");
//                RequestDispatcher rd=request.getRequestDispatcher("/Discount_Manage.jsp");//show_memu_java
//                rd.forward(request,response);
            }
            else if(request.getAttribute("Show_delete")!=null){
                System.out.println("-*--------request.getAttribute(\"Show_delete\")------"+ request.getAttribute("Show_delete"));
//                Discount_M[] DDAC=DAC.Show_Delete();
                ArrayList<Discount_M>DDAC=DAC.Show_Delete();
//                request.getSession().setAttribute("Show_delete",DDAC);
                request.setAttribute("Show_delete",DDAC);
                System.out.println("here");
//                RequestDispatcher rd=request.getRequestDispatcher("/Discount_Manage.jsp");//show_memu_java
//                rd.forward(request,response);
            }
            else if(request.getAttribute("DelDiscount")!=null){
                String SELDE= request.getParameter("select_delete");
                System.out.println("select_delete"+SELDE);
                DAC.DeleteDis(SELDE);
                System.out.println("delete"+SELDE);
//                RequestDispatcher rd=request.getRequestDispatcher("/Discount_Manage.jsp");//show_memu_java
//                rd.forward(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher rd=request.getRequestDispatcher("/Discount_Manage.jsp");//show_memu_java
        rd.forward(request,response);

//        super.doPost(request, response);
    }
}
