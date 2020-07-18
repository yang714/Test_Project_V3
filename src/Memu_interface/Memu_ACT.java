package Memu_interface;

import Memu_model.Memu_M;
import user_Model.user_M;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Memu_ACT {
//    Memu_M[] Show_memu(Memu_M mem) throws SQLException;
    ArrayList<Memu_M> Show_memu(Memu_M mem) throws SQLException;
    Memu_M[] Food_kind(Memu_M mem) throws SQLException;
    void update_Food(String[] id, String[] name, String[] price, String[] type) throws SQLException;
    void Delete(Memu_M um) throws SQLException;
    void increase_meum(Memu_M um) throws SQLException;
    void increase_type(String type_name)throws SQLException;

}
