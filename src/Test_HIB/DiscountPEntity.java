package Test_HIB;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "DiscountP", schema = "dbo", catalog = "Test_DataBase")
public class DiscountPEntity {
    private int discountId;
    private String discountName;
    private BigDecimal discountPercent;

    @Id
    @Column(name = "Discount_ID")
    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    @Basic
    @Column(name = "Discount_name")
    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    @Basic
    @Column(name = "Discount_Percent")
    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(BigDecimal discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountPEntity that = (DiscountPEntity) o;
        return discountId == that.discountId &&
                Objects.equals(discountName, that.discountName) &&
                Objects.equals(discountPercent, that.discountPercent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountId, discountName, discountPercent);
    }
}
