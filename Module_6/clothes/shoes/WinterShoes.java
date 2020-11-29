package com.teachmeskills.homework6.clothes.shoes;

public class WinterShoes implements Shoes{

    @Override
    public void putOn() {
        System.out.println("put on winter shoes.");
    }

    @Override
    public void takeOff() {
        System.out.println("take off winter shoes.");
    }
}
