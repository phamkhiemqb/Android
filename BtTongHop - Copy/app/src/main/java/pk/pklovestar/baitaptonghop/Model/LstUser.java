package pk.pklovestar.baitaptonghop.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LstUser {
    @SerializedName("Email")
    @Expose
    public String email;
    @SerializedName("GroupName")
    @Expose
    public String groupName;
    @SerializedName("UserName")
    @Expose
    public String userName;
    @SerializedName("UserPhone")
    @Expose
    public String userPhone;

    public LstUser() {
    }

    public LstUser(String email, String groupName, String userName, String userPhone) {
        this.email = email;
        this.groupName = groupName;
        this.userName = userName;
        this.userPhone = userPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "LstUser{" +
                "email='" + email + '\'' +
                ", groupName='" + groupName + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }
}
