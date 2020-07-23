package Test_HIB;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "User_1", schema = "dbo", catalog = "Test_DataBase")
public class User1Entity {
    private int id;
    private String userName;
    private String userPw;
    private int userOrMaster;
    private Date date;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_pw")
    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    @Basic
    @Column(name = "UserOrMaster")
    public int getUserOrMaster() {
        return userOrMaster;
    }

    public void setUserOrMaster(int userOrMaster) {
        this.userOrMaster = userOrMaster;
    }

    @Basic
    @Column(name = "Date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User1Entity that = (User1Entity) o;
        return id == that.id &&
                userOrMaster == that.userOrMaster &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userPw, that.userPw) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userPw, userOrMaster, date);
    }
}
