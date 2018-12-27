package p.pklovestar.bitp_salong.Salon;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Service {
    @SerializedName("_id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("service_time")
    @Expose
    public Integer serviceTime;
    @SerializedName("clean_time")
    @Expose
    public Integer cleanTime;
    @SerializedName("price")
    @Expose
    public String price;
    @SerializedName("allow_excess")
    @Expose
    public Integer allowExcess;
    @SerializedName("type")
    @Expose
    public Integer type;
    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("is_dependent")
    @Expose
    public Integer isDependent;
    @SerializedName("additional_services_number")
    @Expose
    public String additionalServicesNumber;
    @SerializedName("created_at")
    @Expose
    public String createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Integer serviceTime) {
        this.serviceTime = serviceTime;
    }

    public Integer getCleanTime() {
        return cleanTime;
    }

    public void setCleanTime(Integer cleanTime) {
        this.cleanTime = cleanTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getAllowExcess() {
        return allowExcess;
    }

    public void setAllowExcess(Integer allowExcess) {
        this.allowExcess = allowExcess;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDependent() {
        return isDependent;
    }

    public void setIsDependent(Integer isDependent) {
        this.isDependent = isDependent;
    }

    public String getAdditionalServicesNumber() {
        return additionalServicesNumber;
    }

    public void setAdditionalServicesNumber(String additionalServicesNumber) {
        this.additionalServicesNumber = additionalServicesNumber;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", serviceTime=" + serviceTime +
                ", cleanTime=" + cleanTime +
                ", price='" + price + '\'' +
                ", allowExcess=" + allowExcess +
                ", type=" + type +
                ", status=" + status +
                ", isDependent=" + isDependent +
                ", additionalServicesNumber='" + additionalServicesNumber + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
