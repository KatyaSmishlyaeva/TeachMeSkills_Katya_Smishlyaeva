package com.teachmeskills.homework5;

public class TransportRunner {

    public static void main(String[] args) {
        PassengerTransport car = new PassengerTransport("BMW", 250, 2055, 407, 4, 10.9, "кроссовер", 5);
        System.out.println(car.printInformation());
        car.getDistance(1.5);

        CargoTransport truck = new CargoTransport("МАЗ", 85, 6850, 330, 6, 23.5, 7.5);
        System.out.println(truck.printInformation());
        truck.isEmpty(1.8);
        truck.isEmpty(7.0);
        System.out.println();

        CivilPlane boing747 = new CivilPlane("Boing-747", 988, 178800, 110000, 64.4, 1800, 524, false);
        System.out.println(boing747.printInformation());
        boing747.isEmptyPlane(78);
        boing747.isEmptyPlane(523);
        System.out.println();

        WarPlane warPlane = new WarPlane("ЯК-130", 1050, 4600, 3600, 9.84, 610, true, 2);
        System.out.println(warPlane.printInformation());
        warPlane.shot();
    }
}
