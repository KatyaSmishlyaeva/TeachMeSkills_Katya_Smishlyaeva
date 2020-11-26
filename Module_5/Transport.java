package com.teachmeskills.homework5;

public abstract class Transport {

    private int power;
    private int maxSpeed;
    private int weight;
    private String brand;
    private final static double CONSTANCE_KW = 0.74;

    public Transport(String brand, int maxSpeed, int weight, int power) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.power = power;
    }

    public String printInformation() {
        return "Характеристики: марка = " + brand +
                ", максимальная скорость = " + maxSpeed + " км/ч" +
                ", масса = " + weight + " кг" +
                ", мощность = " + power + " л.с., мощности в киловаттах = " + getPowerKilowatts(power) + " кВ, ";
    }

    private double getPowerKilowatts(int power) {
        return power * CONSTANCE_KW;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getBrand() {
        return brand;
    }
}
