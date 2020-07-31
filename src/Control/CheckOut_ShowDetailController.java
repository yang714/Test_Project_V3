package Control;

import Interface_package.Check_out_intf;
import EX_Entity.Checkout_model;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.SQLException;

@Controller
public class CheckOut_ShowDetailController {
    static String xml = "Project.xml";
    static ApplicationContext ap= new ClassPathXmlApplicationContext(xml);
    String returnpage = null;
    @RequestMapping("/ShowDetail")
    public String ShowDetail(HttpServletRequest request , HttpServletResponse response)
           {
        String SD=request.getParameter("select_Discount");
        request.setAttribute("SD",SD);
        String Discount=(request.getParameter("select_Discount"));
        Checkout_model[] test_ccm=  ( Checkout_model[]) request.getSession().getAttribute("check_outorder");//原始
        Checkout_model[] t_ccm= new Checkout_model[test_ccm.length];
        for(int i=0;i<test_ccm.length;i++){
            Checkout_model tt=new Checkout_model();
            tt.setOrder_ID(test_ccm[i].getOrder_ID());
            tt.setPrice(test_ccm[i].getPrice());
            tt.setChecknumber(test_ccm[i].getChecknumber());
            tt.setMemuname(test_ccm[i].getMemuname());
            tt.setOrder_number(test_ccm[i].getOrder_number());
            tt.setMemu_ID(test_ccm[i].getMemu_ID());
            tt.setWho_order(test_ccm[i].getWho_order());
            tt.setTableidname(test_ccm[i].getTableidname());
            tt.setFood_status(test_ccm[i].getFood_status());
            ///DiscountPercent
            tt.setDiscountP(new BigDecimal(Discount));
            tt.setDprice((int) (test_ccm[i].getPrice()*Double.valueOf(Discount)));//after discount
            t_ccm[i]=tt;
        }
        if(request.getSession().getAttribute("After_Discount")!=null){
            request.getSession().removeAttribute("After_Discount");
        }
        request.getSession().setAttribute("After_Discount", t_ccm);
        request.setAttribute("Discount ",Discount);
        returnpage="show_detail";
        return returnpage;
    }
    @RequestMapping("/ShowDetail_checkout")
    public String ShowDetail_checkout(HttpServletRequest request , HttpServletResponse response)
            throws SQLException {
               Check_out_intf CA=(Check_out_intf) ap.getBean("Check_A");
               Checkout_model[] After_D_ORDER= (Checkout_model[]) request.getSession().getAttribute("After_Discount");
               String[] Check_idnumber = new String[After_D_ORDER.length];
               String[] ORDER_NUMBER =new String[After_D_ORDER.length];
//               ArrayList<String>Check_idnumber=new ArrayList();
//               ArrayList<String>ORDER_NUMBER=new ArrayList();
               int c=0;
               for(Checkout_model i:After_D_ORDER) {
                   ORDER_NUMBER[c]= String.valueOf(i.getChecknumber());//check_out
                   Check_idnumber[c]= i.getOrder_ID() +","+i.getOrder_number();//i.getOrder_number() total order 數
               c=c+1;
               }
               int  who_check= (int ) request.getSession().getAttribute("user_id");
               CA.UpdateOrder(Check_idnumber,ORDER_NUMBER);
               CA.Update2table(After_D_ORDER,who_check);
        if(request.getSession().getAttribute("After_Discount")!=null){
            request.getSession().removeAttribute("After_Discount");
        }
        return "forward:CheckOut_Controller";

    }
}
