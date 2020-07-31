package Control;

import Interface_package.Order_Table_Interface;
import Test_HIB.MemuEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class OrderController {
    static String xml = "Project.xml";
    static ApplicationContext ap= new ClassPathXmlApplicationContext(xml);
    String returnpage = null;
    @RequestMapping("/Order_Controller")
    public String Order(HttpServletRequest request , HttpServletResponse response) {
        return "forward:Userpage_Order";
    }
    @RequestMapping("/Order_Out")
    public String OrderOut(HttpServletRequest request , HttpServletResponse response)
    {
        request.getSession().removeAttribute("select_table_name");
        request.getSession().removeAttribute("select_table_number");
        returnpage="User_page";
        return returnpage;
    }

    @RequestMapping("/OrderSend")
    public String Order_Sendt(HttpServletRequest request , HttpServletResponse response) throws SQLException {
//        int meal_ID = Integer.parseInt(request.getParameter("meal_order"));
//        int number_meal = Integer.parseInt(request.getParameter("meal_number"));
        String tname = (String) request.getSession().getAttribute("select_table_name");
        String tnumber = (String) request.getSession().getAttribute("select_table_number");
        String[] ccc = request.getParameterValues("meal_ID");
        String[] c = request.getParameterValues("meal_name");
        String[] cc = request.getParameterValues("meal_number");
        if (ccc == null) {
            System.out.println("here");
            request.getSession().removeAttribute("select_table_name");
            request.getSession().removeAttribute("select_table_number");
            returnpage="order_page";
        }
        else{
            Order_Table_Interface AC = (Order_Table_Interface) ap.getBean("Order_A");
            if(tnumber.equals("-")){
                request.getSession().removeAttribute("select_table_name");
                request.getSession().removeAttribute("select_table_number");
                returnpage="order_page";
            }
            else {
                int t_id = AC.FindTable_ID(tname, tnumber);
                ArrayList<MemuEntity> om = AC.Save_Order(ccc, c, cc);
                AC.SaveOrder2DataB(request.getSession().getAttribute("user_id"), t_id, om);
                request.getSession().removeAttribute("select_table_name");
                request.getSession().removeAttribute("select_table_number");
                returnpage = "User_page";
            }
        }
        return returnpage;
    }

}
