package Interface;


import user_Model.user_M;

import java.sql.SQLException;

public interface Action {
    int[] check(user_M um) throws SQLException;
    void insert(user_M um) throws SQLException;
    boolean check_ID(user_M um);
    void chang_pw(user_M um);
    user_M[] Show_user(user_M um) throws SQLException;
//    int Show_total(String table)throws SQLException;
    void Delete(user_M um)throws SQLException;

//
//    void setId(String test_insert);
//
//    void setPw(String test_insert123);
}
