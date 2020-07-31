package Control;

import Interface_package.Memu_ACT;
import Test_HIB.MemuEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@Controller
public class MemuController {
    static String xml = "Project.xml";
    static ApplicationContext ap= new ClassPathXmlApplicationContext(xml);
    String returnpage = null;
    @RequestMapping("MemuManager_Change")
    public String MemuManagerChange(HttpServletRequest request, HttpServletResponse response)
            throws SQLException {
        Memu_ACT AC=(Memu_ACT) ap.getBean("Memu_A");//<bean id="Test" class="user_Model.user_Action"></bean>
        MemuEntity mmc=(MemuEntity) ap.getBean("HIBMemu_M");//<bean id="user_M" class="user_Model.user_
        String memu_delete=request.getParameter("memu_delete");
        String memu_check=request.getParameter("memu_check");
        String  memu_add=request.getParameter("memu_add");
        String add_type=request.getParameter("add_type");
        if(memu_delete!=null){
            mmc.setMemuId(Integer.parseInt(request.getParameter("memu_delete")));
            AC.Delete(mmc);


        }
        else if(memu_check!=null){
            String[] type=request.getParameterValues("Test_select");
            String [] memu_name=request.getParameterValues("memu_name");
            String [] memu_ID=request.getParameterValues("memu_ID");
            String [] memu_price=request.getParameterValues("memu_price");
            AC.update_Food(memu_ID, memu_name, memu_price, type);
        }
        else if(memu_add!=null){
            String memu_nameADD=request.getParameter("memu_nameADD");
            int memu_priceADD=Integer.parseInt(request.getParameter("memu_priceADD"));
            int selectADD=Integer.parseInt(request.getParameter("selectADD"));
            mmc.setName(memu_nameADD);
            mmc.setPrice(memu_priceADD);
            mmc.setMealId(selectADD);
            AC.increase_meum(mmc);
        }
        else if(add_type!=null){
            String type_nameADD=request.getParameter("type_name");
            AC.increase_type(type_nameADD);
        }
        return "forward:MemuShow_Change";
    }
    @RequestMapping("MemuShow_Change")
    public String MemuShowChange(HttpServletRequest request, HttpServletResponse response)
            throws SQLException {
        return "forward:Userpage_Manage_memu";
//        Memu_ACT AC=(Memu_ACT) ap.getBean("Memu_A");
//        MemuEntity mm=(MemuEntity) ap.getBean("HIBMemu_M");
//        MealTypeEntity mL=(MealTypeEntity)  ap.getBean("HIBMealType_M");
//        ArrayList<MemuEntity> show_model=AC.Show_memu(mm);
//        ArrayList< MealTypeEntity > Food_kind=AC.Food_kind(mL);
//        request.setAttribute("show_memu_model",show_model);
//        request.setAttribute("leng_show_memu_model",show_model.size());
//        request.setAttribute("Food_kind",Food_kind);
//        returnpage="Show_memu";
//        return returnpage;

    }

}
