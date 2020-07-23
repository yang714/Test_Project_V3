package Report;

import Check_out_model.Checkout_model;
import Test_HIB.CheckOutEntity;
//import  Test_check.CheckOutEntity;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public interface Report_I {
//    Checkout_model Report(Date D1, Date D2) throws SQLException;
//    Report_Model[] ReportV2(String D1, String D2) throws SQLException, ParseException;
    ArrayList<Report_Model> ReportV2(String D1, String D2) throws SQLException, ParseException;
    ArrayList<Report_Model> ReportV3(String MorY) throws SQLException;

//    ArrayList<CheckOutEntity> ReportV2(String D1, String D2) throws SQLException, ParseException;
}
