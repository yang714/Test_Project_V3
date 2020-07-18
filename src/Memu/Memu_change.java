package Memu;

import Memu_interface.Memu_ACT;
import Memu_interface.set_get_memu;
import Memu_model.Memu_M;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/CHANGE")

public class Memu_change extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String xml= "Project.xml";
        ApplicationContext ap=new ClassPathXmlApplicationContext(xml);
        Memu_ACT AC=(Memu_ACT) ap.getBean("Memu_A");//<bean id="Test" class="user_Model.user_Action"></bean>
        Memu_M mmc=(Memu_M) ap.getBean("Memu_M");//<bean id="user_M" class="user_Model.user_


        String memu_delete=request.getParameter("memu_delete");
        String memu_check=request.getParameter("memu_check");
        String  memu_add=request.getParameter("memu_add");
        String add_type=request.getParameter("add_type");

        System.out.println("memu_delete-->  "+memu_delete+"   memu_check-->  "+memu_check+" memu_add--> "+memu_add);

        if(memu_delete!=null){
            try {
                mmc.setMemu_ID(Integer.parseInt(request.getParameter("memu_delete")));
                AC.Delete(mmc);
                RequestDispatcher rd=request.getRequestDispatcher("/Show_Change_memu");//show_memu_java
                rd.forward(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println("memu_delete active");
        }
        //update all
        else if(memu_check!=null){
            System.out.println("memu_check active");
            String[] type=request.getParameterValues("Test_select");
            String [] memu_name=request.getParameterValues("memu_name");
            String [] memu_ID=request.getParameterValues("memu_ID");
            String [] memu_price=request.getParameterValues("memu_price");
//            set_get_memu[] a = new set_get_memu[0];
            try {
                AC.update_Food(memu_ID, memu_name, memu_price, type);
                RequestDispatcher rd=request.getRequestDispatcher("/Show_Change_memu");//show_memu_java
                rd.forward(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
//            for(int i=0;i<memu_ID.length;i++) {
//                System.out.println(" ID "+a[i].getMemu_ID() + "  Memu_name---> " + a[i].getMemu_name()
//                        + "   Memu_price-->  " + a[i].getMemu_price()+"  Food_type--> "+a[i].getMeal_ID());
//            }



        }
        else if(memu_add!=null){
            String memu_nameADD=request.getParameter("memu_nameADD");
            int memu_priceADD=Integer.parseInt(request.getParameter("memu_priceADD"));
            int selectADD=Integer.parseInt(request.getParameter("selectADD"));
            System.out.println("memu_nameADD---> "+memu_nameADD+"  memu_priceADD--> "+memu_priceADD+
                    "  selectADD--> "+selectADD);
            mmc.setMemu_name(memu_nameADD);
            mmc.setMemu_price(memu_priceADD);
            mmc.setMeal_ID(selectADD);
            try {
                AC.increase_meum(mmc);
                RequestDispatcher rd=request.getRequestDispatcher("/Show_Change_memu");//show_memu_java
                rd.forward(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        else if(add_type!=null){
            String type_nameADD=request.getParameter("type_name");
            System.out.println("type_nameADD "+type_nameADD);
            try {
                AC.increase_type(type_nameADD);
                RequestDispatcher rd=request.getRequestDispatcher("/Show_Change_memu");//show_memu_java
                rd.forward(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

//        super.doPost(request, response);
    }
}
