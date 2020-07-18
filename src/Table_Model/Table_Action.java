package Table_Model;

import Memu_model.Memu_Action;
import Memu_model.Memu_M;
import Test_show_total.Show_T;
import order_interface.order_inf;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Table_Action implements order_inf {
    @Resource(name = "DataS")
    DataSource ds;
    @Resource(name="Test_show")
    public Show_T ss;
    @Resource(name="Memu_A")
    public Memu_Action MA;

    @Override
    public Table_model[] Table_name(Table_model TM) throws SQLException {//abc
        Connection cnn=ds.getConnection();
        String sql="SELECT distinct [Table_Name]\n" +
                "\n" +
                "  FROM [Test_DataBase].[dbo].[Table_Kind]";
        PreparedStatement ps=cnn.prepareStatement(
                sql);
//
        ResultSet RS= ps.executeQuery();
      int count=ss.Show_total("SELECT count(distinct([Table_Name]))\n" +
              "\n" +
              "  FROM [Test_DataBase].[dbo].[Table_Kind]");
      System.out.println("count  "+count);
      int c=0;
       Table_model[] TMM= new Table_model[count];
        while(RS.next()){
            TM= new Table_model();
            TM.setTable_name(RS.getString(1));
            TMM[c]=TM;
            c=c+1;
        }
return TMM;
    }

    @Override
    public Table_model[] Table_number(Table_model TM, String Table_name) throws SQLException {
        Connection cnn=ds.getConnection();
        PreparedStatement ps=cnn.prepareStatement(
                "SELECT [Table_ID]\n" +
                        "      ,[Table_Name]\n" +
                        "      ,[Table_number]\n" +
                        "  FROM [Test_DataBase].[dbo].[Table_Kind]\n" +
                        "  where Table_Name=?");
        ps.setString(1,Table_name);
        ResultSet rs=ps.executeQuery();

        String query = String.format("SELECT count(*) FROM Table_Kind" +
                " where Table_Name='%s'", Table_name);
        int count=ss.Show_total(query);
        Table_model[] TMM=new Table_model[count];
        int c=0;
        while (rs.next()){
            TM=new Table_model();
            TM.setTable_ID(rs.getInt(1));
            TM.setTable_name(rs.getString(2));
            TM.setTable_number(rs.getInt(3));
            TMM[c]=TM;
            c=c+1;

        }
        return TMM;
    }
    public ArrayList<Memu_M> call_Memu(Memu_M mem) throws SQLException {

//        Memu_M[] show_model= MA.Show_memu(mem);
        ArrayList<Memu_M> show_model=MA.Show_memu(mem);
        return show_model;
    }

    @Override
    public Table_model[] Table_namenumber(Table_model TM) throws SQLException {//all table_name
        Connection cnn=ds.getConnection();

        int count=ss.Show_total("SELECT count(*)\n" +
                "  FROM [Test_DataBase].[dbo].[Table_Kind]");
        PreparedStatement ps=cnn.prepareStatement(
                "SELECT [Table_ID]\n" +
                        "      ,[Table_Name]\n" +
                        "      ,[Table_number]\n" +
                        "\t  ,Table_Name+ CONVERT(varchar(10), Table_number) as name_number\n" +
                        "  FROM [Test_DataBase].[dbo].[Table_Kind]");
        Table_model[] TNN=new Table_model[count];
        ResultSet rs=ps.executeQuery();
        int c=0;
        while(rs.next()){
            TM=new Table_model();
            TM.setTable_ID(rs.getInt(1));
            TM.setTablenamenumber(rs.getString(4));
            TNN[c]=TM;
            c=c+1;
        }
        return TNN;
    }


}
