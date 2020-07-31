package Control;

import Model_package.Report_A;
import Report.Report_Model;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ReportIncomeController {
    static String xml = "Project.xml";
    static ApplicationContext ap= new ClassPathXmlApplicationContext(xml);
    String returnpage = null;
    @RequestMapping("/ReportIncomeDate")
    public String ReportIncome_Date(HttpServletRequest request , HttpServletResponse response) {
        String date=request.getParameter("date");
        String total=request.getParameter("total");
        if(total!=null ){
            request.setAttribute("type","total");
            request.getSession().setAttribute("type","total");
            returnpage="Report_FF";
        }
        else if(date!=null){
            request.setAttribute("type","date");
            request.getSession().setAttribute("type","date");
            returnpage="Report_FF";
        }
        return  returnpage;
    }
    @RequestMapping("/ReportIncomeChooseDate")
    public String ReportIncome_ChooseDate(HttpServletRequest request , HttpServletResponse response)
            throws ParseException, SQLException {
        Report_A RAC=( Report_A) ap.getBean("Report_A");
        String d1=request.getParameter("date1");
        String d2=request.getParameter("date2");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(request.getSession().getAttribute("type")=="date") {
            if (d1 == "" | d2 == "") {
                request.setAttribute("switch_day", "pls add_day");
            }
            else{
                Date sdfd1 = sdf.parse(d1);
                Date sdfd2 = sdf.parse(d2);
                if (sdfd1.compareTo(sdfd2) > 0) {
                    request.setAttribute("switch_day", "pls switch_day");
                }
                else {
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
                    ArrayList<Report_Model> RMM=RAC.ReportV2(d1, d2);
                    request.getSession().setAttribute("Rep_eachday", RMM);

                }
            }
        }

        else if(request.getSession().getAttribute("type")=="total"){
            request.setAttribute("check", "ok");//for check_box------------->
            String option=request.getParameter("select_YM");
            ArrayList<Report_Model> RMM = RAC.ReportV3(option);
            request.getSession().setAttribute("Rep_eachday", RMM);
        }
        returnpage="Report_FF";
        return  returnpage;
    }



}
