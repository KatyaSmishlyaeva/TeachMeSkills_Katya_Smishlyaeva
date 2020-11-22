package com.teachmeskills.homework5;

public class PassengerTransport extends GroundTransport {

    private String bodyType;
    private int numberPassenger;

    public PassengerTransport(String brand, int maxSpeed, int weight, int power, int numberWheels, double fuelConsumption, String bodyType, int numberPassenger) {
        super(brand, maxSpeed, weight, power, numberWheels, fuelConsumption);
        this.bodyType = bodyType;
        this.numberPassenger = numberPassenger;
    }

    @Override
    public String printInformation() {
        return super.printInformation() +
                ", тип кузова = " + bodyType + ", количество пассажиров = " + numberPassenger + ".";
    }

    public void getDistance(double time) {
        double distance = getMaxSpeed() * time;
        double fuelConsumption = calculationFuelConsumption(distance);
        System.out.printf("За время %.2f ч, " +
                        "автомобиль %s двигаясь с максимальной скоростью %d км/ч" +
                        " проедет %.2f км и израсходует %.3f литров топлива. %n",
                time, getBrand(), getMaxSpeed(), distance, fuelConsumption);
        System.out.println();
    }

    private double calculationFuelConsumption(double distance) {
        return getFuelConsumption() * distance / 100;
    }
}
