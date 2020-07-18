package Report;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RepCbox")
public class Report_checkbox extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getSession().getAttribute("d1"));
        System.out.println(request.getSession().getAttribute("d2"));
        String[] type_ID=request.getParameterValues("Check_out_box_type");
        String[] MEMU_ID=request.getParameterValues("Check_out_box_memu");
        if(type_ID!=null){
            for(String a:type_ID){
                System.out.println(a);
            }
        }
      if(MEMU_ID!=null){
          for(String a:MEMU_ID){
              System.out.println(a);
          }
      }

//        System.out.println(request.getParameterValues("Check_out_box_type"));
        super.doPost( request, response);
    }
}
