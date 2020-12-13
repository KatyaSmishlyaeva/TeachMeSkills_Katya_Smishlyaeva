package com.teachmeskills.homework9.task4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.*;

/**
 * Создать класс, который будет уметь создавать
 * записывать в  json файл отдельный объект автомобиль,
 * либо массив автомобилей, а также десериализовать
 * автомобиль либо массив автомобилей из json файла.
 */

public class CarRunner {

    public static void main(String[] args) {
        CarJson car = new CarJson("BMW", 150, 15000);
        CarJson car2 = new CarJson("PEUGEOT", 120, 10000);

        writeJson("resources/car1.json", car, car2);
        readJson("resources/car4.json");
    }

    public static void writeJson(String filePath, CarJson... cars) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(gson.toJson(cars));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readJson(String filePath) {
        try {
            JsonParser parser = new JsonParser();
            JsonArray saveCar = (JsonArray) parser.parse(new FileReader(filePath));
            String readCar = saveCar.toString();
            System.out.println(readCar);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}
