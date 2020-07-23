package Test_HIB;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Table_Kind", schema = "dbo", catalog = "Test_DataBase")
public class TableKindEntity {
    private int tableId;
    private String tableName;
    private int tableNumber;

    @Id
    @Column(name = "Table_ID")
    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    @Basic
    @Column(name = "Table_Name")
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Basic
    @Column(name = "Table_number")
    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableKindEntity that = (TableKindEntity) o;
        return tableId == that.tableId &&
                tableNumber == that.tableNumber &&
                Objects.equals(tableName, that.tableName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableId, tableName, tableNumber);
    }

    public String getTableid_name() {
        return tableid_name;
    }

    public void setTableid_name(String tableid_name) {
        this.tableid_name = tableid_name;
    }

    String tableid_name;
}
