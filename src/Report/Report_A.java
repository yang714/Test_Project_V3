package Report;

import Check_out_model.Checkout_model;
import Test_show_total.Show_T;
import java.text.ParseException;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Report_A implements Report_I{
    @Resource(name="DataS")
    DataSource ds;
    @Resource(name="Test_show")
    public Show_T ss;
    @Override
    public Checkout_model Report(Date D1, Date D2) throws SQLException {
        Connection cnn=ds.getConnection();
        String query="SELECT count(*) \n" +
                "FROM Check_out\n" +
                "where Check_Date between "+D1+"and "+D2;
        PreparedStatement ps=cnn.prepareStatement("select Check_ID\n" +
                "      ,Order_ID\n" +
                "      ,who_order\n" +
                "      ,who_check\n" +
                "      ,memu_ID\n" +
                "      ,check_number\n" +
                "      ,OriginPrice\n" +
                "      ,Check_Date from Check_out \n" +
                "        where Check_Date between ? and ?");
        ps.setDate(1, (java.sql.Date) D1);
        ps.setDate(2, (java.sql.Date) D2);
        ResultSet rs=ps.executeQuery();
        int count=ss.Show_total(query);
        System.out.println("count----> "+count);
        Checkout_model[] Cm=new Checkout_model[count];
        int c=0;
        while(rs.next()){
//            Checkout_model
        }
        return null;
    }

    @Override
    public ArrayList<Report_Model> ReportV2(String D1, String D2) throws SQLException, ParseException {
        Connection cnn=ds.getConnection();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed1 = format.parse(D1);
        Date parsed2 = format.parse(D2);
        java.sql.Date sqld1 = new java.sql.Date(parsed1.getTime());
        java.sql.Date sqld2 = new java.sql.Date(parsed2.getTime());
        System.out.println(sqld1+" --->"+sqld2);
        //////////////////////////////////////////
//        String query = String.format("SELECT  COUNT(DISTINCT Check_Date)\n" +
//                        "FROM Check_out\n" +
//                        "where Check_Date between %s and %s" , sqld1,sqld2);
//        PreparedStatement ps_s=cnn.prepareStatement(
//                "SELECT  COUNT(DISTINCT Check_Date)\n" +
//                        "FROM Check_out\n" +
//                        "where Check_Date between ? and ?" );
//        ps_s.setDate(1,sqld1);
//        ps_s.setDate(2,sqld2);
//        ResultSet RS_count= ps_s.executeQuery();
//        RS_count.next();
//        int count=RS_count.getInt(1);
        //select number------------------------------------

        ///////////////////////////////////////////////
        PreparedStatement ps=cnn.prepareStatement(
                "SELECT Check_Date \n" +
                ",sum([OriginPrice])\n" +
                ",sum([DiscountPrice])\t\n" +
                "FROM Check_out\n" +
                "where Check_Date between ? and ? \n" +
                "group by Check_Date");

        ps.setDate(1, java.sql.Date.valueOf(D1));
        ps.setDate(2, java.sql.Date.valueOf(D2));
        ResultSet rs=ps.executeQuery();
//        Report_Model[] RM=new Report_Model[count];
        ArrayList<Report_Model> ARM=new ArrayList();
//        int c=0;
        while(rs.next()){
            System.out.println("rs.getDate(1)"+rs.getDate(1));
            Report_Model rm=new Report_Model();
//            rm.setDD(rs.getDate(1));
            rm.setDATE(rs.getDate(1).toString());
            rm.setOriginincome(rs.getInt(2));
            rm.setIncome(rs.getInt(3));
//            RM[c]=rm;
//            c=c+1;
            ARM.add(rm);
        }
        for(Report_Model i:ARM){
            System.out.println("Date "+i.getDD()+"  origin "+i.getOriginincome()+"  real "+i.getIncome());
        }
        rs.close();
        ps.close();
        cnn.close();
        return ARM;
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


                     SEL="SELECT YEAR(Check_Date)\n" +
                             ",sum([OriginPrice])\n" +
                             ",sum([DiscountPrice])" +
                             "FROM Check_out\n" +
                             "group by YEAR(Check_Date)";
        }
        else{
//
//            CQ="SELECT  COUNT(*) OVER () AS TotalRecords\n" +
//                    "FROM Check_out\n" +
//                    "group by YEAR( Check_Date), MONTH( Check_Date)" ;

            SEL="SELECT CAST(YEAR(Check_Date) AS VARCHAR(10))+'-'+CAST(MONTH(Check_Date) AS VARCHAR(10)) as ym\n" +
                            ",sum([OriginPrice])\n" +
                            ",sum(DiscountPrice)\n" +
                            "FROM Check_out\n" +
                            "group by MONTH(Check_Date),YEAR(Check_Date)";
        }
//        PreparedStatement ps_s=cnn.prepareStatement(CQ);
//        ResultSet RS= ps_s.executeQuery();
//        int count=0;
//        while(RS.next()){
//            count=RS.getInt(1);
//        }
//        Report_Model[] RMM=new Report_Model[count];

        ArrayList<Report_Model> ARM=new ArrayList();

        PreparedStatement ps=cnn.prepareStatement(SEL);
        ResultSet RSS= ps.executeQuery();
//        int c=0;
        while (RSS.next()){
            Report_Model rmm=new Report_Model();

            rmm.setDATE(RSS.getString(1));
            rmm.setIncome(RSS.getInt(3));
//            RMM[c]=rmm;
//            c=c+1;
            ARM.add(rmm);
        }
//        for(Report_Model I:RMM){
//            System.out.println("ym"+I.getDATE()+" incom"+I.getIncome());
//        }
        for(Report_Model I:ARM){
            System.out.println("ym"+I.getDATE()+" incom"+I.getIncome());
        }
        return ARM;
    }
}
