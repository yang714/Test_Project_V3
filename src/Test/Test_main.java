package Test;

import Interface_package.Action;
import Model_package.Table_Action;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Test_main {
//    @Resource(name="Test")
//    private static Action tr;
//    @Resource(name="Test_show")
//    public static Show_T ss;
//    @Resource(name="user_M")
//    private static user_M um;




    static ApplicationContext ap;
    static ApplicationContext app;

    public static void main(String[] args) throws
            SQLException, ClassNotFoundException  {


        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String xmlpath= "Project.xml";
        ap=new ClassPathXmlApplicationContext(xmlpath);


//        System.out.println("tr--->"+tr+"  um--->"+um+"   ss   "+ss);
    Action tr=(Action) ap.getBean("Test");

//    user_M um = (user_M) ap.getBean("user_M") ;
//    um.setId("test_insert");
//    um.setPw("test_insert123");
//    um.setId("jojo");
//    um.setPw("test_insert123");
//    System.out.println("HERE");
//    int[] A=tr.check(um);
////    System.out.println("A--> "+A[0]+"   "+A[1]);
//    System.out.print(A);
////      tr.insert(um);
////     tr.check_ID( um);
////        Action tr=(Action) ap.getBean("Test");
////        user_M um = (user_M) ap.getBean("user_M") ;
//        try {
//            user_M[] all= tr.Show_user(um);
//           for(int i=0;i<all.length;i++){
//               System.out.println("id number "+all[i].getId_number()+"  id name"+all[i].getId()+" DATE "+all[i].getDate()+" UorM "+all[i].getUM_number());
//           }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        um.setId_number(4007);
//        tr.Delete(um);
//
//
//------------------------------------------------
//        app=new ClassPathXmlApplicationContext(xmlpath);
//        Memu_ACT ACM=(Memu_ACT) app.getBean("Memu_A");
//        Memu_M mm=(Memu_M) app.getBean("Memu_M");
////        Memu_M[]testall=  ACM.Show_memu(mm);
//        ArrayList<Memu_M> testall=ACM.Show_memu(mm);
//        for(int i=0;i<testall.size();i++){
//            System.out.println("name "+ testall.get(i).getMemu_name()+" type  "+ testall.get(i).getFood_type());
//        }
//
//        user_M um = (user_M) ap.getBean("user_M") ;
        Table_Action ta=(Table_Action)ap.getBean("Table_A");
        ta.Table_name();
        System.out.println(ta);

        System.out.println(ta.Table_number("A"));

    }

}
