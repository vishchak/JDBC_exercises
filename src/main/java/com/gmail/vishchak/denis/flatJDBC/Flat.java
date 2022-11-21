package com.gmail.vishchak.denis.flatJDBC;

public class Flat {
    private String district;
    private Double area;
    private Integer roomsTotal;
    private Long price;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getRoomsTotal() {
        return roomsTotal;
    }

    public void setRoomsTotal(Integer roomsTotal) {
        this.roomsTotal = roomsTotal;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
