package Control;

import Interface_package.Check_out_intf;
import Check_out_model.Checkout_model;
import Interface_package.Discount_inf;
import Test_HIB.DiscountPEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class CheckOutController {
    static String xml = "Project.xml";
    static ApplicationContext ap= new ClassPathXmlApplicationContext(xml);
    String returnpage = null;
    @RequestMapping("/CheckOut_Controller")
    public String CheckOut(HttpServletRequest request , HttpServletResponse response)
            throws SQLException {
        String tablename = null;
        Check_out_intf ca=(Check_out_intf) ap.getBean("Check_A");
        Discount_inf DA=(Discount_inf) ap.getBean("Discount_A");
        String rpjojo=request.getParameter("jojo");
        String Check= request.getParameter("Check_out");
        if( rpjojo!=null){
            request.setAttribute("table_id",rpjojo);
            request.getSession().setAttribute("table_id",rpjojo);
            request.getSession().setAttribute("Check", Check);
            request.getSession().setAttribute("PARAM",rpjojo);
        }
        if(request.getSession().getAttribute("PARAM")!=null
                && request.getSession().getAttribute("Check") == null){
            ArrayList<Checkout_model> ccm = ca.show_order(Integer.parseInt((String) request.getSession().getAttribute("PARAM")));
            if (ccm.size() == 0) {//not order table
//                        tablename = ca.Tableidname(Integer.parseInt(request.getParameter("jojo")));//?
                tablename = ca.Tableidname(Integer.parseInt((String) request.getSession().getAttribute("PARAM")));//?
                request.setAttribute("order_table_free", tablename + " table not order");
            }
            request.getSession().setAttribute("check_outorder", ccm);
            request.getSession().setAttribute("PARAM",  request.getSession().getAttribute("PARAM"));

        }
        if(request.getSession().getAttribute("Check") == null){
            returnpage="check_out";
        }
        else{
            String[] Check_idnumber = request.getParameterValues("Check_out_box");
            String[] ORDER_NUMBER = request.getParameterValues("test");
            if( Check_idnumber==null){
                request.setAttribute("table_id",rpjojo);
                request.getSession().removeAttribute("table_id");
                request.getSession().removeAttribute("Check");
                request.getSession().removeAttribute("PARAM");
                request.removeAttribute("order_table_free");
                request.getSession().removeAttribute("check_outorder");
                return "forward:Userpage_CheckOut";
            }
            else{
                Checkout_model[] FC = ca.FOODNAME_CHECK(Check_idnumber, ORDER_NUMBER);
                request.getSession().setAttribute("check_outorder", FC);//原始價格
                request.getSession().removeAttribute("Check");
                ArrayList<DiscountPEntity> show_dis = DA.Show_Delete();
                request.getSession().setAttribute("show_dis", show_dis);
                returnpage= "show_detail";
            }
        }

        return returnpage;

    }

    @RequestMapping("/CheckOutshow_back")
    public String CheckOut_show(HttpServletRequest request , HttpServletResponse response)
            throws SQLException {
        request.getSession().removeAttribute("table_id");
        request.getSession().removeAttribute("Check");
        request.getSession().removeAttribute("PARAM");
        request.getSession().removeAttribute("check_outorder");
        request.getSession().removeAttribute("After_Discount");
        returnpage="check_out";
        return returnpage;
    }


//    @RequestMapping("/CheckOutshow")
//    public String CheckOut_show(HttpServletRequest request , HttpServletResponse response)
//            throws SQLException {
//        order_inf AC=(order_inf) ap.getBean("Table_A");//<bean id="Test" class="user_Model.user_Action"></bean>
//        Table_model tm=(Table_model) ap.getBean("Table_model");//<bean id="user_M" class="user_Model.user_M"></bean>
//        ArrayList<TableKindEntity>TNN=AC.Table_namenumber(tm);
//        request.getSession().setAttribute("table_name_id",TNN);
//        returnpage="check_out";
//        return  returnpage;
//    }

}
