package Interface_package;


import Test_HIB.MealTypeEntity;
import Test_HIB.MemuEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Memu_ACT {
//    Memu_M[] Show_memu(Memu_M mem) throws SQLException;
    ArrayList<MemuEntity> Show_memu(MemuEntity mem) ;
    ArrayList<MealTypeEntity> Food_kind( MealTypeEntity mem) ;
    void update_Food(String[] id, String[] name, String[] price, String[] type) throws SQLException;
    void Delete(MemuEntity um) throws SQLException;
    void increase_meum(MemuEntity um) throws SQLException;
    void increase_type(String type_name)throws SQLException;

}
