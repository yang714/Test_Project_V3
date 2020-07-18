package user_Model;

import Interface.Action;
import Test_show_total.Show_T;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;

public class user_Action implements Action {
    @Resource(name = "DataS")
    DataSource ds;
    @Resource(name="Test_show")
    public Show_T ss;



    public int[] check(user_M um) throws SQLException {
        System.out.println("ss***>s "+ ss);

        System.out.println(um.getId()+" >>>!!!!!<<<  "+um.getPw());
        try {
//            System.out.print(um.getId()+"  "+um.getPw());
            Connection cnn=ds.getConnection();
            PreparedStatement ps=cnn.prepareStatement(
                    "select * from User_1 where user_name=? and user_pw=? collate Chinese_PRC_CS_AI");
//            PreparedStatement ps=cnn.prepareStatement(
//                    "select * from User_1");
            ps.setString(1,um.getId());
            ps.setString(2,um.getPw());
            ResultSet rs=ps.executeQuery();


            if(rs.next()) {
                System.out.println("1-->"+rs.getString(1)+"  (2) "+rs.getString(2)+"  "+
                        rs.getString(3)+"       "+rs.getInt(4));
//                System.out.print(rs.getString(2)+"  "+rs.getString(3));
//                um.setId_number(rs.getInt(4));
                return new int[]{rs.getInt(4), rs.getInt(1)};
//                if(rs.getInt(4)==1){
//                    return 1;
////                            return "pag_user";
//                }
//                else if(rs.getInt(4)==0){
//                    return 0;
////                    return "pag_Master";
//                }


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
//        return "pag_user";
    }

    public void insert(user_M um) throws SQLException {
        Connection cnn=ds.getConnection();
        boolean userexist=true;
        if(check_ID(um)==true){

        }
        try {


            PreparedStatement ps=cnn.prepareStatement(
                    "INSERT INTO User_1 (user_name,user_pw,UserOrMaster)\n" +
                            "VALUES (?,?,?) ");
            ps.setString(1,um.getId());
            ps.setString(2,um.getPw());
            ps.setInt(3,um.getUM_number());

            ps.executeQuery();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public boolean check_ID(user_M um){
        boolean exist_in_Table = false;

        try {
            Connection cnn=ds.getConnection();
            PreparedStatement ps=cnn.prepareStatement(
                    "select * from User_1 where user_name=? collate Chinese_PRC_CS_AI");
            ps.setString(1,um.getId());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                System.out.println("idnumberis  "+rs.getInt(1));
                if(rs.getInt(1)>=1)
                {
                    exist_in_Table = true;
                   
                System.out.println("有重複");
                }
                else{
                    exist_in_Table =false;
                    System.out.println("no重複");

                    
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return exist_in_Table;
    }

    public void chang_pw(user_M um){

        try {
            Connection cnn=ds.getConnection();
            PreparedStatement ps=cnn.prepareStatement(
                    "UPDATE User_1  set user_pw=?  where user_name=? " +
                            "collate Chinese_PRC_CS_AI");
            ps.setString(2,um.getId());
            ps.setString(1,um.getPw());
//            ps.setString(3,um.getOld_pw());
            ps.executeUpdate();


        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public int Show_total(String table) throws SQLException {
//        Connection cnn=ds.getConnection();
//        String query = String.format("SELECT COUNT(*) FROM %s", table);
//        PreparedStatement ps=cnn.prepareStatement(
//                query );
//
//        ResultSet RS_count= ps.executeQuery();
//        RS_count.next();
//        int count=RS_count.getInt(1);
//        //select number------------------------------------
//return count;
//
//    }

    @Override
    public void Delete(user_M um) throws SQLException {
       try {
           Connection cnn=ds.getConnection();

           PreparedStatement ps=cnn.prepareStatement("DELETE FROM User_1 WHERE ID=?");
           ps.setInt(1,um.getId_number());
           ps.executeQuery();
       }catch (SQLException e) {
           e.printStackTrace();
       }


    }

    public user_M[] Show_user(user_M um){
//        ArrayList<user_M[]> AL=new ArrayList<user_M[]>();
        user_M[] um_s = new user_M[0];
        System.out.println("here");
        try {
            Connection cnn=ds.getConnection();
            PreparedStatement ps=cnn.prepareStatement(
                    "select * from User_1");
//
           ResultSet RS= ps.executeQuery();

           //select number------------------------------------
//            int count=Show_total("User_1");
            int count=ss.Show_total("SELECT COUNT(*) FROM User_1");
//            System.out.println("here count "+count);
            //------------------------------
            um_s=new user_M[count];
            int c=0;
           while(RS.next()){
               um = new user_M();//new 物件 deep copy
//               System.out.println("----->"+RS.getString(2));
               um.setId_number(RS.getInt(1));
               um.setId(RS.getString(2));
               um.setPw(RS.getString(3));
               um.setDate((java.util.Date) RS.getDate(5));
               um.setUM_number(RS.getInt(4));
               um_s[c]=um;
//               System.out.println(um_s[c].getId());
               c=c+1;

           }
//           for(int j=0;j<c;j++){
//               System.out.println("*****"+um_s[j].getId());
//           }



        }catch (SQLException e) {
            e.printStackTrace();
        }
        return um_s;
    }


}
