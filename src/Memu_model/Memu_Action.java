package Memu_model;

import HibernateUtilpack.HibernateUtil;
import Memu_interface.Memu_ACT;
import Test_HIB.MealTypeEntity;
import Test_HIB.MemuEntity;
import Test_show_total.Show_T;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Memu_Action implements Memu_ACT {
    @Resource(name = "DataS")
    DataSource ds;
    @Resource(name="Test_show")
    public Show_T ss;
//    @Resource(name="Memu_M")
//    public set_get_memu agm;


    public ArrayList<MemuEntity> Show_memu(MemuEntity mem)  {
//        Memu_M[] MM=new Memu_M[0];
//Hibernet*********************************//
        Session session= HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select mem1 from MemuEntity as mem1,MealTypeEntity as m1 where mem1.mealId=m1.mealId " +
                "order by mem1.mealId");
        Iterator us =query.list().iterator();
        ArrayList<MemuEntity> HAMM=new ArrayList();
        while(us.hasNext()){
//            System.out.println("here");
//            MemuEntity me=(MemuEntity) us.next()
//            System.out.println(((MemuEntity) us.next()).getName());
            MemuEntity me=  (MemuEntity) us.next();
            HAMM.add(me);
        }
        System.out.println("HAMM-->"+HAMM.size());
        session.close();
        return  HAMM;

        //********************************//
//        Connection cnn=ds.getConnection();
//        PreparedStatement ps=cnn.prepareStatement(
//                    "SELECT  memu_ID\n" +
//                            "      ,Name\n" +
//                            "      ,Price\n" +
//                            "      ,Memu.meal_ID\n" +
//                            "\t  ,Meal_type.Type\n" +
//                            "  FROM [Test_DataBase].[dbo].[Memu] \n" +
//                            "  join Meal_type \n" +
//                            "  on Memu.meal_ID=Meal_type.meal_ID" +
//                            "  order by Memu.meal_ID ");
//        ResultSet RS= ps.executeQuery();
//                    //select number------------------------------------
////            int count=ss.Show_total("SELECT COUNT(*) FROM Memu");
//        ArrayList<Memu_M> AMM=new ArrayList();
////            System.out.println("here count "+count);
//            //------------------------------
////        Memu_M[] MM=new Memu_M [count];
//
//                    int c=0;
//            while(RS.next()){
//                mem = new Memu_M();//new 物件 deep copy
////               System.out.println("----->"+RS.getString(2));
//                mem.setFood_type(RS.getString(5));
//                mem.setMeal_ID(RS.getInt(4));
//                mem.setMemu_price(RS.getInt(3));
//                mem.setMemu_name(RS.getString(2));
//                mem.setMemu_ID(RS.getInt(1));
////                MM[c]=mem;
////                c=c+1;
//                AMM.add(mem);
////               System.out.println(um_s[c].getId());
//
//
//            }
//
////            return MM;
//            return  AMM;
    }

    @Override
    public ArrayList<MealTypeEntity> Food_kind( MealTypeEntity mt)  {
        //********************************/
        Session session= HibernateUtil.getSessionFactory().openSession();

        Query query=session.createQuery("from  MealTypeEntity ");
        Iterator us=query.list().iterator();
        ArrayList< MealTypeEntity> HBFD=new ArrayList< MealTypeEntity>();
        while (us.hasNext()){
            MealTypeEntity me= ( MealTypeEntity) us.next();
            HBFD.add(me);
        }
        session.close();;
        return HBFD;
        //*******************************/
//
//        Connection cnn=ds.getConnection();
//        PreparedStatement ps=cnn.prepareStatement("SELECT *\n" +
//                "  FROM Meal_type");
//        int count=ss.Show_total("SELECT COUNT(*) FROM Meal_type");
//        ResultSet RS= ps.executeQuery();
//        Memu_M[] MT=new Memu_M [count];
//        int c=0;
//        while(RS.next()){
//            mt=new Memu_M();
//            mt.setMeal_ID(RS.getInt(1));
//            mt.setFood_type(RS.getString(2));
//            MT[c]=mt;
//            c=c+1;
//        }
//        return MT;
    }



    public void update_Food(String[] id, String[] name, String[] price, String[] type) throws SQLException {

//        set_get_memu[] MFC=new Memu_M [id.length];
//        System.out.println("id.length  "+id.length);

//------------------------------------
/**********************************************/
Session session=HibernateUtil.getSessionFactory().openSession();
Transaction tx=session.beginTransaction();
Query query=session.createQuery("UPDATE MemuEntity MET set MET.name=?1,MET.price=?2,MET.mealId=?3 WHERE MET.memuId=?4");
        try {
            for(int i=0;i<id.length;i++){
                query.setParameter(1,name[i]);
                query.setParameter(2,Integer.parseInt(price[i]));
                query.setParameter(3,Integer.parseInt(type[i]));
                query.setParameter(4,Integer.parseInt(id[i]));
                query.executeUpdate();
            }
            tx.commit();
        } catch (NumberFormatException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


/********************************************/

        Connection cnn=ds.getConnection();;
        PreparedStatement ps=cnn.prepareStatement(
                " UPDATE Memu SET Name=?, Price=?, meal_ID=? " +
                        "WHERE memu_ID=?");
        for(int i=0;i<id.length;i++){

            System.out.println(" Integer.parseInt(id[i])  "+ Integer.parseInt(id[i]));
            ps.setInt(4, Integer.parseInt(id[i]));
            ps.setString(1,name[i]);
            ps.setInt(2, Integer.parseInt(price[i]));
            ps.setInt(3, Integer.parseInt(type[i]));
            ps.addBatch();
        }
        ps.executeBatch();
//----------------------------------------


//        for(int i=0;i<id.length;i++){
//            agm=new Memu_M();
//            agm.setMemu_ID(Integer.valueOf(id[i]));
//            agm.setMemu_name(name[i]);
//            agm.setMemu_price(Integer.valueOf(price[i]));
//            agm.setMeal_ID(Integer.valueOf(type[i]));
//            MFC[i]=agm;
//
//        }
//
//        return MFC;

    }
    @Override
    public void Delete(MemuEntity mm) throws SQLException {
        /*//Hibernet*******************************************************/
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();
        try {
            Query query=session.createQuery("delete MemuEntity WHERE memuId=?1");
            query.setParameter(1,mm.getMemuId());
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }

        //***********************************************************/
//        try {
//            Connection cnn=ds.getConnection();
//
//            PreparedStatement ps=cnn.prepareStatement("DELETE FROM Memu WHERE memu_ID=?");
//            ps.setInt(1,(mm.getMemu_ID()));
//            ps.executeQuery();
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }


    }

    @Override
    public void increase_meum(MemuEntity um) throws SQLException {
        //Hibernet****************************/
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();
        try {
            String sql="INSERT INTO Memu (Name,Price,meal_ID) VALUES (?,?,?)";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(1,um.getName());
            query.setParameter(2,um.getPrice());
            query.setParameter(3,um.getMealId());
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();

        } finally {
            session.close();
        }


        //************************/
//        try {
//            Connection cnn = ds.getConnection();
//
//            PreparedStatement ps = cnn.prepareStatement(
//                    "INSERT INTO Memu (Name,Price,meal_ID)\n" +
//                            "VALUES (?,?,?) ");
//            ps.setString(1, um.getMemu_name());
//            ps.setInt(2, um.getMemu_price());
//            ps.setInt(3, um.getMeal_ID());
//            ps.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void increase_type(String type_name) throws SQLException {
        /*****************************/
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();
        try {
            String sql="INSERT INTO Meal_type (Type) VALUES (?)";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(1,type_name);
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }

        /*********************************/


//        try { Connection cnn = ds.getConnection();
//        PreparedStatement ps = cnn.prepareStatement(
//                "INSERT INTO Meal_type (Type)\n" +
//                        "VALUES (?) ");
//        ps.setString(1, type_name);
//        ps.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }
}
