package Test_show_total;

import Memu_model.Memu_M;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Show_TL implements Show_T{
    @Resource(name = "DataS")
    DataSource ds;
    @Resource(name="Test_show")
    public Show_T ss;
    @Override
    public int Show_total(String SQL) throws SQLException {
        Connection cnn=ds.getConnection();
//        String query = String.format("SELECT COUNT(*) FROM %s", table);
        String query=SQL;
        PreparedStatement ps=cnn.prepareStatement(
                query );

        ResultSet RS_count= ps.executeQuery();
        RS_count.next();
        int count=RS_count.getInt(1);
        //select number------------------------------------
        return count;
    }

    @Override
    public int Show_total_Date(String SQL, String d1, String d2) throws SQLException {
        return 0;
    }


}
