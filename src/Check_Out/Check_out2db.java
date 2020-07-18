package Check_Out;

import Check_out_interface.Check_out_intf;
import Check_out_model.Checkout_model;
import Discount.Discount_A;
import Discount.Discount_M;
import Discount.Discount_inf;
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
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//@WebServlet("/Checkoutdb")
@WebServlet(urlPatterns = {"/Checkoutdb","/Confirm_page"})
public class Check_out2db extends HttpServlet {

    static ApplicationContext ap;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       /////////
        String xmlpath= "Project.xml";
        ap=new ClassPathXmlApplicationContext(xmlpath);
        Check_out_intf ca=(Check_out_intf) ap.getBean("Check_A");
        Discount_inf DA=(Discount_inf) ap.getBean("Discount_A");
        ///////
        String rpjojo=request.getParameter("jojo");
        String Check= request.getParameter("Check_out");
        System.out.println("test!!!---> "+request.getParameter("jojo"));
//        request.setAttribute("table_id",request.getParameter("jojo"));

        ///////////
//        request.getSession().setAttribute("table_id", request.getParameter("jojo"));
        if( rpjojo!=null){
            request.setAttribute("table_id",rpjojo);
            request.getSession().setAttribute("table_id",rpjojo);
            request.getSession().setAttribute("Check", Check);
            request.getSession().setAttribute("PARAM",rpjojo);
        }

        //////////
        String tablename = null;

        System.out.println("testing===> request.getSession().getAttribute(\"PARAM\")"+request.getSession().getAttribute("PARAM"));
//        request.getSession().setAttribute("PARAM", request.getParameter("jojo"));
//        if (request.getSession().getAttribute("PARAM") == null) {
//            System.out.println("This is a NEW request");
//            request.getSession().setAttribute("PARAM", request.getParameter("jojo"));
//
//        }
//        else if (request.getSession().getAttribute("PARAM").toString().equalsIgnoreCase(rpjojo)) {
//            System.out.println("This is a REFRESH");
//            request.getSession().removeAttribute("PARAM");
//        }

        /////////////////
        System.out.println("PARAM  "+ request.getSession().getAttribute("PARAM"));
        System.out.println("Check  "+ request.getSession().getAttribute("Check"));
        if(request.getSession().getAttribute("PARAM")!=null && request.getSession().getAttribute("Check") == null)
        {
            try {
                System.out.println("top---here");
//                    Checkout_model[] ccm = ca.show_order(Integer.parseInt(request.getParameter("jojo")));
//                Checkout_model[] ccm = ca.show_order(Integer.parseInt((String) request.getSession().getAttribute("PARAM")));
               ArrayList<Checkout_model> ccm = ca.show_order(Integer.parseInt((String) request.getSession().getAttribute("PARAM")));
//                System.out.println("CCM" + ccm.length);
                System.out.println("CCM" + ccm.size());
                if (ccm.size() == 0) {//not order table
//                        tablename = ca.Tableidname(Integer.parseInt(request.getParameter("jojo")));//?
                    tablename = ca.Tableidname(Integer.parseInt((String) request.getSession().getAttribute("PARAM")));//?
                    request.setAttribute("order_table_free", tablename + "table not order");
                }

                request.getSession().setAttribute("check_outorder", ccm);
                /////
//                    request.getSession().setAttribute("PARAM", request.getParameter("jojo"));
                request.getSession().setAttribute("PARAM",  request.getSession().getAttribute("PARAM"));
                ////////

                if(request.getSession().getAttribute("Check") == null){
                    System.out.println("HERE");
                    RequestDispatcher RD=request.getRequestDispatcher("Check_out/check_out.jsp");
                    RD.forward(request,response);
                }

                //////////

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }


        //////////////





        String Check_out = request.getParameter("Check_out");
            ///////////////////////////////////////////////////////////////////////////
            if (request.getSession().getAttribute("Check") == null) {
            System.out.println("This is Check a NEW request");
            request.getSession().setAttribute("Check", request.getParameter("Check_out"));
        }
//            else if (request.getSession().getAttribute("Check").toString().equalsIgnoreCase(Check_out)) {
//            System.out.println("This Check is a REFRESH");
//            request.getSession().removeAttribute("Check");
//        }
//            else {
//            System.out.println("This is Check a NEW request2");
//            request.getSession().setAttribute("Check", request.getParameter("Check_out"));
//        }
//        request.getSession().getAttribute("Check")
        System.out.println("request.getParameter(\"Check_out\")  "+ request.getParameter("Check_out"));
        if(request.getSession().getAttribute("Check")!=null) {
    System.out.println("down---> " + request.getParameter("jojo"));
    String[] Check_idnumber = request.getParameterValues("Check_out_box");
    String[] ORDER_NUMBER = request.getParameterValues("test");
    if( Check_idnumber==null){
        ///
        request.setAttribute("table_id",rpjojo);
        request.getSession().removeAttribute("table_id");
        request.getSession().removeAttribute("Check");
        request.getSession().removeAttribute("PARAM");
        request.removeAttribute("order_table_free");
        request.getSession().removeAttribute("check_outorder");
        ///
        System.out.println("here------------>");
        RequestDispatcher RD=request.getRequestDispatcher("Check_show");
        RD.forward(request,response);
//        response.sendRedirect("Check_show");
    }
    else {
        try {

            System.out.println("down-here--> ");
//        ca.UpdateOrder(Check_idnumber, ORDER_NUMBER);
            Checkout_model[] FC = ca.FOODNAME_CHECK(Check_idnumber, ORDER_NUMBER);
            request.getSession().setAttribute("check_outorder", FC);//原始價格
            //
//        request.getSession().setAttribute("Check", request.getParameter("Check_out"));
//        request.getSession().setAttribute("PARAM", request.getParameter("jojo"));//
//        request.getSession().removeAttribute("Check");
            //
            System.out.println("READY RD");
            request.getSession().removeAttribute("Check");

//        Discount_M[] show_dis=DA.Show_Delete();
            ArrayList<Discount_M> show_dis = DA.Show_Delete();

            request.getSession().setAttribute("show_dis", show_dis);
            RequestDispatcher RD = request.getRequestDispatcher("/show_detail.jsp");
            RD.forward(request, response);
            ////
//        Checkout_model[] ccm = ca.show_order(Integer.parseInt(request.getParameter("jojo")));//show all order
//        request.getSession().setAttribute("check_outorder", ccm);
//        RequestDispatcher RD=request.getRequestDispatcher("Check_out/check_out.jsp");
//        RequestDispatcher RD=request.getRequestDispatcher("/index.jsp");
//        ////
////        RequestDispatcher RD=request.getRequestDispatcher("/Checkoutdb");
//        RD.forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//    RequestDispatcher RD=request.getRequestDispatcher("/User_page.jsp");
//        RD.forward(request,response);
//            response.sendRedirect("User_page.jsp");

}

//        RequestDispatcher RD=request.getRequestDispatcher("Check_out/check_out.jsp");
//        RD.forward(request,response);



    }
}
