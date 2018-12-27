package p.pklovestar.bitp_salong.Salon;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TTSalon {
    @SerializedName("_id")
    @Expose
    public String id;
    @SerializedName("user_salon")
    @Expose
    public String userSalon;
    @SerializedName("name_salon")
    @Expose
    public String nameSalon;
    @SerializedName("phone")
    @Expose
    public String phone;
    @SerializedName("address")
    @Expose
    public String address;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("opening_hours")
    @Expose
    public String openingHours;
    @SerializedName("location_lat")
    @Expose
    public String locationLat;
    @SerializedName("location_lon")
    @Expose
    public String locationLon;
    @SerializedName("relationships")
    @Expose
    public Relationships relationships;
    @SerializedName("image_salon")
    @Expose
    public List<String> imageSalon = null;

    public TTSalon() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserSalon() {
        return userSalon;
    }

    public void setUserSalon(String userSalon) {
        this.userSalon = userSalon;
    }

    public String getNameSalon() {
        return nameSalon;
    }

    public void setNameSalon(String nameSalon) {
        this.nameSalon = nameSalon;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(String locationLat) {
        this.locationLat = locationLat;
    }

    public String getLocationLon() {
        return locationLon;
    }

    public void setLocationLon(String locationLon) {
        this.locationLon = locationLon;
    }

    public Relationships getRelationships() {
        return relationships;
    }

    public void setRelationships(Relationships relationships) {
        this.relationships = relationships;
    }

    public List<String> getImageSalon() {
        return imageSalon;
    }

    public void setImageSalon(List<String> imageSalon) {
        this.imageSalon = imageSalon;
    }

    @Override
    public String toString() {
        return "TTSalon{" +
                "id='" + id + '\'' +
                ", userSalon='" + userSalon + '\'' +
                ", nameSalon='" + nameSalon + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", openingHours='" + openingHours + '\'' +
                ", locationLat='" + locationLat + '\'' +
                ", locationLon='" + locationLon + '\'' +
<<<<<<< HEAD
=======
                ", relationships=" + relationships +
>>>>>>> 62eb0098467c1c1532c8fad8a25ed5135a90635e
                ", imageSalon=" + imageSalon +
                '}';
    }
}


