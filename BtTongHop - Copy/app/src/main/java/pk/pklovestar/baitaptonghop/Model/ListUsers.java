package pk.pklovestar.baitaptonghop.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListUsers {
    @SerializedName("Count")
    @Expose
    public Integer count;
    @SerializedName("LstUsers")
    @Expose
    public List<LstUser> lstUsers = null;

    public ListUsers() {
    }

    public ListUsers(Integer count, List<LstUser> lstUsers) {
        this.count = count;
        this.lstUsers = lstUsers;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<LstUser> getLstUsers() {
        return lstUsers;
    }

    public void setLstUsers(List<LstUser> lstUsers) {
        this.lstUsers = lstUsers;
    }

    @Override
    public String toString() {
        return "ListUsers{" +
                "count=" + count +
                ", lstUsers=" + lstUsers +
                '}';
    }
}
