package Control;

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
public class DiscountController {
    static String xml = "Project.xml";
    static ApplicationContext ap= new ClassPathXmlApplicationContext(xml);
    String returnpage = null;
    @RequestMapping(value = {"/Discount_Controller","/Discount_Detail"})
    public String Discount(HttpServletRequest request , HttpServletResponse response)
            throws SQLException {
        Discount_inf DAC=(Discount_inf) ap.getBean("Discount_A");
        String Discount_name=request.getParameter("Dname");
        String Discount_percent=request.getParameter("Dpercent");
        request.setAttribute("add_Discount",request.getParameter("add_Discount"));
        request.setAttribute("Show_delete",request.getParameter("Show_delete"));
        request.setAttribute("DelDiscount",request.getParameter("DelDiscount"));
        if(request.getAttribute("add_Discount")!=null) {
            DAC.addnewDis(Discount_name, Discount_percent);
            request.removeAttribute("add_Discount");
        }
        else if(request.getAttribute("Show_delete")!=null){
            ArrayList<DiscountPEntity> DDAC=DAC.Show_Delete();
            request.setAttribute("Show_delete",DDAC);
        }
        else if(request.getAttribute("DelDiscount")!=null){
            String SELDE= request.getParameter("select_delete");
            DAC.DeleteDis(SELDE);
        }
        returnpage="Discount_Manage";
        return returnpage;
    }

}
