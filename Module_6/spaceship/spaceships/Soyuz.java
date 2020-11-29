package com.teachmeskills.homework6.spaceship.spaceships;

public class Soyuz implements IStart{

    @Override
    public boolean isSystemReady() {
        int randomValue = random.nextInt(21);
        if (randomValue % 2 == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void engineStart() {
        System.out.println("Двигатели Soyuz запущены.");
    }

    @Override
    public void start() {
        System.out.println("Старт Soyuz.");
    }
}
