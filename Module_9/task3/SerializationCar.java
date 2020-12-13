package com.teachmeskills.homework9.task3;

/**
 * Сериализовать объект Автомобиль(Марка, скорость, цена).
 * После сериализации произвести обратный процесс.
 */

import java.io.*;

public class SerializationCar {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("resources/car");
        Car bmw = new Car("BMW", 150, 15000);

        writeObject(file, bmw, "car.txt");

        Car saveCar = readObject("resources/car/car.txt");
        System.out.println(saveCar.toString());
    }

    public static void writeObject(File file, Car bmw, String fileNameTSave) throws IOException {
        if (!file.exists()) {
            file.mkdirs();
        }
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file.getPath()
                .concat("/").concat(fileNameTSave)))) {
            outputStream.writeObject(bmw);
        }
    }

    public static Car readObject(String filePath) throws IOException, ClassNotFoundException {
        Car car = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            car = (Car) inputStream.readObject();
        }
        return car;
    }
}
