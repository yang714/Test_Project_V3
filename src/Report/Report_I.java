package Report;

import Check_out_model.Checkout_model;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public interface Report_I {
    Checkout_model Report(Date D1, Date D2) throws SQLException;
//    Report_Model[] ReportV2(String D1, String D2) throws SQLException, ParseException;
    ArrayList<Report_Model> ReportV2(String D1, String D2) throws SQLException, ParseException;
    ArrayList<Report_Model> ReportV3(String MorY) throws SQLException;
}
