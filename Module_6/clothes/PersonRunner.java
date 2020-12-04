package com.teachmeskills.homework6.clothes;

import com.teachmeskills.homework6.clothes.jackets.*;
import com.teachmeskills.homework6.clothes.pants.*;
import com.teachmeskills.homework6.clothes.shoes.*;

public class PersonRunner {

    public static void main(String[] args) {
        Person man = new Person("Ivan", new WinterJacket(), new WinterPants(), new WinterShoes());
        Person woman = new Person("Olga", new SpringJacket(), new SpringPants(), new SpringShoes());
        Person child = new Person("Peter", new SummerJacket(), new AutumnPants(), new AutumnShoes());

        askIsDressed(man);
        askIsDressed(man);
        man.askSeason();

        askIsDressed(woman);
        woman.askSeason();

        askIsDressed(child);
        child.askSeason();
    }

    public static void askIsDressed(Person person) {
        if (!person.isDressed()) {
            person.putOn();
            person.setDressed(true);
        } else {
            person.takeOff();
            person.setDressed(false);
        }
    }
}
