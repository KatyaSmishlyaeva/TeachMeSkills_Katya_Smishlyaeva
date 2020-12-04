package com.teachmeskills.homework6.clothes.pants;

public class SpringPants implements Pants{

    @Override
    public void putOn() {
        System.out.println("put on spring pants.");
    }

    @Override
    public void takeOff() {
        System.out.println("take off spring pants.");
    }
}
