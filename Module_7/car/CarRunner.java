package com.teachmeskills.homework7.car;

public class CarRunner {

    public static void main(String[] args) {
        Car car = new Car("BMW");
        car.start();

        Car car2 = new Car("Peugeot");
        car2.start();

        Car car3 = new Car("Mercedes");
        car3.start();
    }
}
