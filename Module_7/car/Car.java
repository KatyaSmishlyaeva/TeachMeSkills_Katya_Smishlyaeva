package com.teachmeskills.homework7.car;

import java.util.Random;

public class Car {
    private static Random random = new Random();
    private String brand;
    private int speed;
    private int price;

    public Car(String brand, int speed, int price) {
        this.brand = brand;
        this.speed = speed;
        this.price = price;
    }

    public Car(String brand) {
        this.brand = brand;
    }

    public Car() {
    }

    public void start() {
        int value = random();
        try {
            if (value % 2 != 0) {
                System.out.println("Автомобиль " + getBrand() + " завелся.");
            } else {
                throw new CarCanNotStartException("Автомобиль " + getBrand() + " не может завестись.");
            }
        } catch (CarCanNotStartException exception) {
            System.out.println(exception.getMessage());
            start();
        }
    }

    private int random() {
        int value = random.nextInt(21);
        System.out.println("Рандомное число: " + value);
        return value;
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
}
