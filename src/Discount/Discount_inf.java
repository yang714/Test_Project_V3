package Discount;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Discount_inf {
    void addnewDis(String Discount_name ,String Discount_percent) throws SQLException;
    void DeleteDis(String SeleID) throws SQLException;
//    Discount_M[] Show_Delete() throws SQLException;
ArrayList<Discount_M> Show_Delete() throws SQLException;
}
