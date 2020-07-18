package Memu_model;


import Memu_interface.set_get_memu;

public class Memu_M  implements set_get_memu {

    public String getMemu_name() {
        return memu_name;
    }

    public int getMemu_price() {
        return memu_price;
    }

    public int getMemu_ID() {
        return memu_ID;
    }

    public int getMeal_ID() {
        return Meal_ID;
    }

    public String getFood_type() {
        return Food_type;
    }

    String memu_name;

    public void setMemu_name(String memu_name) {
        this.memu_name = memu_name;
    }

    public void setMemu_price(int memu_price) {
        this.memu_price = memu_price;
    }

    public void setMemu_ID(int memu_ID) {
        this.memu_ID = memu_ID;
    }

    public void setMeal_ID(int meal_ID) {
        Meal_ID = meal_ID;
    }

    public void setFood_type(String food_type) {
        Food_type = food_type;
    }

    int memu_price;
    int memu_ID;
    int Meal_ID;
    String Food_type;

    public int getOrder_meal_number() {
        return order_meal_number;
    }

    public void setOrder_meal_number(int order_meal_number) {
        this.order_meal_number = order_meal_number;
    }

    int order_meal_number;


}
