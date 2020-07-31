package Interface_package;

import EX_Entity.Table_model;
import Test_HIB.MemuEntity;
import Test_HIB.TableKindEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface order_inf {//點餐
//    Table_model[] Table_name(Table_model TM) throws SQLException;
//    Table_model[] Table_number(Table_model TM,String Table_name) throws SQLException;
    ArrayList<TableKindEntity> Table_namenumber(Table_model TM) throws SQLException;

    ArrayList<MemuEntity> call_Memu(MemuEntity mem) throws SQLException;

    ArrayList Table_name() throws SQLException;
    ArrayList<TableKindEntity> Table_number(String Table_name) throws SQLException;
//    Table_model[] Table_namenumber(TableKindEntity TM) throws SQLException;


}
