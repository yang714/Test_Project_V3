package Test_show_total;

import Memu_model.Memu_M;

import java.sql.SQLException;

public interface Show_T {
    int Show_total(String SQL)throws SQLException;
    int Show_total_Date(String SQL,String d1,String d2)throws SQLException;

}
