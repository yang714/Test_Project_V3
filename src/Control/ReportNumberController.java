package Control;

import Interface_package.Memu_ACT;
import Model_package.Report_NA;
import Test_HIB.MealTypeEntity;
import Test_HIB.MemuEntity;
import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class ReportNumberController {
    static String xml = "Project.xml";
    static ApplicationContext ap= new ClassPathXmlApplicationContext(xml);
    String returnpage = null;
    @RequestMapping("/ReportNumberType")
    public String ReportNumber_Type(HttpServletRequest request , HttpServletResponse response) throws SQLException {
        Memu_ACT AC=(Memu_ACT) ap.getBean("Memu_A");//<bean id="Test" class="user_Model.user_Action"></bean>
        MemuEntity mm=(MemuEntity) ap.getBean("HIBMemu_M");//<bean id="user_M" class="user_Model.user_
        Report_NA RAC=(Report_NA) ap.getBean("ReportN_A");
        MealTypeEntity mL=(MealTypeEntity)  ap.getBean("HIBMealType_M");
        if(request.getParameter("Meal")!=null){
            request.getSession().setAttribute("CHtype",request.getParameter("Meal"));
            ArrayList<MealTypeEntity> Food_kind=AC.Food_kind(mL);
            request.setAttribute("food_type",Food_kind);
            request.getSession().setAttribute("food_type",Food_kind);//
        }
        else if(request.getParameter("Memu")!=null){
            request.getSession().setAttribute("CHtype",request.getParameter("Memu"));
            ArrayList<MemuEntity> Show_memu= AC.Show_memu(mm);
            request.setAttribute("show_memu",Show_memu);
            request.getSession().setAttribute("show_memu",Show_memu);//
        }
        ArrayList<Integer>AY= RAC.Report_GETY();
        request.getSession().setAttribute("getYear",AY);
        returnpage="Report_Number";
        return returnpage;

    }
    @RequestMapping("/ReportNumberDate")
    public String ReportNumber_Date(HttpServletRequest request , HttpServletResponse response) throws SQLException {
        Report_NA RAC=(Report_NA) ap.getBean("ReportN_A");
        String chooseMM=request.getParameter("chooseMM");
        String year=request.getParameter("getYear");
        String Mon=request.getParameter("getMonth");
        JSONObject getRAC= null;
        if(chooseMM.equals("Meal_SUB")){
            getRAC = RAC.Report_Meal(Integer.valueOf(year),Integer.valueOf(Mon),request.getParameterValues("Check_out_box"));
        }
        else if(chooseMM.equals("Memu_SUB")){
            getRAC = RAC.Report_Memu(Integer.valueOf(year),Integer.valueOf(Mon),request.getParameterValues("Check_out_box"));
        }
        request.setAttribute("getRAC",getRAC);
        request.getSession().setAttribute("chooseMM",chooseMM);
        request.getSession().setAttribute("year",year);
        request.getSession().setAttribute("Mon",Mon);
        returnpage="Report_Number";
        return returnpage;
    }
    @RequestMapping("/ReportNumberBack")
    public String ReportNumber_Back(HttpServletRequest request , HttpServletResponse response) throws SQLException {
        request.getSession().removeAttribute("food_type");
        request.getSession().removeAttribute("show_memu");
        request.getSession().removeAttribute("CHtype");
        request.getSession().removeAttribute("chooseMM");
        request.removeAttribute("getRAC");
        returnpage="User_page";
        return returnpage;
    }
}
