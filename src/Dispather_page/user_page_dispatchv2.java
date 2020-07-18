package Dispather_page;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/U_dispatchv2","/U_dispatchV1","/U_dispatchv3"})
public class user_page_dispatchv2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String get_summit=request.getParameter("change_pw");
        String get_Signup=request.getParameter("SIGN_USER");
        String  order=request.getParameter("order");
        String check_out=request.getParameter("checkout");
        System.out.println(get_summit+"   ------->  "+get_Signup+"     order?---> "+order);
        if(get_Signup!=null){

            response.sendRedirect("Sign_up.jsp");
        }

       else if(get_summit!=null){
            response.sendRedirect("change_pw.jsp");
        }
        else if(order!=null){

            RequestDispatcher rd=request.getRequestDispatcher("/Order");
            rd.forward(request,response);
        }

//        else if(order!=null){
//
//            RequestDispatcher rd=request.getRequestDispatcher("/Order");
//            rd.forward(request,response);
//        }
        else if(check_out!=null){
//            RequestDispatcher rd=request.getRequestDispatcher("Check_out/check_out.jsp");
            RequestDispatcher rd=request.getRequestDispatcher("/Check_show");
            rd.forward(request,response);
        }
//
//        else{
//            response.sendRedirect("order_page/order_page.jsp");
//        }

    }
}

