package com.teachmeskills.homework6.clothes.shoes;

public class SpringShoes implements Shoes{

    @Override
    public void putOn() {
        System.out.println("put on spring shoes.");
    }

    @Override
    public void takeOff() {
        System.out.println("take off spring shoes.");
    }
}
