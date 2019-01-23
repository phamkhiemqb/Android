package pk.pklovestar.baitaptonghop.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserKhachHangInput {
    @SerializedName("Username")
    @Expose
    public String username;
    @SerializedName("Password")
    @Expose
    public String password;
    @SerializedName("TypeClient")
    @Expose
    public Integer typeClient;
    @SerializedName("ClientVersion")
    @Expose
    public String clientVersion;


    public UserKhachHangInput() {

    }

    public UserKhachHangInput(String username, String password, Integer typeClient, String clientVersion) {
        this.username = username;
        this.password = password;
        this.typeClient = typeClient;
        this.clientVersion = clientVersion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(Integer typeClient) {
        this.typeClient = typeClient;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    @Override
    public String toString() {
        return "UserKhachHangInput{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", typeClient=" + typeClient +
                ", clientVersion='" + clientVersion + '\'' +
                '}';
    }
}
