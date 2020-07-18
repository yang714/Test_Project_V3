package Memu_interface;

public interface set_get_memu{
    void setMemu_name(String memu_name);
    void setMemu_price(int memu_price);
    void setMemu_ID(int memu_ID);
    void setMeal_ID(int meal_ID);
    void setFood_type(String food_type);
    String getMemu_name();
    int getMemu_price();
    int getMemu_ID();
    int getMeal_ID();
    String getFood_type();

}
