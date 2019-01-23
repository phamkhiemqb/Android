package pk.pklovestar.baitaptonghop.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TTKhachHangInput {
    @SerializedName("token")
    @Expose
    public String token;
    @SerializedName("Username")
    @Expose
    public String username;
    @SerializedName("Page")
    @Expose
    public Integer page;

    public TTKhachHangInput() {
    }

    public TTKhachHangInput(String token, String username, Integer page) {
        this.token = token;
        this.username = username;
        this.page = page;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "TTKhachHangInput{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", page=" + page +
                '}';
    }
}
