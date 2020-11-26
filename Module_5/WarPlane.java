package com.teachmeskills.homework5;

public class WarPlane extends AirTransport {

    private boolean isEjectionSystem;
    private int numberRocket;

    public WarPlane(String brand, int maxSpeed, int weight, int power, double wingspan, int minRunway, boolean isEjectionSystem, int numberRocket) {
        super(brand, maxSpeed, weight, power, wingspan, minRunway);
        this.isEjectionSystem = isEjectionSystem;
        this.numberRocket = numberRocket;
    }

    @Override
    public String printInformation() {
        return super.printInformation() +
                ", наличие системы катапультирования = " + isEjectionSystem +
                ", количество ракет на борту = " + numberRocket;
    }

    public void shot() {
        while (numberRocket > 0) {
            System.out.println("Ракета пошла...");
            numberRocket--;
        }
        System.out.println("Боеприпасы отсутствуют. Катапультируемся!");
        ejection();
    }

    private void ejection() {
        if (isEjectionSystem) {
            System.out.println("Катапультирование прошло успешно!");
        } else {
            System.out.println("У вас нет такой системы!");
        }
    }
}
