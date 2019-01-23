package pk.pklovestar.baitaptonghop.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ThongTinKhachHang implements Serializable {
    @SerializedName("errorCode")
    @Expose
    public Integer errorCode;
    @SerializedName("ListUsers")
    @Expose
    public ListUsers listUsers;

    public ThongTinKhachHang() {
    }

    public ThongTinKhachHang(Integer errorCode, ListUsers listUsers) {
        this.errorCode = errorCode;
        this.listUsers = listUsers;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public ListUsers getListUsers() {
        return listUsers;
    }

    public void setListUsers(ListUsers listUsers) {
        this.listUsers = listUsers;
    }

    @Override
    public String toString() {
        return "ThongTinKhachHang{" +
                "errorCode=" + errorCode +
                ", listUsers=" + listUsers +
                '}';
    }
}
