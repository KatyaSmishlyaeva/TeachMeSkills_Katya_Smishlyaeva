package com.teachmeskills.homework6.spaceship.spaceships;

public class Progress implements IStart {

    @Override
    public boolean isSystemReady() {
        int randomValue = random.nextInt(100) - 50;
        if (randomValue > 0 && randomValue % 2 != 0) {
            return true;
        }
        return false;
    }

    @Override
    public void engineStart() {
        System.out.println("Двигатели Progress запущены.");
    }

    @Override
    public void start() {
        System.out.println("Старт Progress.");
    }
}
