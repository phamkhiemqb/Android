package pk.pklovestar.baitaptonghop.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfo {
    @SerializedName("AmCode")
    @Expose
    public String amCode;
    @SerializedName("Email")
    @Expose
    public String email;
    @SerializedName("Fullname")
    @Expose
    public String fullname;
    @SerializedName("GroupID")
    @Expose
    public Integer groupID;
    @SerializedName("IsGroupRoot")
    @Expose
    public Integer isGroupRoot;
    @SerializedName("IsNewTenant")
    @Expose
    public Integer isNewTenant;
    @SerializedName("IsSupper")
    @Expose
    public Integer isSupper;
    @SerializedName("ManagementId")
    @Expose
    public Integer managementId;
    @SerializedName("ParentId")
    @Expose
    public Integer parentId;
    @SerializedName("TenantId")
    @Expose
    public Integer tenantId;
    @SerializedName("TimeZone")
    @Expose
    public String timeZone;
    @SerializedName("Type")
    @Expose
    public Integer type;
    @SerializedName("UserID")
    @Expose
    public Integer userID;
    @SerializedName("UserPhoneNumber")
    @Expose
    public String userPhoneNumber;
    @SerializedName("UserType")
    @Expose
    public Integer userType;
    @SerializedName("Username")
    @Expose
    public String username;
    @SerializedName("isNew")
    @Expose
    public Integer isNew;

    public UserInfo() {
    }

    public UserInfo(String amCode, String email, String fullname, Integer groupID, Integer isGroupRoot, Integer isNewTenant, Integer isSupper, Integer managementId, Integer parentId, Integer tenantId, String timeZone, Integer type, Integer userID, String userPhoneNumber, Integer userType, String username, Integer isNew) {
        this.amCode = amCode;
        this.email = email;
        this.fullname = fullname;
        this.groupID = groupID;
        this.isGroupRoot = isGroupRoot;
        this.isNewTenant = isNewTenant;
        this.isSupper = isSupper;
        this.managementId = managementId;
        this.parentId = parentId;
        this.tenantId = tenantId;
        this.timeZone = timeZone;
        this.type = type;
        this.userID = userID;
        this.userPhoneNumber = userPhoneNumber;
        this.userType = userType;
        this.username = username;
        this.isNew = isNew;
    }

    public String getAmCode() {
        return amCode;
    }

    public void setAmCode(String amCode) {
        this.amCode = amCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public Integer getIsGroupRoot() {
        return isGroupRoot;
    }

    public void setIsGroupRoot(Integer isGroupRoot) {
        this.isGroupRoot = isGroupRoot;
    }

    public Integer getIsNewTenant() {
        return isNewTenant;
    }

    public void setIsNewTenant(Integer isNewTenant) {
        this.isNewTenant = isNewTenant;
    }

    public Integer getIsSupper() {
        return isSupper;
    }

    public void setIsSupper(Integer isSupper) {
        this.isSupper = isSupper;
    }

    public Integer getManagementId() {
        return managementId;
    }

    public void setManagementId(Integer managementId) {
        this.managementId = managementId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "amCode='" + amCode + '\'' +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", groupID=" + groupID +
                ", isGroupRoot=" + isGroupRoot +
                ", isNewTenant=" + isNewTenant +
                ", isSupper=" + isSupper +
                ", managementId=" + managementId +
                ", parentId=" + parentId +
                ", tenantId=" + tenantId +
                ", timeZone='" + timeZone + '\'' +
                ", type=" + type +
                ", userID=" + userID +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userType=" + userType +
                ", username='" + username + '\'' +
                ", isNew=" + isNew +
                '}';
    }
}
