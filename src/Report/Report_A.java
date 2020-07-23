package Report;

import Check_out_model.Checkout_model;
import HibernateUtilpack.HibernateUtil;
import Test_HIB.CheckOutEntity;
//import  Test_check.CheckOutEntity;
import Test_show_total.Show_T;
import org.hibernate.*;

import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.*;


public class Report_A implements Report_I{

    @Resource(name="DataS")
    DataSource ds;
    @Resource(name="Test_show")
    public Show_T ss;
//    @Override
//    public Checkout_model Report(Date D1, Date D2) throws SQLException {
//        Connection cnn=ds.getConnection();
//        String query="SELECT count(*) \n" +
//                "FROM Check_out\n" +
//                "where Check_Date between "+D1+"and "+D2;
//        PreparedStatement ps=cnn.prepareStatement("select Check_ID\n" +
//                "      ,Order_ID\n" +
//                "      ,who_order\n" +
//                "      ,who_check\n" +
//                "      ,memu_ID\n" +
//                "      ,check_number\n" +
//                "      ,OriginPrice\n" +
//                "      ,Check_Date from Check_out \n" +
//                "        where Check_Date between ? and ?");
//        ps.setDate(1, (java.sql.Date) D1);
//        ps.setDate(2, (java.sql.Date) D2);
//        ResultSet rs=ps.executeQuery();
//        int count=ss.Show_total(query);
//        System.out.println("count----> "+count);
//        Checkout_model[] Cm=new Checkout_model[count];
//        int c=0;
//        while(rs.next()){
////            Checkout_model
//        }
//        return null;
//    }

    @Override
    public ArrayList<Report_Model> ReportV2(String D1, String D2) throws SQLException, ParseException {
        String DD1=D1;
        String DD2=D2;
        //Hibernet******************************************//
        Session session=HibernateUtil.getSessionFactory().openSession();
//        Transaction tx= session.beginTransaction();
//        String SQL="SELECT Check_Date as checkDate \n" +
//                ",sum([OriginPrice]) as originPrice\n" +
//                ",sum([DiscountPrice]) as discountPrice\t\n" +
//                "FROM Check_out\n" +
//                "where Check_Date between ? and ? \n" +
//                "group by Check_Date" ;
////        SQLQuery query=session.createSQLQuery(SQL);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Query query=session.createQuery("SELECT COE.checkDate ,sum(COE.originPrice),sum(COE.discountPrice) FROM CheckOutEntity COE where COE.checkDate between ?1 and ?2 group by COE.checkDate");
        query.setParameter(1,java.sql.Date.valueOf(D1));
        query.setParameter(2,java.sql.Date.valueOf(D2));
//        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        Iterator test=query.list().iterator();
        System.out.println("list test"+test);
        ArrayList<Report_Model> ARMM=new ArrayList();
    while(test.hasNext()){
        Object[] obj = (Object[]) test.next();
//        System.out.println(obj[0]+"  "+obj[1]);
        Report_Model rm=new Report_Model();
        rm.setDATE(obj[0].toString());
        rm.setOriginincome( Integer.valueOf(obj[1].toString()));
        rm.setIncome( Integer.valueOf(obj[2].toString()));
        ARMM.add(rm);
//        CheckOutEntity CE=(CheckOutEntity)test.next();
//        System.out.println(CE.getCheckDate());
    }
//        for(Object object : test){
//            Map row = (Map) object;
//            System.out.println("check date"+row.get("checkDate")+"  sumO "+row.get("originPrice")+" DISO "+row.get("discountPrice"));
//            Report_Model rm=new Report_Model();
//            rm.setDATE(row.get("checkDate").toString());
//            rm.setOriginincome((Integer) row.get("originPrice"));
//            rm.setIncome((Integer) row.get("discountPrice"));
////            RM[c]=rm;
////            c=c+1;
//            ARMM.add(rm);
//        }
        return ARMM;
        //******************************************//


//
//        Connection cnn=ds.getConnection();
////        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
////        Date parsed1 =  format.parse(D1);
////        Date parsed2 =  format.parse(D2);
////        java.sql.Date sqld1 = new java.sql.Date(parsed1.getTime());
////        java.sql.Date sqld2 = new java.sql.Date(parsed2.getTime());
////        System.out.println(sqld1+" --->"+sqld2);
//        //////////////////////////////////////////
////        String query = String.format("SELECT  COUNT(DISTINCT Check_Date)\n" +
////                        "FROM Check_out\n" +
////                        "where Check_Date between %s and %s" , sqld1,sqld2);
////        PreparedStatement ps_s=cnn.prepareStatement(
////                "SELECT  COUNT(DISTINCT Check_Date)\n" +
////                        "FROM Check_out\n" +
////                        "where Check_Date between ? and ?" );
////        ps_s.setDate(1,sqld1);
////        ps_s.setDate(2,sqld2);
////        ResultSet RS_count= ps_s.executeQuery();
////        RS_count.next();
////        int count=RS_count.getInt(1);
////        select number------------------------------------
//
//        /////////////////////////////////////////////
//        PreparedStatement ps=cnn.prepareStatement(
//                "SELECT Check_Date \n" +
//                ",sum([OriginPrice])\n" +
//                ",sum([DiscountPrice])\t\n" +
//                "FROM Check_out\n" +
//                "where Check_Date between ? and ? \n" +
//                "group by Check_Date");
//
//        ps.setDate(1, java.sql.Date.valueOf(D1));
//        ps.setDate(2, java.sql.Date.valueOf(D2));
//        ResultSet rs=ps.executeQuery();
////        Report_Model[] RM=new Report_Model[count];
//        ArrayList<Report_Model> ARM=new ArrayList();
////        int c=0;
//        while(rs.next()){
//            System.out.println("rs.getDate(1)"+rs.getDate(1));
//            Report_Model rm=new Report_Model();
////            rm.setDD(rs.getDate(1));
//            rm.setDATE(rs.getDate(1).toString());
//            rm.setOriginincome(rs.getInt(2));
//            rm.setIncome(rs.getInt(3));
////            RM[c]=rm;
////            c=c+1;
//            ARM.add(rm);
//        }
//        for(Report_Model i:ARM){
//            System.out.println("Date "+i.getDD()+"  origin "+i.getOriginincome()+"  real "+i.getIncome());
//        }
//        rs.close();
//        ps.close();
//        cnn.close();
//        return ARM;
    }

    @Override
    public ArrayList<Report_Model> ReportV3(String MorY) throws SQLException {
        Connection cnn=ds.getConnection();
        String CQ="";
        String SEL="";
        if(MorY.equals("Y")){

//                     CQ="SELECT  COUNT(*) OVER () AS TotalRecords\n" +
//                            "FROM Check_out\n" +
//                            "group by YEAR( Check_Date)" ;
SEL="SELECT YEAR(COE.checkDate),sum(COE.originPrice),sum(COE.discountPrice) FROM CheckOutEntity COE group by YEAR(COE.checkDate)";

//                     SEL="SELECT YEAR(Check_Date)\n" +
//                             ",sum([OriginPrice])\n" +
//                             ",sum([DiscountPrice])" +
//                             "FROM Check_out\n" +
//                             "group by YEAR(Check_Date)";


        }
        else{
//
//            CQ="SELECT  COUNT(*) OVER () AS TotalRecords\n" +
//                    "FROM Check_out\n" +
//                    "group by YEAR( Check_Date), MONTH( Check_Date)" ;
SEL="SELECT YEAR(COE.checkDate),Month(COE.checkDate),sum(COE.originPrice),sum(COE.discountPrice) FROM CheckOutEntity COE group by MONTH (COE.checkDate),YEAR(COE.checkDate)";
//            SEL="SELECT CAST(YEAR(Check_Date) AS VARCHAR(10))+'-'+CAST(MONTH(Check_Date) AS VARCHAR(10)) as ym\n" +
//                            ",sum([OriginPrice])\n" +
//                            ",sum(DiscountPrice)\n" +
//                            "FROM Check_out\n" +
//                            "group by MONTH(Check_Date),YEAR(Check_Date)";
        }
        //Hibernet***************************************************//
        ArrayList<Report_Model> ARM=new ArrayList();
        Session session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery(SEL);
        Iterator test=query.list().iterator();
        while (test.hasNext()){
            Object[] obj=(Object[]) test.next();
            Report_Model rm=new Report_Model();
            if(MorY.equals("Y")){
                rm.setDATE(obj[0].toString());
                rm.setOriginincome( Integer.valueOf(obj[1].toString()));
                rm.setIncome( Integer.valueOf(obj[2].toString()));
            }else{
                rm.setDATE(obj[0].toString()+'-'+obj[1].toString());
                rm.setOriginincome( Integer.valueOf(obj[2].toString()));
                rm.setIncome( Integer.valueOf(obj[3].toString()));
            }
//            rm.setDATE(obj[0].toString()+'-'+obj[1].toString());

            ARM.add(rm);

        }
        //*****************************************************//
//        PreparedStatement ps_s=cnn.prepareStatement(CQ);
//        ResultSet RS= ps_s.executeQuery();
//        int count=0;
//        while(RS.next()){
//            count=RS.getInt(1);
//        }
//        Report_Model[] RMM=new Report_Model[count];

//        ArrayList<Report_Model> ARM=new ArrayList();
//
//        PreparedStatement ps=cnn.prepareStatement(SEL);
//        ResultSet RSS= ps.executeQuery();
////        int c=0;
//        while (RSS.next()){
//            Report_Model rmm=new Report_Model();
//
//            rmm.setDATE(RSS.getString(1));
//            rmm.setIncome(RSS.getInt(3));
////            RMM[c]=rmm;
////            c=c+1;
//            ARM.add(rmm);
//        }
////        for(Report_Model I:RMM){
////            System.out.println("ym"+I.getDATE()+" incom"+I.getIncome());
////        }
//        for(Report_Model I:ARM){
//            System.out.println("ym"+I.getDATE()+" incom"+I.getIncome());
//        }
        return ARM;
    }
}
