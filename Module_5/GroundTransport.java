package com.teachmeskills.homework5;

public abstract class GroundTransport extends Transport {

    private int numberWheels;
    private double fuelConsumption;

    public GroundTransport(String brand, int maxSpeed, int weight, int power, int numberWheels, double fuelConsumption) {
        super(brand, maxSpeed, weight, power);
        this.numberWheels = numberWheels;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String printInformation() {
        return super.printInformation() +
                "количество колес = " + numberWheels +
                ", расход топлива = " + fuelConsumption + " л/100км";
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }
}
