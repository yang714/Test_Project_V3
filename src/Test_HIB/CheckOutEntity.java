package Test_HIB;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Check_out", schema = "dbo", catalog = "Test_DataBase")
public class CheckOutEntity {
    private int checkId;
    private int orderId;
    private Integer whoOrder;
    private Integer whoCheck;
    private Integer memuId;
    private int checkNumber;
    private BigDecimal disP;
    private int originPrice;
    private int discountPrice;
    private Date checkDate;

    @Id
    @Column(name = "Check_ID")
    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    @Basic
    @Column(name = "Order_ID")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "who_order")
    public Integer getWhoOrder() {
        return whoOrder;
    }

    public void setWhoOrder(Integer whoOrder) {
        this.whoOrder = whoOrder;
    }

    @Basic
    @Column(name = "who_check")
    public Integer getWhoCheck() {
        return whoCheck;
    }

    public void setWhoCheck(Integer whoCheck) {
        this.whoCheck = whoCheck;
    }

    @Basic
    @Column(name = "memu_ID")
    public Integer getMemuId() {
        return memuId;
    }

    public void setMemuId(Integer memuId) {
        this.memuId = memuId;
    }

    @Basic
    @Column(name = "check_number")
    public int getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Basic
    @Column(name = "Dis_P")
    public BigDecimal getDisP() {
        return disP;
    }

    public void setDisP(BigDecimal disP) {
        this.disP = disP;
    }

    @Basic
    @Column(name = "OriginPrice")
    public int getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(int originPrice) {
        this.originPrice = originPrice;
    }

    @Basic
    @Column(name = "DiscountPrice")
    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Basic
    @Column(name = "Check_Date")
    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckOutEntity that = (CheckOutEntity) o;
        return checkId == that.checkId &&
                orderId == that.orderId &&
                checkNumber == that.checkNumber &&
                originPrice == that.originPrice &&
                discountPrice == that.discountPrice &&
                Objects.equals(whoOrder, that.whoOrder) &&
                Objects.equals(whoCheck, that.whoCheck) &&
                Objects.equals(memuId, that.memuId) &&
                Objects.equals(disP, that.disP) &&
                Objects.equals(checkDate, that.checkDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkId, orderId, whoOrder, whoCheck, memuId, checkNumber, disP, originPrice, discountPrice, checkDate);
    }
}
