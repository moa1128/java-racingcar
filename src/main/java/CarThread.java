import java.util.ArrayList;
import java.util.List;

public class CarThread extends Thread {
    List<Car> cars = new ArrayList<>();


    public void setCars(List<Car> cars) { this.cars = cars; }
    public void run() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).stopAndGo((int)(Math.random() * 10));
            cars.get(i).printCar();
        }
        System.out.println();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
