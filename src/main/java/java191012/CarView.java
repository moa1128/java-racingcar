package java191012;

import java.util.Scanner;

public class CarView {
    private final Scanner scanner = new Scanner(System.in);
    private final Car car;

    public CarView(Car car) {
        this.car = car;
    }

    public void printCar() {
        System.out.print(car.getName() + ":");
        for(int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
