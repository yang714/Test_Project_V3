package Control;

import Model_package.VLC_EX;
import Interface_package.Action;
import Interface_package.Memu_ACT;
import EX_Entity.Table_model;
import Test_HIB.MealTypeEntity;
import Test_HIB.MemuEntity;
import Test_HIB.TableKindEntity;
import Test_HIB.User1Entity;
import Interface_package.order_inf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class UserPageController {
    static String xml = "Project.xml";
    static ApplicationContext ap= new ClassPathXmlApplicationContext(xml);
    String returnpage = null;
    @RequestMapping("/Userpage_Singup")
    public String UserPageSignUp(HttpServletRequest request, HttpServletResponse response) throws Exception {
        returnpage="Sign_up";
        return returnpage;
    }
    @RequestMapping("/Userpage_ShowU")
    public String UserPageShowU(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Action AC=(Action) ap.getBean("Test");
        User1Entity um=(User1Entity) ap.getBean("HIBuser_M");
        ArrayList<User1Entity> show_model= AC.Show_user(um);
        request.setAttribute("show_model",show_model);
        request.setAttribute("leng_show_model",show_model.size());
        returnpage="Show_U";
        return returnpage;
    }

    @RequestMapping("/Userpage_Manage_memu")
    public String ManageMemu(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Memu_ACT AC=(Memu_ACT) ap.getBean("Memu_A");
        MemuEntity mm=(MemuEntity) ap.getBean("HIBMemu_M");
        MealTypeEntity mL=(MealTypeEntity)  ap.getBean("HIBMealType_M");
        ArrayList<MemuEntity> show_model=AC.Show_memu(mm);
        ArrayList< MealTypeEntity > Food_kind=AC.Food_kind(mL);
        request.setAttribute("show_memu_model",show_model);
        request.setAttribute("leng_show_memu_model",show_model.size());
        request.setAttribute("Food_kind",Food_kind);
        returnpage="Show_memu";
        return returnpage;
    }

    @RequestMapping("/Userpage_Manage_Discount")
    public String UserPageDiscount(HttpServletRequest request, HttpServletResponse response) throws Exception {
        returnpage="Discount_Manage";
        return returnpage;
    }

    @RequestMapping("/Userpage_ReportIncome")
    public String UserPageReportIncome(HttpServletRequest request, HttpServletResponse response) throws Exception {
        returnpage="Report_FF";
        return returnpage;
    }

    @RequestMapping("/Userpage_ReportNumber")
    public String UserpageReportNumber(HttpServletRequest request, HttpServletResponse response) throws Exception {
        returnpage="Report_Number";
        return returnpage;
    }

    @RequestMapping("/Userpage_IPCC")
    public String UserpageIPCC(HttpServletRequest request, HttpServletResponse response) throws Exception {
        VLC_EX VLC=(VLC_EX) ap.getBean("VLC_EX");
        VLC.testzc();
        returnpage="User_page";
        return returnpage;
    }
    @RequestMapping("/Userpage_ChangePw")
    public String UserpageChangePw(HttpServletRequest request, HttpServletResponse response) throws Exception {
        returnpage="change_pw";
        return returnpage;
    }

    @RequestMapping("/Userpage_Order")
    public String  UserpageOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        order_inf AC=(order_inf) ap.getBean("Table_A");
        MemuEntity mm=(MemuEntity) ap.getBean("HIBMemu_M");
        String out=request.getParameter("out");
        ArrayList total=AC.Table_name();
        request.getSession().setAttribute("sql_table_name",total);//table name AC.Table_name(TM); for jsp
        request.getSession().removeAttribute("select_table_number");
        String table_name=request.getParameter("select_table_name");
        if(request.getSession().getAttribute("select_table_name")!=null) {
            if(table_name!=null){
                if(table_name.equals("-")==false){
                    request.getSession().setAttribute("select_table_name",table_name);
                }
            }
        }
        else{
            request.getSession().setAttribute("select_table_name",table_name);
        }
        if(table_name!=null){
            ArrayList reTM = AC.Table_number( (String) request.getSession().getAttribute("select_table_name"));
            request.getSession().setAttribute("sql_table_number",reTM);//table name AC.Table_name(TM);
            String table_number=request.getParameter("select_table_number");
            request.getSession().setAttribute("select_table_number",table_number);
        }
        ArrayList<MemuEntity> Sm=new ArrayList();
        Sm = AC.call_Memu(mm);
        request.getSession().setAttribute("shoew_memu",Sm);
        returnpage="order_page";
        return returnpage;
    }
//    Check_show

    @RequestMapping("/Userpage_CheckOut")
    public String UserpageCheckOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
        order_inf AC=(order_inf) ap.getBean("Table_A");//<bean id="Test" class="user_Model.user_Action"></bean>
        Table_model tm=(Table_model) ap.getBean("Table_model");//<bean id="user_M" class="user_Model.user_M"></bean>
        ArrayList<TableKindEntity>TNN=AC.Table_namenumber(tm);
        request.getSession().setAttribute("table_name_id",TNN);
        returnpage="check_out";
        return returnpage;
    }
}
