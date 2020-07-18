package Check_out_model;

import java.math.BigDecimal;

public class Checkout_model {
    int Order_ID;

    public int getOrder_ID() {
        return Order_ID;
    }

    public int getWho_order() {
        return who_order;
    }

    public int getOrderTableID() {
        return orderTableID;
    }

    public int getMemu_ID() {
        return memu_ID;
    }

    public int getOrder_number() {
        return order_number;
    }

    public int getFood_status() {
        return food_status;
    }

    public void setOrder_ID(int order_ID) {
        Order_ID = order_ID;
    }

    public void setWho_order(int who_order) {
        this.who_order = who_order;
    }

    public void setOrderTableID(int orderTableID) {
        this.orderTableID = orderTableID;
    }

    public void setMemu_ID(int memu_ID) {
        this.memu_ID = memu_ID;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public void setFood_status(int food_status) {
        this.food_status = food_status;
    }

    int who_order;
    int orderTableID;
    int  memu_ID;
    int order_number;
    int food_status;

    public String getTable_name() {
        return Table_name;
    }

    public void setTable_name(String table_name) {
        Table_name = table_name;
    }

    String Table_name;

    public String getMemuname() {
        return memuname;
    }

    public void setMemuname(String memuname) {
        this.memuname = memuname;
    }

    String memuname;

    public void setTableidname(String tableidname) {
        this.tableidname = tableidname;
    }

    public String getTableidname() {
        return tableidname;
    }

    String tableidname;

    public int getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(int checknumber) {
        this.checknumber = checknumber;
    }

    int checknumber;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    int price;

    public int getDprice() {
        return Dprice;
    }

    public void setDprice(int dprice) {
        Dprice = dprice;
    }



    int Dprice;

    public BigDecimal getDiscountP() {
        return DiscountP;
    }

    public void setDiscountP(BigDecimal discountP) {
        DiscountP = discountP;
    }

    BigDecimal DiscountP;

}
