package com.teachmeskills.homework6.spaceship.spaceships;

public class Shatl  implements IStart {

    @Override
    public boolean isSystemReady() {
        int randomValue = random.nextInt(11);
        if (randomValue > 3) {
            return true;
        }
        return false;
    }

    @Override
    public void engineStart() {
        System.out.println("Двигатели Shatl запущены.");
    }

    @Override
    public void start() {
        System.out.println("Старт Shatl.");
    }
}
