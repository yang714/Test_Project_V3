package Discount;

import Test_show_total.Show_T;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Discount_A implements Discount_inf{
    @Resource(name = "DataS")
    DataSource ds;
    @Resource(name="Test_show")
    public Show_T ss;
    @Resource(name="Discount_A")
    public Discount_A DA;
    @Override
    public void addnewDis(String Discount_name, String Discount_percent) throws SQLException {


        BigDecimal BDiscount_percent = new BigDecimal(Discount_percent);
        Connection cnn=ds.getConnection();
        PreparedStatement ps=cnn.prepareStatement("INSERT INTO DiscountP (Discount_name, Discount_Percent)\n" +
                "VALUES (?, ?);");
        ps.setString(1, Discount_name);
        ps.setBigDecimal(2,BDiscount_percent);
        ps.executeUpdate();

    }




    @Override
    public void DeleteDis(String SeleID) throws SQLException {
        Connection cnn=ds.getConnection();
        PreparedStatement ps=cnn.prepareStatement("DELETE FROM DiscountP\n" +
                "WHERE Discount_ID=?;");
        ps.setInt(1, Integer.parseInt(SeleID));
        ps.executeUpdate();



    }

    @Override
    public ArrayList<Discount_M> Show_Delete() throws SQLException {
        Connection cnn=ds.getConnection();
        int count=ss.Show_total("SELECT COUNT(*) FROM DiscountP");
        ArrayList<Discount_M> ADM=new ArrayList();
        PreparedStatement ps=cnn.prepareStatement("SELECT Discount_ID, Discount_name,Discount_Percent\n" +
                "  FROM DiscountP");
        ResultSet rs=ps.executeQuery();
//        Discount_M[] DM=new Discount_M[count];
        int c=0;
        while(rs.next()){
            Discount_M dm=new Discount_M();
            dm.setDisID(rs.getInt(1));
            dm.setDisname(rs.getString(2));
            dm.setDispercent(rs.getBigDecimal(3));
//            DM[c]=dm;
//            c=c+1;
            ADM.add(dm);
        }
        return  ADM;
//        return DM;
    }
}
