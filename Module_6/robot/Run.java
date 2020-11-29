package com.teachmeskills.homework6.robot;

import com.teachmeskills.homework6.robot.hands.*;
import com.teachmeskills.homework6.robot.heads.*;
import com.teachmeskills.homework6.robot.legs.*;

/**
 * Создать по 3 реализации(Sony, Toshiba, Samsung) каждой запчасти(IHead, IHand, ILeg)
 * Класс SonyHead является примером реализацией головы от Sony.
 * Создайте 3 робота с разными комплектующими.
 * Например у робота голова и нога от Sony а, рука от Samsung.
 * У всех роботов вызовите метод action.
 * Среди 3-х роботов найдите самого дорогого.
 */

public class Run {
    public static void main(String[] args) {
        Robot robot1 = new Robot(new SamsungHead(100), new SonyHand(78), new ToshibaLeg(37));
        robot1.setName("Robot1");
        Robot robot2 = new Robot(new SonyHead(89), new ToshibaHand(67), new SamsungLeg(46));
        robot2.setName("Robot2");
        Robot robot3 = new Robot(new ToshibaHead(120), new SonyHand(78), new SamsungLeg(46));
        robot3.setName("Robot3");

        allAction(robot1, robot2, robot3);
        mostExpensiveRobot(robot1, robot2, robot3);
    }

    public static void allAction(Robot... robots) {
        for (Robot robot : robots) {
            System.out.println(robot.getName() + ":");
            robot.action();
            System.out.println();
        }
    }

    public static void mostExpensiveRobot(Robot... robots) {
        int mostPrice = 0;
        String nameExpensiveRobot = "";
        for (Robot robot : robots) {
            if (robot.getPrice() > mostPrice) {
                mostPrice = robot.getPrice();
                nameExpensiveRobot = robot.getName();
            }
        }
        System.out.println("Самый дорогой робот - " + nameExpensiveRobot + ". Цена: " + mostPrice);
    }
}
