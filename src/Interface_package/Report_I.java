package Interface_package;


//import  Test_check.CheckOutEntity;
import EX_Entity.Report_Model;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public interface Report_I {
//    Checkout_model Report(Date D1, Date D2) throws SQLException;
//    Report_Model[] ReportV2(String D1, String D2) throws SQLException, ParseException;
    ArrayList<Report_Model> ReportV2(String D1, String D2) throws SQLException, ParseException;
    ArrayList<Report_Model> ReportV3(String MorY) throws SQLException;

//    ArrayList<CheckOutEntity> ReportV2(String D1, String D2) throws SQLException, ParseException;
}
