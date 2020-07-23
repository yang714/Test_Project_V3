package Interface;


import Test_HIB.User1Entity;
import user_Model.user_M;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Action {
    int[] check(User1Entity um) throws SQLException;
    void  insert(User1Entity um) throws SQLException;
    boolean check_ID(User1Entity um);
    void chang_pw(user_M um);
    ArrayList<User1Entity> Show_user(User1Entity um) throws SQLException;
//    int Show_total(String table)throws SQLException;
    void Delete(User1Entity um)throws SQLException;

//
//    void setId(String test_insert);
//
//    void setPw(String test_insert123);
}
