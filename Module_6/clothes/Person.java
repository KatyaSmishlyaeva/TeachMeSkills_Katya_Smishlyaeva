package com.teachmeskills.homework6.clothes;

import com.teachmeskills.homework6.clothes.jackets.*;
import com.teachmeskills.homework6.clothes.pants.*;
import com.teachmeskills.homework6.clothes.shoes.*;

public class Person implements IClothes {
    private Jacket jacket;
    private Pants pants;
    private Shoes shoes;
    private String name;
    private static boolean isDressed;

    public Person(String name, Jacket jacket, Pants pants, Shoes shoes) {
        this.name = name;
        this.jacket = jacket;
        this.pants = pants;
        this.shoes = shoes;
    }

    @Override
    public void putOn() {
        System.out.print(getName() + " ");
        jacket.putOn();
        pants.putOn();
        shoes.putOn();
        System.out.println();
    }

    @Override
    public void takeOff() {
        System.out.print(getName() + " ");
        jacket.takeOff();
        pants.takeOff();
        shoes.takeOff();
        System.out.println();
    }

    public void askSeason() {
        if (jacket instanceof WinterJacket && pants instanceof WinterPants && shoes instanceof WinterShoes) {
            System.out.println("Now is " + Season.WINTER);
        } else if (jacket instanceof SpringJacket && pants instanceof SpringPants && shoes instanceof SpringShoes) {
            System.out.println("Now is " + Season.SPRING);
        } else if (jacket instanceof SummerJacket && pants instanceof SummerPants && shoes instanceof SummerShoes) {
            System.out.println("Now is " + Season.SUMMER);
        } else if (jacket instanceof AutumnJacket && pants instanceof AutumnPants && shoes instanceof AutumnShoes) {
            System.out.println("Now is " + Season.AUTUMN);
        } else {
            System.out.println("It is impossible to determine the season.");
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public boolean isDressed() {
        return isDressed;
    }

    public void setDressed(boolean dressed) {
        isDressed = dressed;
    }
}
