package Model_package;

import HibernateUtilpack.HibernateUtil;
import Interface_package.Discount_inf;
import Test_HIB.DiscountPEntity;
import Interface_package.Show_T;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Discount_A implements Discount_inf {
    @Resource(name = "DataS")
    DataSource ds;
    @Resource(name="Test_show")
    public Show_T ss;
    @Resource(name="Discount_A")
    public Discount_A DA;
    @Override
    public void addnewDis(String Discount_name, String Discount_percent) throws SQLException {
//*****************************************************************//
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();
        try {
            String sql="INSERT INTO DiscountP (Discount_name, Discount_Percent) VALUES (?, ?)";
            SQLQuery query=session.createSQLQuery(sql);
            query.setParameter(1,Discount_name);
            query.setParameter(2,Discount_percent);
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        //***************************************************************//

//        BigDecimal BDiscount_percent = new BigDecimal(Discount_percent);
//        Connection cnn=ds.getConnection();
//        PreparedStatement ps=cnn.prepareStatement("INSERT INTO DiscountP (Discount_name, Discount_Percent)\n" +
//                "VALUES (?, ?);");
//        ps.setString(1, Discount_name);
//        ps.setBigDecimal(2,BDiscount_percent);
//        ps.executeUpdate();

    }




    @Override
    public void DeleteDis(String SeleID) throws SQLException {
        //Hiber*************************//
        Session session=HibernateUtil.getSessionFactory().openSession();
        String sql="DELETE FROM DiscountP WHERE Discount_ID=?";
        Transaction tx= session.beginTransaction();
        try {
            SQLQuery query=session.createSQLQuery(sql);
            query.setParameter(1,Integer.parseInt(SeleID));
            query.executeUpdate();
            tx.commit();
        } catch (NumberFormatException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        //****************************/
//        Connection cnn=ds.getConnection();
//        PreparedStatement ps=cnn.prepareStatement("DELETE FROM DiscountP\n" +
//                "WHERE Discount_ID=?;");
//        ps.setInt(1, Integer.parseInt(SeleID));
//        ps.executeUpdate();



    }

    @Override
    public ArrayList<DiscountPEntity> Show_Delete() throws SQLException {
        //**********************************/
        Session session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from DiscountPEntity");
        Iterator us=query.list().iterator();
        ArrayList<DiscountPEntity> HBALDIS=new ArrayList<DiscountPEntity>();
        while(us.hasNext()){
            HBALDIS.add((DiscountPEntity)us.next());
        }
        return HBALDIS;
        //************************************/
//        Connection cnn=ds.getConnection();
//        int count=ss.Show_total("SELECT COUNT(*) FROM DiscountP");
//        ArrayList<Discount_M> ADM=new ArrayList();
//        PreparedStatement ps=cnn.prepareStatement("SELECT Discount_ID, Discount_name,Discount_Percent\n" +
//                "  FROM DiscountP");
//        ResultSet rs=ps.executeQuery();
////        Discount_M[] DM=new Discount_M[count];
//        int c=0;
//        while(rs.next()){
//            Discount_M dm=new Discount_M();
//            dm.setDisID(rs.getInt(1));
//            dm.setDisname(rs.getString(2));
//            dm.setDispercent(rs.getBigDecimal(3));
////            DM[c]=dm;
////            c=c+1;
//            ADM.add(dm);
//        }
//        return  ADM;
//        return DM;
    }
}
