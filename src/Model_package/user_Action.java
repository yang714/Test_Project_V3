package Model_package;

import HibernateUtilpack.HibernateUtil;
import Interface_package.Action;
import Interface_package.Show_T;
import Test_HIB.User1Entity;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

//import HibernateUtilpack.HibernateUtil;
public class user_Action implements Action {


    @Resource(name = "DataS")
    DataSource ds;
    @Resource(name="Test_show")
    public Show_T ss;


    public int[] check(User1Entity um) throws SQLException {
        Boolean SEND=false;
        int[] send = new int[0];

        System.out.println("ss***>s "+ ss);
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println(um.getId()+" >>>!!!!!<<<  "+um.getUserPw());
        //            System.out.print(um.getId()+"  "+um.getPw());
//            Connection cnn=ds.getConnection();
//            PreparedStatement ps=cnn.prepareStatement(
//                    "select * from User_1 where user_name=? and user_pw=? collate Chinese_Taiwan_CS_AI");
////            PreparedStatement ps=cnn.prepareStatement(
////                    "select * from User_1");
//            ps.setString(1,um.getId());
//            ps.setString(2,um.getPw());
//            ResultSet rs=ps.executeQuery();
        //Hibernate******************************//

        System.out.println(um.getUserName()+"  "+um.getUserPw());
        Query  query = session.createQuery("from User1Entity where userName=?1 and userPw=?2 ");

        query.setParameter(1, um.getUserName());
        query.setParameter(2, um.getUserPw());
        System.out.println("quary-->"+query);


        Iterator us = query.list().iterator();
        if(us.hasNext()){
            User1Entity umm= (User1Entity )us.next();
            System.out.println("1-getId()->"+umm.getId()+" umm.getUM_number() "+umm.getUserOrMaster()
                    +"  umm.getDate() "+umm.getDate()+" umm.getId_number() "+umm.getUserName()+
                    "  umm.getPw() "+umm.getUserPw());
           if(umm.getUserName().equals(um.getUserName()) && umm.getUserPw().equals(um.getUserPw())){
               send= new int[]{umm.getUserOrMaster(), umm.getId()};
               SEND=true;
           }
//            return new int[]{umm.getUserOrMaster(),umm.getId()};

        }
        if(SEND==true){
            return   send;
        }

//        while(us.hasNext()) {
//
//            User1Entity umm= (User1Entity )us.next();
//
////            user_M umm=  us.next();
////            System.out.println("test");
//            System.out.println("1-getId()->"+umm.getId()+" umm.getUM_number() "+umm.getUserOrMaster()
//                    +"  umm.getDate() "+umm.getDate()+" umm.getId_number() "+umm.getUserName()+
//                    "  umm.getPw() "+umm.getUserPw());
//
//        }


        //Hibernate******************************//

//            if(rs.next()) {
//                System.out.println("1-->"+rs.getString(1)+"  (2) "+rs.getString(2)+"  "+
//                        rs.getString(3)+"       "+rs.getInt(4));
////                System.out.print(rs.getString(2)+"  "+rs.getString(3));
////                um.setId_number(rs.getInt(4));
//                return new int[]{rs.getInt(4), rs.getInt(1)};
////                if(rs.getInt(4)==1){
////                    return 1;
//////                            return "pag_user";
////                }
////                else if(rs.getInt(4)==0){
////                    return 0;
//////                    return "pag_Master";
////                }
//
//
//            }
        session.close();
        return null;
//        return "pag_user";
    }

    public void insert(User1Entity um) throws SQLException {
        Boolean success=false;
        //Hibernet***********************************//
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();
        if(check_ID(um)==false){
            String sql="INSERT INTO User_1 (user_name,user_pw,UserOrMaster) VALUES (?,?,?)";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(1, um.getUserName());
            query.setParameter(2, um.getUserPw());
            query.setParameter(3, um.getUserOrMaster());
            query.executeUpdate();
            session.close();
            //session.save(um);
//            success=true;
//            tx.commit();
        }
        else{
//            success=false;
        }

        //**************************************//
//
//        Connection cnn=ds.getConnection();
////        boolean userexist=true;
//        if(check_ID(um)==true){
//
//        }
//        try {
//
//
//            PreparedStatement ps=cnn.prepareStatement(
//                    "INSERT INTO User_1 (user_name,user_pw,UserOrMaster)\n" +
//                            "VALUES (?,?,?) ");
//            ps.setString(1,um.getId());
//            ps.setString(2,um.getPw());
//            ps.setInt(3,um.getUM_number());
//
//            ps.executeQuery();
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }

    }



    public boolean check_ID(User1Entity um){

        boolean send=false;
        boolean exist_in_Table = false;

        //HIBERNET*******************************************//
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query  query = session.createQuery("from User1Entity where userName=?1 ");
        query.setParameter(1, um.getUserName());
        Iterator us = query.list().iterator();
        if(us.hasNext()){
            User1Entity umm= (User1Entity )us.next();
            if(umm.getUserName().equals(um.getUserName())){
                exist_in_Table = true;
            }

        }
        if(exist_in_Table==true){
            System.out.println("有重複");
        }
        else{
            System.out.println("no重複");
        }
        //*******************************************//
        session.close();
        return exist_in_Table;
//        try {
//            Connection cnn=ds.getConnection();
//            PreparedStatement ps=cnn.prepareStatement(
//                    "select count(*) from User_1 where user_name=? collate Chinese_Taiwan_CS_AI");
//            ps.setString(1,um.getId());
//            ResultSet rs=ps.executeQuery();
//            if(rs.next()){
//                System.out.println("idnumberis  "+rs.getInt(1));
//                if(rs.getInt(1)>=1)
//                {
//                    exist_in_Table = true;
//
//                System.out.println("有重複");
//                }
//                else{
//                    exist_in_Table =false;
//                    System.out.println("no重複");
//
//
//                }
//            }
//
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return exist_in_Table;


    }

    public void chang_pw(User1Entity um){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx= session.beginTransaction();
        try {
            Query query=session.createQuery("UPDATE User1Entity UE set UE.userPw=?1  where UE.userName=?2 ");
            query.setParameter(2,um.getUserName());
            query.setParameter(1,um.getUserPw());
            query.executeUpdate();
            tx.commit();
        }

        catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }

        /****************************************************/

//        try {
//            Connection cnn=ds.getConnection();
//            PreparedStatement ps=cnn.prepareStatement(
//                    "UPDATE User_1  set user_pw=?  where user_name=? ");
//            ps.setString(2,um.getUserName());
//            ps.setString(1,um.getUserPw());
////            ps.setString(3,um.getOld_pw());
//            ps.executeUpdate();
//
//
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

//    public int Show_total(String table) throws SQLException {
//        Connection cnn=ds.getConnection();
//        String query = String.format("SELECT COUNT(*) FROM %s", table);
//        PreparedStatement ps=cnn.prepareStatement(
//                query );
//
//        ResultSet RS_count= ps.executeQuery();
//        RS_count.next();
//        int count=RS_count.getInt(1);
//        //select number------------------------------------
//return count;
//
//    }

    @Override
    public void Delete(User1Entity um) throws SQLException {
       //Hibernet*****************************//
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();
        Query query = session.createQuery("delete  User1Entity where id=?1");
        query.setParameter(1,um.getId());
        query.executeUpdate();
        tx.commit();
        session.close();
        //******************************//

//        try {
//           Connection cnn=ds.getConnection();
//
//           PreparedStatement ps=cnn.prepareStatement("DELETE FROM User_1 WHERE ID=?");
//           ps.setInt(1,um.getId_number());
//           ps.executeQuery();
//       }catch (SQLException e) {
//           e.printStackTrace();
//       }


    }

    public ArrayList<User1Entity> Show_user(User1Entity um){
//        ArrayList<user_M[]> AL=new ArrayList<user_M[]>();



        //HIBER*****************/
        User1Entity[] um_ss = new User1Entity[0];
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query  query = session.createQuery("from User1Entity");
        Iterator us =query.list().iterator();
        ArrayList<User1Entity> ALS=new ArrayList();
        while(us.hasNext()){
            User1Entity uem= (User1Entity )us.next();
//            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
//            sdFormat.format(uem.getDate());
//            System.out.println("uem.getDate()"+uem.getDate());
//            Date date = sdFormat.format(uem.getDate());
//            uem.setDate(uem.getDate());
            ALS.add(uem);

        }
        return ALS;
       //******************/
//        user_M[] um_s = new user_M[0];
//        System.out.println("here");
//        try {
//            Connection cnn=ds.getConnection();
//            PreparedStatement ps=cnn.prepareStatement(
//                    "select * from User_1");
////
//           ResultSet RS= ps.executeQuery();
//
//           //select number------------------------------------
////            int count=Show_total("User_1");
//            int count=ss.Show_total("SELECT COUNT(*) FROM User_1");
////            System.out.println("here count "+count);
//            //------------------------------
//            um_s=new user_M[count];
//            int c=0;
//           while(RS.next()){
//               um = new user_M();//new 物件 deep copy
////               System.out.println("----->"+RS.getString(2));
//               um.setId_number(RS.getInt(1));
//               um.setId(RS.getString(2));
//               um.setPw(RS.getString(3));
//               um.setDate((java.util.Date) RS.getDate(5));
//               um.setUM_number(RS.getInt(4));
//               um_s[c]=um;
////               System.out.println(um_s[c].getId());
//               c=c+1;
//
//           }
////           for(int j=0;j<c;j++){
////               System.out.println("*****"+um_s[j].getId());
////           }
//
//
//
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return um_s;
    }


}
