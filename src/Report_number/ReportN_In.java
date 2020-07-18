package Report_number;

import org.json.simple.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReportN_In {
    ArrayList<Integer> Report_GETY() throws SQLException;
//    ArrayList<JSONObject> Report_Meal(int year, int Month, String[] item) throws SQLException;
    JSONObject Report_Meal(int year, int Month, String[] item) throws SQLException;
    JSONObject Report_Memu(int year, int Month, String[] item) throws SQLException;
    String Hex_colorcode();
}
