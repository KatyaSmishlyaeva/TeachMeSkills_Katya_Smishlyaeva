package com.teachmeskills.homework5;

public class CivilPlane extends AirTransport {

    private int numberPassenger;
    private boolean isBusinessClass;

    public CivilPlane(String brand, int maxSpeed, int weight, int power, double wingspan, int minRunway, int numberPassenger, boolean isBusinessClass) {
        super(brand, maxSpeed, weight, power, wingspan, minRunway);
        this.numberPassenger = numberPassenger;
        this.isBusinessClass = isBusinessClass;
    }

    @Override
    public String printInformation() {
        return super.printInformation() +
                ", количество пассажиров = " + numberPassenger +
                ", наличие бизнес класса = " + isBusinessClass;
    }

    public void isEmptyPlane(int passenger) {
        if (numberPassenger >= passenger) {
            System.out.printf("На посадке пассажиров: %d. Все пассажиры могу занять свои места.", passenger);
            numberPassenger -= passenger;
        } else {
            System.out.printf("На посадке пассажиров: %d. Вам нужен самолет побольше. В салоне свободных мест: %d", passenger, numberPassenger);
        }
        System.out.println();
    }
}
