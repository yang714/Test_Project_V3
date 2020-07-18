package order_page;

import Interface.Action;
import Memu_model.Memu_M;
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

@WebServlet("/Order")
public class order extends HttpServlet {//顯示page
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doPost(req, resp);user_id


        System.out.println(request.getSession().getAttribute("login_um_id")+"  "+
        request.getSession().getAttribute("user_id"));
        String xml= "Project.xml";
        ApplicationContext ap=new ClassPathXmlApplicationContext(xml);
        order_inf AC=(order_inf) ap.getBean("Table_A");//<bean id="Test" class="user_Model.user_Action"></bean>
        Table_model TM=(Table_model) ap.getBean("Table_model");
        Memu_M mm=(Memu_M) ap.getBean("Memu_M");
        String out=request.getParameter("out");


        try {

               Table_model[] total=AC.Table_name(TM);
               request.getSession().setAttribute("sql_table_name",total);//table name AC.Table_name(TM); for jsp
               request.getSession().removeAttribute("select_table_number");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String table_name=request.getParameter("select_table_name");
        System.out.println("table_name---> "+table_name);
        System.out.println("table_name  "+table_name);
        if(request.getSession().getAttribute("select_table_name")!=null) {
            if(table_name!=null){
                if(table_name.equals("-")==false){
                    request.getSession().setAttribute("select_table_name",table_name);
                }
            }

        }
        else{
            request.getSession().setAttribute("select_table_name",table_name);
        }

        System.out.println("----"+table_name);
        if(table_name!=null){
            try {
                Table_model[] reTM = AC.Table_number(TM, (String) request.getSession().getAttribute("select_table_name"));
                request.getSession().setAttribute("sql_table_number",reTM);//table name AC.Table_name(TM);
                 String table_number=request.getParameter("select_table_number");
                request.getSession().setAttribute("select_table_number",table_number);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
//        Memu_M[] Sm = new Memu_M[0];
        ArrayList<Memu_M> Sm=new ArrayList();
        try {
            Sm = AC.call_Memu(mm);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (Memu_M i : Sm) {
                        System.out.println("1--> "+i.getMemu_name()+"   "+i.getFood_type());
                    }
              request.getSession().setAttribute("shoew_memu",Sm);

        if(out!=null){

            request.getSession().removeAttribute("select_table_name");
            request.getSession().removeAttribute("select_table_number");
            RequestDispatcher rd=request.getRequestDispatcher("User_page.jsp");
            rd.forward(request,response);
        }




        RequestDispatcher rd=request.getRequestDispatcher("/order_page/order_page.jsp");
        rd.forward(request,response);


        System.out.println("order!!!!");
    }
}
