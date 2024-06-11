package org.web.entity;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer theaterId;
    private String theaterName;
    private String area;
    private String address;
    private String tel;
    private byte[] image;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Screen> screens;

    public Theater() {
    }

    public Theater(Integer theaterId, String theaterName, String area, String address, String tel, byte[] image, List<Screen> screens) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.area = area;
        this.address = address;
        this.tel = tel;
        this.image = image;
        this.screens = screens;
    }

    public Integer getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Integer theaterId) {
        this.theaterId = theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    @Override
    public String toString() {
        return "Theater{" +
                "theaterId=" + theaterId +
                ", theaterName='" + theaterName + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", image=" + Arrays.toString(image) +
                ", screens=" + screens +
                '}';
    }
}
