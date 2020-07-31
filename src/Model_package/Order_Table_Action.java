package Model_package;

import HibernateUtilpack.HibernateUtil;
import Interface_package.Order_Table_Interface;
import Test_HIB.MemuEntity;
import Test_HIB.TableKindEntity;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.annotation.Resource;
//import javax.management.Query;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Order_Table_Action implements Order_Table_Interface {
    @Resource(name = "DataS")
    DataSource ds;
    @Resource(name="HIBMemu_M")
    public MemuEntity mm;
    @Override
    public ArrayList<MemuEntity> Save_Order(String[] sid, String[] sanme, String[] snumber) throws SQLException {
//        Memu_M[] MM=new Memu_M[sid.length];
        ArrayList<MemuEntity> HARRME=new ArrayList();
        for(int i=0;i<sid.length;i++){
            mm=new MemuEntity();
//            mm.setMemu_ID(Integer.valueOf(sid[i]));
//            mm.setMemu_name(sanme[i]);
//            mm.setOrder_meal_number(Integer.valueOf(snumber[i]));
//            MM[i]=mm;
            mm.setMemuId(Integer.valueOf(sid[i]));
            mm.setName(sanme[i]);
            mm.setOrder_meal_number(Integer.valueOf(snumber[i]));
            HARRME.add(mm);
        }

        return HARRME;
    }

    @Override
    public int FindTable_ID(String tablename, String tablenumber) throws SQLException {
        /*************************************/
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        int t_id= 0;
        try {
            Query query= session.createQuery("select TKE from TableKindEntity AS TKE where TKE.tableName=?1 and TKE.tableNumber=?2");
            query.setParameter(1,tablename);
            query.setParameter(2,Integer.valueOf(tablenumber));
//        Query query2= session.createQuery("select TKE from TableKindEntity as TKE" );
            t_id = 0;
            Iterator test=query.list().iterator();
            while(test.hasNext()){
                TableKindEntity jojo=  (TableKindEntity)test.next();
    //            System.out.println(jojo.getTableId());
                t_id=jojo.getTableId();
            }
            tx.commit();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            tx.rollback();
        }finally {
            session.close();
        }

//        Iterator us=query.list().iterator();

//        t_id=((TableKindEntity)query).getTableId();
        return t_id;
        /*************************************/
//        Connection cnn=ds.getConnection();
//        PreparedStatement ps=cnn.prepareStatement(
//                "SELECT  Table_ID\n" +
//                        " \n" +
//                        "  FROM Table_Kind\n" +
//                        "  where Table_Name=? and Table_number=?");
//        ps.setString(1, tablename);
//        ps.setInt(2, Integer.parseInt(tablenumber));
//        ResultSet rs=ps.executeQuery();
//        int t_id=0;
//        while(rs.next()){
//            t_id=rs.getInt(1);
//        }
//        return t_id;
    }

    @Override
    public void SaveOrder2DataB(Object user_id,int t_id, ArrayList<MemuEntity> MO) throws SQLException {
        //Hibernet*JDBC Batch***********************************//
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();
        try {
            SQLQuery query=session.createSQLQuery("INSERT INTO OrderTable (who_order,orderTableID," +
                    "memu_ID,order_number,food_status)\n" +
                    "VALUES (?,?,?,?,?) ");
            for(int i=0;i<MO.size();i++){
                query.setParameter(1,Integer.valueOf((Integer) user_id));
                query.setParameter(2,t_id);
                query.setParameter(3, MO.get(i).getMemuId());
                query.setParameter(4,MO.get(i).getOrder_meal_number());
                query.setParameter(5,0);
                query.executeUpdate();

            }
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }

        /***********************************************************/
//        Connection cnn=ds.getConnection();
//        String sql=("INSERT INTO OrderTable (who_order,orderTableID," +
//                "memu_ID,order_number,food_status)\n" +
//                "VALUES (?,?,?,?,?) ");
//        PreparedStatement ps=cnn.prepareStatement(sql);
//        for(int i=0;i<MO.size();i++){
//
////            System.out.println(" Integer.parseInt(id[i])  "+ Integer.parseInt(id[i]));
//            ps.setInt(1, (Integer) user_id);
//            ps.setString(2, String.valueOf(t_id));
//            ps.setInt(3, MO.get(i).getMemuId());
//            ps.setInt(4, MO.get(i).getOrder_meal_number());
//            ps.setInt(5, 0);
//            ps.addBatch();
//        }
//
//        ps.executeBatch();
//        cnn.close();
        //*************************************//

//        Connection cnn=ds.getConnection();
//        PreparedStatement ps=cnn.prepareStatement("INSERT INTO OrderTable (who_order,orderTableID," +
//                "memu_ID,order_number,food_status)\n" +
//                "VALUES (?,?,?,?,?) ");
//
//        System.out.println( user_id);
//        for(MemuEntity i:MO){
//
////            System.out.println(" Integer.parseInt(id[i])  "+ Integer.parseInt(id[i]));
//            ps.setInt(1, (Integer) user_id);
//            ps.setString(2, String.valueOf(t_id));
//            ps.setInt(3,(MO[i].getMemu_ID()));
//            ps.setInt(4, (MO[i].getOrder_meal_number()));
//            ps.setInt(5, 0);
//            ps.addBatch();
//        }
//        ps.executeBatch();
////        return new Memu_M[0];
    }

}
