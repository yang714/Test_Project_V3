package Check_Out;

import Check_out_model.Checkout_model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/Confirm_pagev2")
public class Show_check_out extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            System.out.println(request);
        String SD=request.getParameter("select_Discount");
        ///
        request.setAttribute("SD",SD);
        String Discount=(request.getParameter("select_Discount"));
        System.out.println("select_Discount---->"+Discount);
        ///
        Checkout_model[] test_ccm=  ( Checkout_model[]) request.getSession().getAttribute("check_outorder");//原始
        ////
        Checkout_model[] t_ccm= new Checkout_model[test_ccm.length];
        int c=0;
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
            ///

            t_ccm[i]=tt;
        }
        ////

        for(Checkout_model i:t_ccm){

            System.out.println("origin i.getOrder_ID() "+i.getOrder_ID()+" i.getMemuname() "+
                    i.getMemuname()+"  i.getChecknumber()  "+i.getChecknumber()+"  i.getPrice() "+i.getPrice()+"  i.getPrice() "+i.getPrice());//剩下的
        }

//        for (int u=0;u<t_ccm.length;u++){
//            t_ccm[u].setPrice((int)(t_ccm[u].getPrice()*Double.valueOf(Discount)));//after discount
//        }

        for(Checkout_model i:t_ccm){

            System.out.println("after i.getOrder_ID() "+i.getOrder_ID()+" i.getMemuname() "+
                    i.getMemuname()+"  i.getChecknumber()  "+i.getChecknumber()+"  i.getPrice() "+i.getPrice()+
                    "  i.getPrice() "+i.getPrice()+"  i.getOrder_number()"+i.getOrder_number()+" i.getWho_order() "
                    +i.getWho_order()+" i.getFood_status() "+i.getFood_status()+" i.getMemu_ID() "+i.getMemu_ID()+
                    "after i.getDiscountP() "+i.getDiscountP()+" AFTER i.getDprice() "+i.getDprice()
            );//剩下的
        }
        System.out.println("select_Discount"+request.getParameter("select_Discount"));
//        response.sendRedirect("Check_out/check_out.jsp");
        if(request.getSession().getAttribute("After_Discount")!=null){
            request.getSession().removeAttribute("After_Discount");
        }
        request.getSession().setAttribute("After_Discount", t_ccm);
        request.setAttribute("Discount ",Discount);
        RequestDispatcher RD=request.getRequestDispatcher("/show_detail.jsp");
        RD.forward(request,response);


//        Checkout_model ccm = new Checkout_model();
//        ccm.setOrder_ID(RS.getInt(1));
//        ccm.setWho_order(RS.getInt(2));
//        ccm.setOrderTableID(RS.getInt(3));
//        ccm.setMemu_ID(RS.getInt(4));
//        ccm.setOrder_number(RS.getInt(5));
//        ccm.setMemuname(RS.getString(6));
//        ccm.setTableidname(RS.getString(7));
//        super.doPost(request, response);
    }
}
