package com.teachmeskills.homework6.spaceship;

import com.teachmeskills.homework6.spaceship.spaceships.*;

public class CosmosRunner {

    public static void main(String[] args) {
        Cosmodrome shatl = new Cosmodrome(new Shatl());
        Cosmodrome soyuz = new Cosmodrome(new Soyuz());
        Cosmodrome progress = new Cosmodrome(new Progress());
        Cosmodrome spaceX = new Cosmodrome(new SpaceX());

        getLaunching(shatl, soyuz, progress, spaceX);

    }

    public static void getLaunching(Cosmodrome... cosmodromes){
        for (Cosmodrome cosmodrome : cosmodromes) {
            cosmodrome.launching();
        }
    }
}
