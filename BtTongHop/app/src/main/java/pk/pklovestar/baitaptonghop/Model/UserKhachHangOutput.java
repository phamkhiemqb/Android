package pk.pklovestar.baitaptonghop.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserKhachHangOutput {
    @SerializedName("errorCode")
    @Expose
    public Integer errorCode;
    @SerializedName("ForceUpdate")
    @Expose
    public Boolean forceUpdate;
    @SerializedName("MapKeyName")
    @Expose
    public String mapKeyName;
    @SerializedName("MapKeyPass")
    @Expose
    public String mapKeyPass;
    @SerializedName("Message")
    @Expose
    public String message;
    @SerializedName("ResultCode")
    @Expose
    public Integer resultCode;
    @SerializedName("SessionID")
    @Expose
    public String sessionID;
    @SerializedName("UpdateAvailable")
    @Expose
    public Boolean updateAvailable;
    @SerializedName("Url")
    @Expose
    public Object url;
    @SerializedName("UserInfo")
    @Expose
    public UserInfo userInfo;
    @SerializedName("token")
    @Expose
    public String token;
    public UserKhachHangOutput() {
    }

    public UserKhachHangOutput(Integer errorCode, Boolean forceUpdate, String mapKeyName, String mapKeyPass, String message, Integer resultCode, String sessionID, Boolean updateAvailable, Object url, UserInfo userInfo, String token) {
        this.errorCode = errorCode;
        this.forceUpdate = forceUpdate;
        this.mapKeyName = mapKeyName;
        this.mapKeyPass = mapKeyPass;
        this.message = message;
        this.resultCode = resultCode;
        this.sessionID = sessionID;
        this.updateAvailable = updateAvailable;
        this.url = url;
        this.userInfo = userInfo;
        this.token = token;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Boolean getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(Boolean forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public String getMapKeyName() {
        return mapKeyName;
    }

    public void setMapKeyName(String mapKeyName) {
        this.mapKeyName = mapKeyName;
    }

    public String getMapKeyPass() {
        return mapKeyPass;
    }

    public void setMapKeyPass(String mapKeyPass) {
        this.mapKeyPass = mapKeyPass;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public Boolean getUpdateAvailable() {
        return updateAvailable;
    }

    public void setUpdateAvailable(Boolean updateAvailable) {
        this.updateAvailable = updateAvailable;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserKhachHangOutput{" +
                "errorCode=" + errorCode +
                ", forceUpdate=" + forceUpdate +
                ", mapKeyName='" + mapKeyName + '\'' +
                ", mapKeyPass='" + mapKeyPass + '\'' +
                ", message='" + message + '\'' +
                ", resultCode=" + resultCode +
                ", sessionID='" + sessionID + '\'' +
                ", updateAvailable=" + updateAvailable +
                ", url=" + url +
                ", userInfo=" + userInfo +
                ", token='" + token + '\'' +
                '}';
    }
}


