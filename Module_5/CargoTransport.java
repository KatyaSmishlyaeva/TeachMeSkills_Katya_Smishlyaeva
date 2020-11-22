package com.teachmeskills.homework5;

public class CargoTransport extends GroundTransport {

    private double carryingCapacity;

    public CargoTransport(String brand, int maxSpeed, int weight, int power, int numberWheels, double fuelConsumption, double carryingCapacity) {
        super(brand, maxSpeed, weight, power, numberWheels, fuelConsumption);
        this.carryingCapacity = carryingCapacity;
    }

    @Override
    public String printInformation() {
        return super.printInformation() +
                ", грузоподъемность = " + carryingCapacity + " т.";
    }

    public void isEmpty(double weightCargo) {
        if (carryingCapacity >= weightCargo) {
            System.out.printf("Загружаем %.2f т. Грузовик загружен!", weightCargo);
            carryingCapacity -= weightCargo;
        } else {
            System.out.printf("Загружаем %.2f т. Вам нужен грузовик побольше! Можно загрузить не более %.2f т.", weightCargo, carryingCapacity);
        }
        System.out.println();
    }
}
