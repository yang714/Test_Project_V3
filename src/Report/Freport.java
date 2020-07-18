package Report;

import Interface.Action;
import Test_show_total.Show_T;
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
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(urlPatterns = {"/RR","/RRR"})//get/check data
public class Freport extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ////
        String xml= "Project.xml";
        ApplicationContext ap=new ClassPathXmlApplicationContext(xml);
        Report_A RAC=( Report_A) ap.getBean("Report_A");
//        user_M um=(user_M) ap.getBean("user_M");//
        ////
        System.out.println("date1 "+request.getParameter("date1")+"  date2 "+request.getParameter("date2"));
        String d1=request.getParameter("date1");
        String d2=request.getParameter("date2");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("????");
        if(request.getSession().getAttribute("type")=="date") {
            try {
                System.out.println("jojo");
                if (d1 == "" | d2 == "") {
                    System.out.println("<------------------>");
                    request.setAttribute("switch_day", "pls add_day");

//                RequestDispatcher rd=request.getRequestDispatcher("Report_FF.jsp");
//                rd.forward(request,response);
                } else {
                    Date sdfd1 = sdf.parse(d1);
                    Date sdfd2 = sdf.parse(d2);
                    System.out.println("sdfd1" + sdfd1 + "  sdfd2" + sdfd2);
                    if (sdfd1.compareTo(sdfd2) > 0) {
                        System.out.println("error");
                        request.setAttribute("switch_day", "pls switch_day");
//                    RequestDispatcher rd=request.getRequestDispatcher("Report_FF.jsp");
//                    rd.forward(request,response);
                    } else {
                        LocalDate start = LocalDate.parse(d1);
                        LocalDate end = LocalDate.parse(d2);
                        System.out.println("date1 ok " + request.getParameter("date1") + "  date2 " + request.getParameter("date2"));
                        request.getSession().setAttribute("d1", request.getParameter("date1"));
                        request.getSession().setAttribute("d2", request.getParameter("date2"));
                        request.setAttribute("check", "ok");//for check_box------------->
                        // dates between two dates
                        List<LocalDate> totalDates = new ArrayList<>();
                        while (!start.isAfter(end)) {
                            totalDates.add(start);
                            start = start.plusDays(1);

                        }
//                    for(LocalDate i :totalDates){
//                        System.out.println("i-->  "+ i);
//                    }
//                        Report_Model[] RMM = RAC.ReportV2(d1, d2);
                        ArrayList<Report_Model> RMM=RAC.ReportV2(d1, d2);
                        request.getSession().setAttribute("Rep_eachday", RMM);

                    }

                }

            } catch (ParseException | SQLException e) {
                System.out.println("dio");
                e.printStackTrace();
            }
        }
        else if(request.getSession().getAttribute("type")=="total"){
            request.setAttribute("check", "ok");//for check_box------------->
String option=request.getParameter("select_YM");
System.out.println("option--->"+option);
            try {
//                Report_Model[] RMM = RAC.ReportV3(option);
                ArrayList<Report_Model> RMM = RAC.ReportV3(option);
                request.getSession().setAttribute("Rep_eachday", RMM);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        RequestDispatcher rd=request.getRequestDispatcher("Report_FF.jsp");
        rd.forward(request,response);


//        super.doPost(request, response);
    }
}
