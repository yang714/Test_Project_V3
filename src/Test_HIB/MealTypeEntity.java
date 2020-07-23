package Test_HIB;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Meal_type", schema = "dbo", catalog = "Test_DataBase")
public class MealTypeEntity {
    private int mealId;
    private String type;

    @Id
    @Column(name = "meal_ID")
    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    @Basic
    @Column(name = "Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealTypeEntity that = (MealTypeEntity) o;
        return mealId == that.mealId &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealId, type);
    }
}
