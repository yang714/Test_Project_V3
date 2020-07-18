package Order_table_page;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import Interface.Action;
import Memu_model.Memu_M;
import Order_Table.Order_Table_Interface;
import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import user_Model.user_M;

@WebServlet("/Test_meal")
public class Test_meal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//        if(request.getParameter("out")!=null){
//            System.out.println("request.getParameter(\"out\")"+request.getParameter("out"));
//            request.getSession().removeAttribute("select_table_name");
//            request.getSession().removeAttribute("select_table_number");
//            response.sendRedirect("User_page.jsp");
//        }
//        if(request.getParameter("send")!=null &request.getParameter("out" )==null){
//            if(request.getParameter("send")!=null){
        int meal_ID = Integer.parseInt(request.getParameter("meal_order"));
        int number_meal = Integer.parseInt(request.getParameter("meal_number"));
        String tname = (String) request.getSession().getAttribute("select_table_name");
        String tnumber = (String) request.getSession().getAttribute("select_table_number");

        System.out.println("tname " + tname + "   " + "  tnumber " + tnumber + "  meal_ID " + meal_ID + "meal_number" + number_meal);
        System.out.println("ID" + request.getSession().getAttribute("login_um_id_number"));
//        if(request.getSession().getAttribute("ADD_meal")==null){
//            JSONObject mealid_howmuch = new JSONObject();
//            mealid_howmuch.put(meal_ID,number_meal);
//        }

        String[] ccc = request.getParameterValues("meal_ID");
//        System.out.println("c-->  "+ccc[0]+"-----"+ccc[1]);
        String[] c = request.getParameterValues("meal_name");
//        System.out.println("c-->  "+c[0]+"-----"+c[1]);
        String[] cc = request.getParameterValues("meal_number");
//        System.out.println("cc-->  "+cc[0]+"-----"+cc[1]);
        //        super.doPost(req, resp);
        System.out.println(ccc + "--->" + cc + "---->" + c);
        if (ccc == null) {
            System.out.println("here");
            request.getSession().removeAttribute("select_table_name");
            request.getSession().removeAttribute("select_table_number");
            RequestDispatcher RD = request.getRequestDispatcher("order_page/order_page.jsp");
            RD.forward(request, response);
        } else {

            String xml = "Project.xml";
            ApplicationContext ap = new ClassPathXmlApplicationContext(xml);
            Order_Table_Interface AC = (Order_Table_Interface) ap.getBean("Order_A");//<bean id="Test" class="user_Model.user_Action"></bean>
            Memu_M um = (Memu_M) ap.getBean("Memu_M");//<bean id="user_M" class="user_Model.user_M"></bean>

            try {
                int t_id = AC.FindTable_ID(tname, tnumber);
                Memu_M[] om = AC.Save_Order(ccc, c, cc);
                for (Memu_M i : om) {
                    System.out.println("id-->  " + i.getMemu_ID() + "---name--" + i.getMemu_name() + "   number " + i.getOrder_meal_number());
                }
                System.out.println("om size" + om.length);
                AC.SaveOrder2DataB(request.getSession().getAttribute("user_id"), t_id, om);
                System.out.println("T_ID  " + t_id);
///
                request.getSession().removeAttribute("select_table_name");
                request.getSession().removeAttribute("select_table_number");
                ///
                RequestDispatcher RD = request.getRequestDispatcher("/User_page.jsp");
                RD.forward(request, response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    }
//}
