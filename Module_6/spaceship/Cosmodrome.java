package com.teachmeskills.homework6.spaceship;

import com.teachmeskills.homework6.spaceship.spaceships.IStart;

/**
 * Метод запуск принимает объект типа IStart.
 * В методе первым делом осуществляем предстартовую проверку переданного
 * объекта,
 * если она провалилась(метод вернул false) выводим сообщение «Предстартовая
 * проверка
 * провалена». Если проверка прошла успешно, то производим запуск
 * двигателей(вызываем
 * метод запуска двигателя). После этого производиться обратный отсчет (10 .....
 * 1). После
 * обратного отсчета вызываем метод старт переданного объекта.
 */

public class Cosmodrome {
    private IStart iStart;

    public Cosmodrome(IStart iStart) {
        this.iStart = iStart;
    }

    void launching() {
        if (!iStart.isSystemReady()) {
            System.out.println("Предстартовая проверка провалена");
        } else {
            iStart.engineStart();
            countdown();
            iStart.start();
        }
        System.out.println();
    }

    void countdown() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
    }
}
