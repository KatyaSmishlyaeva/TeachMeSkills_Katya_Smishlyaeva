package com.teachmeskills.homework9.task4;

public class CarJson {

    private String brand;
    private int speed;
    private int price;

    public CarJson(String brand, int speed, int price) {
        this.brand = brand;
        this.speed = speed;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarJson{" +
                "brand='" + brand + '\'' +
                ", speed=" + speed +
                ", price=" + price +
                '}';
    }
}
