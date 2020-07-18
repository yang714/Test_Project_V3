package order_interface;

import Memu_model.Memu_M;
import Table_Model.Table_model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface order_inf {//點餐
    Table_model[] Table_name(Table_model TM) throws SQLException;
    Table_model[] Table_number(Table_model TM,String Table_name) throws SQLException;
    ArrayList<Memu_M> call_Memu(Memu_M mem) throws SQLException;

    Table_model[] Table_namenumber(Table_model TM) throws SQLException;
}
