package Order_Table_Model;

import Memu_model.Memu_M;
import Order_Table.Order_Table_Interface;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Order_Table_Action implements Order_Table_Interface {
    @Resource(name = "DataS")
    DataSource ds;
    @Resource(name="Memu_M")
    public Memu_M mm;
    @Override
    public Memu_M[] Save_Order(String[] sid, String[] sanme, String[] snumber) throws SQLException {
        Memu_M[] MM=new Memu_M[sid.length];
        for(int i=0;i<sid.length;i++){
            mm=new Memu_M();
            mm.setMemu_ID(Integer.valueOf(sid[i]));
            mm.setMemu_name(sanme[i]);
            mm.setOrder_meal_number(Integer.valueOf(snumber[i]));

            MM[i]=mm;
        }

        return MM;
    }

    @Override
    public int FindTable_ID(String tablename, String tablenumber) throws SQLException {
        Connection cnn=ds.getConnection();
        PreparedStatement ps=cnn.prepareStatement(
                "SELECT  Table_ID\n" +
                        " \n" +
                        "  FROM Table_Kind\n" +
                        "  where Table_Name=? and Table_number=?");
        ps.setString(1, tablename);
        ps.setString(2,tablenumber);
        ResultSet rs=ps.executeQuery();
        int t_id=0;
        while(rs.next()){
            t_id=rs.getInt(1);
        }
        return t_id;
    }

    @Override
    public void SaveOrder2DataB(Object user_id,int t_id, Memu_M[] MO) throws SQLException {
        Connection cnn=ds.getConnection();
        PreparedStatement ps=cnn.prepareStatement("INSERT INTO OrderTable (who_order,orderTableID," +
                "memu_ID,order_number,food_status)\n" +
                "VALUES (?,?,?,?,?) ");

        System.out.println( user_id);
        for(int i=0;i<MO.length;i++){

//            System.out.println(" Integer.parseInt(id[i])  "+ Integer.parseInt(id[i]));
            ps.setInt(1, (Integer) user_id);
            ps.setString(2, String.valueOf(t_id));
            ps.setInt(3,(MO[i].getMemu_ID()));
            ps.setInt(4, (MO[i].getOrder_meal_number()));
            ps.setInt(5, 0);
            ps.addBatch();
        }
        ps.executeBatch();
//        return new Memu_M[0];
    }

}
