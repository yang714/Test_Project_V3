package Check_Out;

import Check_out_interface.Check_out_intf;
import Check_out_model.Check_out_Action;
import Check_out_model.Checkout_model;
import Test_show_total.Show_T;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AFDiscount")
public class Update_check_out extends HttpServlet {
    @Resource(name = "DataS")
    DataSource ds;
//    @Resource(name="Test_show")
//    public Show_T ss;
//    @Resource(name="Check_A")
//    public Check_out_Action CA;

    static ApplicationContext ap;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------------------------------------------");
        String xmlpath= "Project.xml";
        ap=new ClassPathXmlApplicationContext(xmlpath);
        Check_out_intf CA=(Check_out_intf) ap.getBean("Check_A");

        Checkout_model[] After_D_ORDER= (Checkout_model[]) request.getSession().getAttribute("After_Discount");

        String[] Check_idnumber = new String[After_D_ORDER.length];
        String[] ORDER_NUMBER =new String[After_D_ORDER.length];
          int c=0;
        for(Checkout_model i:After_D_ORDER) {

            System.out.println("After_D_ORDER: i.getOrder_ID() " + i.getOrder_ID() + " i.getMemuname() " +
                    i.getMemuname() + "  i.getChecknumber()  " + i.getChecknumber() + "  i.getPrice() " + i.getPrice() +
                    "  i.getPrice() " + i.getPrice() + "  i.getOrder_number()" + i.getOrder_number() + " i.getWho_order() "
                    + i.getWho_order() + " i.getFood_status() " + i.getFood_status()+"   "+"  "+i.getOrder_number()
            );//剩下的
//            Check_idnumber[c]= String.valueOf(new String[]{String.valueOf(i.getOrder_ID()), String.valueOf(i.getOrder_number())});
            ORDER_NUMBER[c]= String.valueOf(i.getChecknumber());//check_out
            Check_idnumber[c]= i.getOrder_ID() +","+i.getOrder_number();//i.getOrder_number() total order 數
//            Check_idnumber[c]= "1,2";
            c=c+1;
        }

        for(String aa:Check_idnumber){
            System.out.println("---->  "+aa);
            String[] tokens = aa.split(",");
            System.out.println(tokens[0]+"  <>  "+tokens[1]);//ID ,order number
//            save_id.add(tokens[0]);
        }
        int  who_check= (int ) request.getSession().getAttribute("user_id");
        try {
            CA.UpdateOrder(Check_idnumber,ORDER_NUMBER);
            CA.Update2table(After_D_ORDER,who_check);
            ///
            if(request.getSession().getAttribute("After_Discount")!=null){
                request.getSession().removeAttribute("After_Discount");
            }
            ///
        RequestDispatcher RD=request.getRequestDispatcher("/Checkoutdb");
        RD.forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

//        super.doPost(request, response);
    }
}
