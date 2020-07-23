package Test_HIB;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "OrderTable", schema = "dbo", catalog = "Test_DataBase")
public class OrderTableEntity {
    private int orderId;
    private Integer whoOrder;
    private Integer orderTableId;
    private Integer memuId;
    private int orderNumber;
    private int foodStatus;

    @Id
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
    @Column(name = "orderTableID")
    public Integer getOrderTableId() {
        return orderTableId;
    }

    public void setOrderTableId(Integer orderTableId) {
        this.orderTableId = orderTableId;
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
    @Column(name = "order_number")
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column(name = "food_status")
    public int getFoodStatus() {
        return foodStatus;
    }

    public void setFoodStatus(int foodStatus) {
        this.foodStatus = foodStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderTableEntity that = (OrderTableEntity) o;
        return orderId == that.orderId &&
                orderNumber == that.orderNumber &&
                foodStatus == that.foodStatus &&
                Objects.equals(whoOrder, that.whoOrder) &&
                Objects.equals(orderTableId, that.orderTableId) &&
                Objects.equals(memuId, that.memuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, whoOrder, orderTableId, memuId, orderNumber, foodStatus);
    }
}
