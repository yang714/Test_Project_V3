package Test_HIB;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Memu", schema = "dbo", catalog = "Test_DataBase")
public class MemuEntity {
    private int memuId;
    private String name;
    private int price;
    private Integer mealId;

    @Id
    @Column(name = "memu_ID")
    public int getMemuId() {
        return memuId;
    }

    public void setMemuId(int memuId) {
        this.memuId = memuId;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "meal_ID")
    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemuEntity that = (MemuEntity) o;
        return memuId == that.memuId &&
                price == that.price &&
                Objects.equals(name, that.name) &&
                Objects.equals(mealId, that.mealId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memuId, name, price, mealId);
    }

    public int getOrder_meal_number() {
        return Order_meal_number;
    }

    public void setOrder_meal_number(int order_meal_number) {
        Order_meal_number = order_meal_number;
    }

    int Order_meal_number;
}
