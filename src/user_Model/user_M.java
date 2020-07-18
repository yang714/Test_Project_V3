package user_Model;

import java.util.Date;

public class user_M{


    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public void setId(String id) {
        this.id = id;

    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    String id;
    String pw;

    public int getUM_number() {
        return UM_number;
    }

    public void setUM_number(int UM_number) {
        this.UM_number = UM_number;
    }

    int UM_number;

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    Date date;

    public int getId_number() {
        return id_number;
    }

    public void setId_number(int id_number) {
        this.id_number = id_number;
    }

    int id_number;






}
