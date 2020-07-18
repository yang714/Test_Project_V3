package Report_number;

import org.json.simple.JSONObject;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Report_NA implements ReportN_In{
    @Resource(name="DataS")
    DataSource ds;
    @Resource(name="ReportN_A")
    Report_NA rna;
    @Override
    public ArrayList<Integer> Report_GETY() throws SQLException {
        Connection cnn=ds.getConnection();
        PreparedStatement ps=cnn.prepareStatement("SELECT  Year(Check_Date)\n" +
                "FROM Check_out\n" +
                "group by Year(Check_Date)");
        ResultSet rs=ps.executeQuery();
        ArrayList<Integer> ARY=new ArrayList();

        while(rs.next()){
//            ReportN_model RNM=new ReportN_model();
//            RNM.setDATE(rs.getInt(1));
        ARY.add(rs.getInt(1));
        }
        for(int i:ARY){
            System.out.println("year "+i);
        }
        return ARY;
    }

    @Override
    public JSONObject Report_Meal(int year, int Month ,String[] meal_item) throws SQLException {
        Connection cnn=ds.getConnection();
        ArrayList<ReportN_model> ARNM=new ArrayList();
        if( meal_item==null){//all item
            if(Month!=13){//all item specific month
                PreparedStatement ps=cnn.prepareStatement(
                        "SELECT sum(check_number) ,Meal_type.Type\n" +
                                "  FROM Check_out\n" +
                                "  join Memu on Check_out.memu_ID=Memu.memu_ID\n" +
                                "  join Meal_type on Meal_type.meal_ID=Memu.meal_ID\n" +
                                "  where YEAR(Check_Date)=?  and MONTH(Check_Date)=?\n" +
                                "     group by Meal_type.Type");
                ps.setInt(1,year);
                ps.setInt(2,Month);
                ResultSet rs=ps.executeQuery();
//                ArrayList<ReportN_model> ARNM=new ArrayList();
                while(rs.next()){
                    ReportN_model arnm=new ReportN_model();
                    arnm.setCount(rs.getInt(1));
                    arnm.setName(rs.getString(2));
                    ARNM.add(arnm);
                }
                for(ReportN_model mm:ARNM){
                    System.out.println(" COUNT "+mm.getCount()+" name "+mm.getName());
                }

//                return ARNM;
            }
            else if(Month==13){
                PreparedStatement ps=cnn.prepareStatement(
                        "SELECT sum(check_number) ,Meal_type.Type\n" +
                                "  FROM Check_out\n" +
                                "  join Memu on Check_out.memu_ID=Memu.memu_ID\n" +
                                "  join Meal_type on Meal_type.meal_ID=Memu.meal_ID\n" +
                                "  where YEAR(Check_Date)=?\n" +
                                "     group by Meal_type.Type");
                ps.setInt(1,year);
                ResultSet rs=ps.executeQuery();
//                ArrayList<ReportN_model> ARNM=new ArrayList();
                while(rs.next()){
                    ReportN_model arnm=new ReportN_model();
                    arnm.setCount(rs.getInt(1));
                    arnm.setName(rs.getString(2));
                    ARNM.add(arnm);
                }
                for(ReportN_model mm:ARNM){
                    System.out.println(" COUNT "+mm.getCount()+" name "+mm.getName());
                }

//                return ARNM;
            }

        }
        /*SELECT sum(check_number) ,Meal_type.Type\n" +
                                "  FROM Check_out\n" +
                                "  join Memu on Check_out.memu_ID=Memu.memu_ID\n" +
                                "  join Meal_type on Meal_type.meal_ID=Memu.meal_ID\n" +
                                "  where YEAR(Check_Date)=?\n" +
                                "     group by Meal_type.Type*/
        else{//specific item
            if(Month!=13){//specific item specific month
//                ArrayList<ReportN_model> ARNM=new ArrayList();
                for(String I:meal_item){
                    PreparedStatement ps=cnn.prepareStatement(
                        "SELECT sum(check_number) ,Meal_type.Type\n" +
                                "  FROM Check_out \n" +
                                "  join Memu on Check_out.memu_ID=Memu.memu_ID\n" +
                                " join Meal_type on Meal_type.meal_ID=Memu.meal_ID\n"+
                                "  where YEAR(Check_Date)=?  and MONTH(Check_Date)=? and Memu.meal_ID=?\n" +
                                "  group by Meal_type.Type");

                ps.setInt(1,year);
                ps.setInt(2,Month);
              ps.setInt(3, Integer.parseInt(I));
            System.out.println("I is-->  "+I);
             ResultSet rs=ps.executeQuery();
            while(rs.next()){
               ReportN_model arnm=new ReportN_model();
              arnm.setCount(rs.getInt(1));
              arnm.setName(rs.getString(2));
                ARNM.add(arnm);
                    }
        }


                for(ReportN_model mm:ARNM){
                    System.out.println(" COUNT "+mm.getCount()+" name "+mm.getName());
                }

//                return ARNM;
            }
            else if(Month==13){//specific item all month
//                ArrayList<ReportN_model> ARNM=new ArrayList();
                for(String I:meal_item){
                    PreparedStatement ps=cnn.prepareStatement(
                            "SELECT sum(check_number) ,Meal_type.Type\n" +
                                    "  FROM Check_out \n" +
                                    "  join Memu on Check_out.memu_ID=Memu.memu_ID\n" +
                                    " join Meal_type on Meal_type.meal_ID=Memu.meal_ID\n"+
                                    "  where YEAR(Check_Date)=?  and Memu.meal_ID=?\n" +
                                    "  group by Meal_type.Type");

                    ps.setInt(1,year);
                    ps.setInt(2, Integer.parseInt(I));
                    System.out.println("I is-->  "+I);
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()){
                        ReportN_model arnm=new ReportN_model();
                        arnm.setCount(rs.getInt(1));
                        arnm.setName(rs.getString(3));
                        ARNM.add(arnm);
                    }
                }


                for(ReportN_model mm:ARNM){
                    System.out.println(" COUNT "+mm.getCount()+" name "+mm.getName());
                }

            }

        }

        JSONObject obj = new JSONObject();
        JSONObject finobj = new JSONObject();
        ArrayList<Integer> data=new ArrayList();
        ArrayList<String> labels=new ArrayList();
        ArrayList<String> label=new ArrayList();
        ArrayList<String> rgb=new ArrayList();
        ArrayList<JSONObject> objarray=new ArrayList();
            for(int i=0;i<ARNM.size();i++){
                double x = Math.floor(Math.random() * 256);
                double y= Math.floor(Math.random() * 256);
                double z = Math.floor(Math.random() * 256);
                String rgba= "rgba(" + x + "," + y + "," + z + ","+0.6+")";
//                JSONObject obj = new JSONObject();
                data.add( ARNM.get(i).getCount());
                labels.add(ARNM.get(i).getName());
//                rgb.add(rgba);
                String HEX_COLOR=rna.Hex_colorcode();
                rgb.add(HEX_COLOR);
//                brgb.add(rgba);

            }
        label.add("total_number");
///datasets
            obj.put("data", data);
            obj.put("label", label);
//                obj.put("backgroundColor",rgba);
//            obj.put("borderColor", rgb);
            obj.put("backgroundColor", rgb);
///datasets
        ////toarray
        objarray.add(obj);
        ////toarray
            finobj.put("labels",labels);
        finobj.put("datasets",objarray);



        System.out.println(finobj);

        return finobj;
    }

    @Override
    public JSONObject Report_Memu(int year, int Month, String[] mumuitem) throws SQLException {
        Connection cnn=ds.getConnection();
        ArrayList<ReportN_model> ARNM=new ArrayList();
        if(  mumuitem==null){//all item
            if(Month!=13){//all item specific month
                //Meal_type.Type 改
                PreparedStatement ps=cnn.prepareStatement(
                        " SELECT sum(Check_out.check_number) ,Memu.memu_ID,Memu.Name\n" +
                                "  FROM Check_out \n" +
                                "  join Memu on Check_out.memu_ID=Memu.memu_ID\n" +
//                                " join Meal_type on Meal_type.meal_ID=Memu.meal_ID\n"+
                                "  where YEAR(Check_Date)=?  and MONTH(Check_Date)=?\n" +
                                "   group by Memu.memu_ID ,Memu.Name");
                ps.setInt(1,year);
                ps.setInt(2,Month);
                ResultSet rs=ps.executeQuery();
//                ArrayList<ReportN_model> ARNM=new ArrayList();
                while(rs.next()){
                    ReportN_model arnm=new ReportN_model();
                    //ADD MODEL MEMU COUNT
                    arnm.setCount(rs.getInt(1));
                    //ADD MODEL MEMU NAME
                    arnm.setName(rs.getString(3));
                    ARNM.add(arnm);
                }
                for(ReportN_model mm:ARNM){
                    System.out.println(" COUNT "+mm.getCount()+" name "+mm.getName());
                }

//                return ARNM;
            }
            else if(Month==13){//all item all month
                PreparedStatement ps=cnn.prepareStatement(
                        "SELECT sum(Check_out.check_number) ,Memu.memu_ID,Memu.Name\n" +
                                "  FROM Check_out \n" +
                                "  join Memu on Check_out.memu_ID=Memu.memu_ID\n" +
                                "  where YEAR(Check_Date)=? \n" +
                                "   group by Memu.memu_ID ,Memu.Name");
                ps.setInt(1,year);
                ResultSet rs=ps.executeQuery();
//                ArrayList<ReportN_model> ARNM=new ArrayList();
                while(rs.next()){
                    ReportN_model arnm=new ReportN_model();
                    arnm.setCount(rs.getInt(1));
                    arnm.setName(rs.getString(3));
                    ARNM.add(arnm);
                }
                for(ReportN_model mm:ARNM){
                    System.out.println(" COUNT "+mm.getCount()+" name "+mm.getName());
                }

//                return ARNM;
            }

        }
        else{//specific item
            if(Month!=13){//specific item specific month
//                ArrayList<ReportN_model> ARNM=new ArrayList();
                for(String I: mumuitem){
                    PreparedStatement ps=cnn.prepareStatement(
                            "SELECT sum(Check_out.check_number) ,Memu.memu_ID,Memu.Name\n" +
                                    "  FROM Check_out \n" +
                                    "  join Memu on Check_out.memu_ID=Memu.memu_ID\n" +

                                    "  where YEAR(Check_Date)=?  and MONTH(Check_Date)=? and Memu.memu_ID=?\n" +
                                    "    group by Memu.memu_ID ,Memu.Name");

                    ps.setInt(1,year);
                    ps.setInt(2,Month);
                    ps.setInt(3, Integer.parseInt(I));
                    System.out.println("I is-->  "+I);
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()){
                        ReportN_model arnm=new ReportN_model();
                        arnm.setCount(rs.getInt(1));
                        arnm.setName(rs.getString(3));
                        ARNM.add(arnm);
                    }
                }


                for(ReportN_model mm:ARNM){
                    System.out.println(" COUNT "+mm.getCount()+" name "+mm.getName());
                }

//                return ARNM;
            }
            else if(Month==13){//specific item all month
//                ArrayList<ReportN_model> ARNM=new ArrayList();
                for(String I: mumuitem){
                    PreparedStatement ps=cnn.prepareStatement(
                            "SELECT sum(Check_out.check_number) ,Memu.memu_ID,Memu.Name\n" +
                                    "  FROM Check_out \n" +
                                    "  join Memu on Check_out.memu_ID=Memu.memu_ID\n" +

                                    "  where YEAR(Check_Date)=?  and Memu.memu_ID=?\n" +
                                    "    group by Memu.memu_ID ,Memu.Name");

                    ps.setInt(1,year);
                    ps.setInt(2, Integer.parseInt(I));
                    System.out.println("I is-->  "+I);
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()){
                        ReportN_model arnm=new ReportN_model();
                        arnm.setCount(rs.getInt(1));
                        arnm.setName(rs.getString(3));
                        ARNM.add(arnm);
                    }
                }


                for(ReportN_model mm:ARNM){
                    System.out.println(" COUNT "+mm.getCount()+" name "+mm.getName());
                }

            }

        }

        JSONObject obj = new JSONObject();
        JSONObject finobj = new JSONObject();
        ArrayList<Integer> data=new ArrayList();
        ArrayList<String> labels=new ArrayList();
        ArrayList<String> label=new ArrayList();
        ArrayList<String> rgb=new ArrayList();
        ArrayList<JSONObject> objarray=new ArrayList();
        for(int i=0;i<ARNM.size();i++){
            double x = Math.floor(Math.random() * 256);
            double y= Math.floor(Math.random() * 256);
            double z = Math.floor(Math.random() * 256);
            String rgba= "rgba(" + x + "," + y + "," + z + ","+0.6+")";
//                JSONObject obj = new JSONObject();
            data.add( ARNM.get(i).getCount());
            labels.add(ARNM.get(i).getName());
//                rgb.add(rgba);
            String HEX_COLOR=rna.Hex_colorcode();
            rgb.add(HEX_COLOR);
//                brgb.add(rgba);

        }
        label.add("total_number");
///datasets
        obj.put("data", data);
        obj.put("label", label);
//                obj.put("backgroundColor",rgba);
//            obj.put("borderColor", rgb);
        obj.put("backgroundColor", rgb);
///datasets
        ////toarray
        objarray.add(obj);
        ////toarray
        finobj.put("labels",labels);
        finobj.put("datasets",objarray);



        System.out.println(finobj);

        return finobj;
    }


    @Override
    public String Hex_colorcode() {
        Random obj = new Random();
        int rand_num = obj.nextInt(0xffffff + 1);
// format it as hexadecimal string and print
        String colorCode = String.format("#%06x", rand_num);
        return colorCode;
    }


}
