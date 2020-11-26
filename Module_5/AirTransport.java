package com.teachmeskills.homework5;

public abstract class AirTransport extends Transport {

    private double wingspan;
    private int minRunway;

    public AirTransport(String brand, int maxSpeed, int weight, int power, double wingspan, int minRunway) {
        super(brand, maxSpeed, weight, power);
        this.wingspan = wingspan;
        this.minRunway = minRunway;
    }

    @Override
    public String printInformation() {
        return super.printInformation() +
                "размах крыльев = " + wingspan +
                " м, минимальная длина взлётно-посадочной полосы = " + minRunway + " м";
    }
}
