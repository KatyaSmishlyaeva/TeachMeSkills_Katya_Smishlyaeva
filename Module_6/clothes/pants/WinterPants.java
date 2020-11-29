package com.teachmeskills.homework6.clothes.pants;

public class WinterPants implements Pants{

    @Override
    public void putOn() {
        System.out.println("put on winter pants.");
    }

    @Override
    public void takeOff() {
        System.out.println("take off winter pants.");
    }
}
