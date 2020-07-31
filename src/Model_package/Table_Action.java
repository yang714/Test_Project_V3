package Model_package;

import HibernateUtilpack.HibernateUtil;
import Model_package.Memu_Action;
import Table_Model.Table_model;
import Test_HIB.MemuEntity;
import Test_HIB.TableKindEntity;
import Interface_package.Show_T;
import Interface_package.order_inf;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Table_Action implements order_inf {
    @Resource(name = "DataS")
    DataSource ds;
    @Resource(name="Test_show")
    public Show_T ss;
    @Resource(name="Memu_A")
    public Memu_Action MA;

    @Override
    public ArrayList<TableKindEntity> Table_name() throws SQLException {//abc
        /*******************************/
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("SELECT distinct(tableName) from TableKindEntity");
        Iterator us=query.list().iterator();
        ArrayList<TableKindEntity> ATK=new  ArrayList();
        while(us.hasNext()){
//            System.out.println(us.next());
            TableKindEntity tk=new  TableKindEntity();
            tk.setTableName((String) us.next());
            ATK.add(tk);
        }
        return ATK;
        /*********************************/
//        Connection cnn=ds.getConnection();
//        String sql="SELECT distinct [Table_Name]\n" +
//                "\n" +
//                "  FROM [Test_DataBase].[dbo].[Table_Kind]";
//        PreparedStatement ps=cnn.prepareStatement(
//                sql);
////
//        ResultSet RS= ps.executeQuery();
//      int count=ss.Show_total("SELECT count(distinct([Table_Name]))\n" +
//              "\n" +
//              "  FROM [Test_DataBase].[dbo].[Table_Kind]");
//      System.out.println("count  "+count);
//      int c=0;
//       Table_model[] TMM= new Table_model[count];
//        while(RS.next()){
//            TM= new Table_model();
//            TM.setTable_name(RS.getString(1));
//            TMM[c]=TM;
//            c=c+1;
//        }
//return TMM;
    }

    @Override
    public ArrayList<TableKindEntity> Table_number(String Table_name) throws SQLException {
        /****************************/
        Session session =HibernateUtil.getSessionFactory().openSession();

        Query query=session.createQuery("from TableKindEntity TKE where TKE.tableName=?1");
        query.setParameter(1,Table_name);
        Iterator us=query.list().iterator();
        ArrayList<TableKindEntity>ALT=new ArrayList<TableKindEntity>();
        while (us.hasNext()){
            TableKindEntity HTK=(TableKindEntity)us.next();
            ALT.add(HTK);
        }
        return ALT;
        /******************************/
//        Connection cnn=ds.getConnection();
//        PreparedStatement ps=cnn.prepareStatement(
//                "SELECT [Table_ID]\n" +
//                        "      ,[Table_Name]\n" +
//                        "      ,[Table_number]\n" +
//                        "  FROM [Test_DataBase].[dbo].[Table_Kind]\n" +
//                        "  where Table_Name=?");
//        ps.setString(1,Table_name);
//        ResultSet rs=ps.executeQuery();
//
//        String query = String.format("SELECT count(*) FROM Table_Kind" +
//                " where Table_Name='%s'", Table_name);
//        int count=ss.Show_total(query);
//        Table_model[] TMM=new Table_model[count];
//        int c=0;
//        while (rs.next()){
//            TM=new Table_model();
//            TM.setTable_ID(rs.getInt(1));
//            TM.setTable_name(rs.getString(2));
//            TM.setTable_number(rs.getInt(3));
//            TMM[c]=TM;
//            c=c+1;
//
//        }
//        return TMM;
    }
    public ArrayList<MemuEntity> call_Memu(MemuEntity mem) throws SQLException {

//        Memu_M[] show_model= MA.Show_memu(mem);
        ArrayList<MemuEntity> show_model=MA.Show_memu(mem);
        return show_model;
    }

    @Override
    public ArrayList<TableKindEntity> Table_namenumber(Table_model TM) throws SQLException {//all table_name
        /************************************************/
        Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        ArrayList<TableKindEntity> ALT= null;
        try {
            Query query=session.createQuery("from TableKindEntity");
            Iterator us=query.list().iterator();
            ALT = new ArrayList<>();
            while (us.hasNext()){
                TableKindEntity TKE=(TableKindEntity)us.next();
                TKE.setTablename_number(TKE.getTableName()+TKE.getTableNumber());
                ALT.add(TKE);
            }
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return  ALT;
        /************************************************/


//        Connection cnn=ds.getConnection();
//
//        int count=ss.Show_total("SELECT count(*)\n" +
//                "  FROM [Test_DataBase].[dbo].[Table_Kind]");
//        PreparedStatement ps=cnn.prepareStatement(
//                "SELECT [Table_ID]\n" +
//                        "      ,[Table_Name]\n" +
//                        "      ,[Table_number]\n" +
//                        "\t  ,Table_Name+ CONVERT(varchar(10), Table_number) as name_number\n" +
//                        "  FROM [Test_DataBase].[dbo].[Table_Kind]");
//        Table_model[] TNN=new Table_model[count];
//        ResultSet rs=ps.executeQuery();
//        int c=0;
//        while(rs.next()){
//            TM=new Table_model();
//            TM.setTable_ID(rs.getInt(1));
//            TM.setTablenamenumber(rs.getString(4));
//            TNN[c]=TM;
//            c=c+1;
//        }
//
//        return TNN;
    }


}
