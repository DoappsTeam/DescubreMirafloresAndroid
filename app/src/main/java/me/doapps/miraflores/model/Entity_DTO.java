package me.doapps.miraflores.model;

import android.graphics.Bitmap;

/**
 * Created by jonathan on 17/05/2015.
 */
public class Entity_DTO {

    private String id, name, address, phone, email, webpage, urlLogo, urlBanner;
    private double latitude, longitide;
    private Bitmap bitmap;

    public Entity_DTO(String id, String name, String address, String phone, String email, String webpage, String urlLogo, String urlBanner, double latitude, double longitide) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.webpage = webpage;
        this.urlLogo = urlLogo;
        this.urlBanner = urlBanner;
        this.latitude = latitude;
        this.longitide = longitide;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getUrlBanner() {
        return urlBanner;
    }

    public void setUrlBanner(String urlBanner) {
        this.urlBanner = urlBanner;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitide() {
        return longitide;
    }

    public void setLongitide(double longitide) {
        this.longitide = longitide;
    }
}
