package Order_Table;

import Memu_model.Memu_M;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Order_Table_Interface {//連資料庫
    Memu_M[] Save_Order(String[] sid,String[] sanme,String[] snumber) throws SQLException;
//   ArrayList<Memu_M> Save_Order(String[] sid, String[] sanme, String[] snumber) throws SQLException;
    int FindTable_ID(String tablename,String tablenumber)throws SQLException;
    void SaveOrder2DataB(Object user_id,int t_id, Memu_M[] MO) throws SQLException;

}
