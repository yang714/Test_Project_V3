package Check_out_interface;

import Check_out_model.Checkout_model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Check_out_intf {
//    Checkout_model[] show_order(int Table_ID) throws SQLException;
    ArrayList<Checkout_model> show_order(int Table_ID) throws SQLException;
    String Tableidname(int id) throws SQLException;
    /////
    ArrayList<String> processIDOnumber(String[] IDOnumber);
    ArrayList<String> processORDER_NUMBER(String[] ORDER_NUMBER);
    /////
//    Checkout_model[] UpdateOrder(String[] IDOnumber, String[] checknumber) throws SQLException;
    public void UpdateOrder(String[] IDOnumber, String[] checknumber) throws SQLException;
    Checkout_model[] FOODNAME_CHECK(String[] IDOnumber, String[] ORDER_NUMBER) throws SQLException;
//    Checkout_model[] FOODNAME_CHECK(ArrayList<String> save_id, ArrayList<String>  save_check) throws SQLException;
    void Update2table(Checkout_model[] AFCM, int who_check) throws SQLException;
    void Delete_zero(ArrayList<Integer> delete) throws SQLException;
}
