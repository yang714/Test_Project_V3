package Report;

import java.sql.Date;

public class Report_Model {
    int Check_ID;
    int Order_ID;
    int who_order;
    int who_check;
    int memu_ID;
    int originincome;

    public int getOriginincome() {
        return originincome;
    }

    public void setOriginincome(int originincome) {
        this.originincome = originincome;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public Date getDD() {
        return DD;
    }

    public void setDD(Date DD) {
        this.DD = DD;
    }

    int income;
    Date DD;

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    String DATE;
}
