package Discount;

import java.math.BigDecimal;

public class Discount_M {


    public String getDisname() {
        return Disname;
    }

    public void setDisname(String disname) {
        Disname = disname;
    }

    public void setDispercent(BigDecimal dispercent) {
        Dispercent = dispercent;
    }

    public BigDecimal getDispercent() {
        return Dispercent;
    }

    BigDecimal Dispercent;
    String Disname;

    public int getDisID() {
        return DisID;
    }

    public void setDisID(int disID) {
        DisID = disID;
    }

    int DisID;
}
