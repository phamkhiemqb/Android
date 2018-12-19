package p.pklovestar.bitp_salong.Salon;

import java.util.List;

public class TTSalon {
    public String id;
    public String userSalon;
    public String nameSalon;
    public String phone;
    public String address;
    public String city;
    public String description;
    public String openingHours;
    public String locationLat;
    public String locationLon;
    public List<String> imageSalon = null;

    public TTSalon() {
    }

    public TTSalon(String id, String userSalon, String nameSalon, String phone, String address, String city, String description, String openingHours, String locationLat, String locationLon, List<String> imageSalon) {
        this.id = id;
        this.userSalon = userSalon;
        this.nameSalon = nameSalon;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.description = description;
        this.openingHours = openingHours;
        this.locationLat = locationLat;
        this.locationLon = locationLon;
        this.imageSalon = imageSalon;
    }

    public TTSalon(String userSalon, String nameSalon, String phone, String address, String city, String description, String openingHours, String locationLat, String locationLon, List<String> imageSalon) {
        this.userSalon = userSalon;
        this.nameSalon = nameSalon;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.description = description;
        this.openingHours = openingHours;
        this.locationLat = locationLat;
        this.locationLon = locationLon;
        this.imageSalon = imageSalon;
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

    public List<String> getImageSalon() {
        return imageSalon;
    }

    public void setImageSalon(List<String> imageSalon) {
        this.imageSalon = imageSalon;
    }
}
