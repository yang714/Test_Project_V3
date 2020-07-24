package Check_out_model;

import Check_out_interface.Check_out_intf;
import HibernateUtilpack.HibernateUtil;
import Test_HIB.TableKindEntity;
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
import java.util.List;

public class Check_out_Action implements Check_out_intf {
    @Resource(name = "DataS")
    DataSource ds;
    @Resource(name = "Test_show")
    public Show_T ss;
    ///////
    @Resource(name = "Check_A")
    public Check_out_Action CA;
    ///////////

    @Override
    public ArrayList<Checkout_model> show_order(int Table_ID) throws SQLException {
//        String query = String.format("SELECT count(*)\n" +
//                "FROM OrderTable \n" +
//                "where order_number!=0 and food_status=0 and orderTableID=%s",  Table_ID);
//
//        int count=ss.Show_total(query);
//        System.out.println("count" + count);
        //******************************************************//
        Session session= HibernateUtil.getSessionFactory().openSession();
//        String SQL="from OrderTableEntity OTE join MemuEntity ME on OTE.memuId=ME.memuId and OTE.foodStatus=0 and OTE.orderTableId=?1 AND OTE.orderNumber!=0";
//        session.createQuery(SQL);
        String SQL="SELECT Order_ID,who_order,orderTableID,OrderTable.memu_ID,order_number ,Name,Table_Name+ CONVERT(varchar(10), Table_number) as name_number\n" +
                "FROM OrderTable\n" +
                "join Memu \n" +
                "on OrderTable.memu_ID=Memu.memu_ID\n" +
                "and food_status=0 \n" +
                "and orderTableID=?1\n" +
                "and order_number!=0 \n" +
                "join Table_Kind\n" +
                "on Table_ID=orderTableID";

       SQLQuery sqlQuery= session.createSQLQuery(SQL);
       sqlQuery.setParameter(1,Table_ID);
        ArrayList<Checkout_model> ACM = new ArrayList();
       List<Object[]>test= sqlQuery.list();
       for(Object[] i:test){
//           System.out.println(i[1].toString()+"~~~ "+i[2].toString()+"  "+i[3].toString()+"  "+
//                   i[4].toString()+"  "+i[5].toString()+"  "+i[6].toString());
           Checkout_model ccm = new Checkout_model();
           ccm.setOrder_ID((Integer.valueOf(i[0].toString())));
           ccm.setWho_order(Integer.valueOf(i[1].toString()));
           ccm.setOrderTableID(Integer.valueOf(i[2].toString()));
           ccm.setMemu_ID(Integer.valueOf(i[3].toString()));

           ccm.setOrder_number(Integer.valueOf(i[4].toString()));

           ccm.setMemuname((i[5].toString()));
           ccm.setTableidname(i[6].toString());
           ACM.add(ccm);
       }
        //*********************************************************//
//        Connection cnn = ds.getConnection();
//        PreparedStatement ps = cnn.prepareStatement(
//                "SELECT Order_ID,who_order ,orderTableID    ,OrderTable.memu_ID   ,order_number ,Name,Table_Name+ CONVERT(varchar(10), Table_number) as name_number\n" +
//                        "FROM OrderTable\n" +
//                        "join Memu \n" +
//                        "on OrderTable.memu_ID=Memu.memu_ID\n" +
//                        "and food_status=0 \n" +
//                        "and orderTableID=?\n" +
//                        "and order_number!=0 \n" +
//                        "join Table_Kind\n" +
//                        "on Table_ID=orderTableID");
//        ps.setInt(1, Table_ID);
//        ResultSet RS = ps.executeQuery();
////        Checkout_model[] Cm=new Checkout_model[count];
//        //
//        ArrayList<Checkout_model> ACM = new ArrayList();
//        //
//        int c = 0;
//        while (RS.next()) {
//            Checkout_model ccm = new Checkout_model();
//            ccm.setOrder_ID(RS.getInt(1));
//            ccm.setWho_order(RS.getInt(2));
//            ccm.setOrderTableID(RS.getInt(3));
//            ccm.setMemu_ID(RS.getInt(4));
//            ccm.setOrder_number(RS.getInt(5));
//            ccm.setMemuname(RS.getString(6));
//            ccm.setTableidname(RS.getString(7));
////            Cm[c]=ccm;
////            c=c+1;
//            ACM.add(ccm);
//        }


        return ACM;
    }

    @Override
    public String Tableidname(int id) throws SQLException {
        //********************************************//
        Session session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("FROM TableKindEntity TKE where TKE.tableId=?1");
        query.setParameter(1,id);
        Iterator test=query.list().iterator();
        String a = null;
        while (test.hasNext()){
            TableKindEntity TKE=(TableKindEntity)test.next();
            a=TKE.getTableName()+TKE.getTableNumber();
            System.out.println("A--->"+a);
        }
        //*********************************************//
//        Connection cnn = ds.getConnection();
//        PreparedStatement ps = cnn.prepareStatement("SELECT Table_Name+ CONVERT(varchar(10), Table_number) as name_number" +
//                "  FROM Table_Kind" +
//                "  where Table_ID=?");
//        ps.setInt(1, id);
//        ResultSet RS = ps.executeQuery();
//        String a = null;
//        while (RS.next()) {
//            a = RS.getString(1);
//        }
session.close();
        return a;
    }

    ////////
    @Override
    public ArrayList<String> processIDOnumber(String[] IDOnumber) {
        ArrayList<String> save_id = new ArrayList();
        System.out.println("!!!  " + IDOnumber);
        for (String aa : IDOnumber) {
            System.out.println(aa);
            String[] tokens = aa.split(",");
            System.out.println(tokens[0] + "  <>  " + tokens[1]);//ID ,order number
            save_id.add(tokens[0]);
        }
        return save_id;
    }

    @Override
    public ArrayList<String> processORDER_NUMBER(String[] ORDER_NUMBER) {
        System.out.println("-------------------");//依序
        ArrayList<String> save_ordernymber = new ArrayList<String>();
        for (String on : ORDER_NUMBER) {
            System.out.println(on);
            if (on != "") {
                save_ordernymber.add(on);
            }
        }
        return save_ordernymber;

    }

    /////////////
    public void UpdateOrder(String[] IDOnumber, String[] ORDER_NUMBER) throws SQLException {
        System.out.println("-----JOJO");
        Connection cnn = ds.getConnection();
        for (String aa : IDOnumber) {
            System.out.println(aa);
            String[] tokens = aa.split(",");
            System.out.println(tokens[0] + "  <>  " + tokens[1]);//ID ,order number

        }
        /////

//        ArrayList<String> save= new ArrayList<String>();
        /////

        ArrayList<String> save_ordernymber = CA.processORDER_NUMBER(ORDER_NUMBER);

        ArrayList<String> save_id = CA.processIDOnumber(IDOnumber);
//        System.out.println("-------------------");//依序
//        for(String on:ORDER_NUMBER){
//            System.out.println(on);
//            if(on!=""){
//                save.add(on)  ;
//            }
//        }
//        System.out.println("<------------------>");
//        System.out.println(save.get(0)+"----"+save.get(1));
//*******************************************************************//
        Session session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("UPDATE OrderTableEntity OTE SET OTE.orderNumber=?1 ,OTE.foodStatus=?2 WHERE OTE.orderId=?3");
        ArrayList<Integer> deletee = new ArrayList();
        Transaction tx= session.beginTransaction();
        try {
            int c = 0;
            int resorder = 0;
            for (String aa : IDOnumber) {
                String[] tokens = aa.split(",");
                resorder = Integer.valueOf(tokens[1]) - Integer.valueOf(save_ordernymber.get(c));
                if (resorder == 0) {
                    query.setParameter(2,1);
                    deletee.add(Integer.valueOf(tokens[0]));
                } else {
                    query.setParameter(2,0);
                }
                query.setParameter(1,resorder) ;
                query.setParameter(3,Integer.valueOf(tokens[0]));
                c=c+1;
                query.executeUpdate();
            }
            tx.commit();
        } catch (NumberFormatException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        CA.Delete_zero(deletee);

        //************************************************************//
//        PreparedStatement ps = cnn.prepareStatement("UPDATE OrderTable SET order_number=?, food_status=? WHERE Order_ID=?;");
//        int c = 0;
//        int resorder = 0;
////        ArrayList<String> save_id=new ArrayList();
//        ArrayList<Integer> delete = new ArrayList();
//        for (String aa : IDOnumber) {
//
//            String[] tokens = aa.split(",");
//            System.out.println(tokens[0] + "  <>  " + tokens[1]);//ID ,order number
//            resorder = Integer.valueOf(tokens[1]) - Integer.valueOf(save_ordernymber.get(c));
//            if (resorder == 0) {
//                ps.setInt(2, 1);
//                delete.add(Integer.valueOf(tokens[0]));
//            } else {
//                ps.setInt(2, 0);
//            }
//            ps.setInt(1, resorder);
//            ps.setInt(3, Integer.valueOf(tokens[0]));
//            ps.addBatch();
//            c = c + 1;
////            save_id.add(tokens[0]);
//
//        }
//        ps.executeBatch();
//        for(Integer I:delete){
//            System.out.println("need to delete I is "+I);
//
//        }
//        CA.Delete_zero(delete);

        ////

//        Checkout_model[] CHM= CA.FOODNAME_CHECK(save_id,save_ordernymber);
//        return CHM;
//       for(int i=0;i<c;i++){
//      cmm=new Checkout_model();
//           cmm.set
//       }

        //////
    }

    @Override
    public Checkout_model[] FOODNAME_CHECK(String[] IDOnumber, String[] ORDER_NUMBER) throws SQLException {
        ArrayList<String> save_ordernymber = CA.processORDER_NUMBER(ORDER_NUMBER);
        for (String i : save_ordernymber) {
            System.out.println(" save_ordernymber " + i);
        }
        ArrayList<String> save_id = CA.processIDOnumber(IDOnumber);
        for (String i : save_id) {
            System.out.println(" save_id " + i);
        }
        System.out.println("save_id size" + save_id.size());
        Connection cnn = ds.getConnection();
        Checkout_model[] CHM = new Checkout_model[save_id.size()];
        int c = 0;
        for (int i = 0; i < save_id.size(); i++) {
            PreparedStatement ps = cnn.prepareStatement("SELECT \n" +
                    "Order_ID\n" +
                    "      ,who_order\n" +
                    "      ,orderTableID\n" +
                    "      ,OrderTable.memu_ID\n" +
                    "      ,order_number\n" +
                    "      ,food_status\n" +
                    "  ,Name\n" +
                    "  ,Price\n" +
                    "  ,OrderTable.memu_ID\n" +
                    "  FROM OrderTable\n" +
                    "  join Memu on OrderTable.memu_ID=Memu.memu_ID\n" +
                    "  where Order_ID=?");

            ps.setInt(1, Integer.parseInt(save_id.get(i)));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Checkout_model chm = new Checkout_model();
                chm.setOrder_ID(rs.getInt(1));
                chm.setWho_order(rs.getInt(2));
                chm.setOrderTableID(rs.getInt(3));
                chm.setMemu_ID(rs.getInt(4));
                chm.setOrder_number(rs.getInt(5));
                chm.setChecknumber(Integer.valueOf(save_ordernymber.get(c)));//check_number
                chm.setMemuname(rs.getString(7));
                chm.setPrice(rs.getInt(8) * Integer.valueOf(save_ordernymber.get(c)));//prive total
                chm.setMemu_ID(rs.getInt(9));
                CHM[c] = chm;
                c = c + 1;


            }
        }
//        ResultSet rs= ps.executeBatch();
//        Checkout_model[] CHM= new Checkout_model[ save_id.size()];
//        int c=0;
//        for(int x: rs){
//            System.out.println("x"+x);
//        }

//        while (rs.next()){
//            Checkout_model chm=new Checkout_model();
//            chm.setOrder_ID(rs.getInt(1));
//            chm.setWho_order(rs.getInt(2));
//            chm.setOrderTableID(rs.getInt(3));
//            chm.setMemu_ID(rs.getInt(4));
//            chm.setChecknumber( Integer.valueOf(save_ordernymber.get(c)));//check_number
//            chm.setMemuname(rs.getString(7));
//            chm.setPrice(rs.getInt(8)*Integer.valueOf( save_ordernymber.get(c)));
//            CHM[c]=chm;
//            c=c+1;
//
//
//        }
        System.out.println("CHM.length" + CHM.length);
        for (int h = 0; h < CHM.length; h++) {
            System.out.println("iooo.getOrder_ID() " + CHM[h].getOrder_ID() + " ioooo.getMemuname() " +
                    CHM[h].getMemuname() + "  iooo.getChecknumber()  " + CHM[h].getChecknumber() + "  iooo.getPrice() " + CHM[h].getPrice() + " memuid" + CHM[h].getMemu_ID());//剩下的
        }
//        for(Checkout_model i:CHM){
//            System.out.println("i.getOrder_ID() "+i.getOrder_ID()+" i.getMemuname() "+
//                    i.getMemuname()+"  i.getChecknumber()  "+i.getChecknumber()+"  i.getPrice() "+i.getPrice());//剩下的
//        }
        return CHM;
    }

    @Override
    public void Update2table(Checkout_model[] AFCM, int who_check) throws SQLException {
        //***************************************//
        
        //**************************************//
        Connection cnn = ds.getConnection();
        PreparedStatement ps = cnn.prepareStatement(
                "INSERT INTO Check_out  (Order_ID,who_order ,who_check," +
                        "memu_ID,check_number,Dis_P,OriginPrice,DiscountPrice) VALUES(?,?,?,?,?,?,?,?)");
        for (int i = 0; i < AFCM.length; i++) {
            ps.setInt(1, AFCM[i].getOrder_ID());
            ps.setInt(2, AFCM[i].getWho_order());
            ps.setInt(3, who_check);
            ps.setInt(4, AFCM[i].getMemu_ID());
            ps.setInt(5, AFCM[i].getChecknumber());
            ps.setBigDecimal(6, AFCM[i].getDiscountP());
            ps.setInt(7, AFCM[i].getPrice());
            ps.setInt(8, AFCM[i].getDprice());
            ps.addBatch();
        }
        ps.executeBatch();
        System.out.println("<-------------------Update2table----------->");
    }

    @Override
    public void Delete_zero(ArrayList<Integer> delete) throws SQLException {
        //*****************************************//
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        Query query=session.createQuery("DELETE FROM OrderTableEntity  OTE WHERE  OTE.orderId=?1");
        try {
            for (int i = 0; i < delete.size(); i++) {
                query.setParameter(1,delete.get(i));
                query.executeUpdate();
            }
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        //******************************************//
//        Connection cnn = ds.getConnection();
//        PreparedStatement ps = cnn.prepareStatement("DELETE FROM OrderTable WHERE  Order_ID=?");
//        for (int i = 0; i < delete.size(); i++) {
//            ps.setInt(1, delete.get(i));
//            ps.addBatch();
//        }
//        ps.executeBatch();

    }
}
