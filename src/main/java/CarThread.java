public class CarThread extends Thread {
    public static int randNum() {
        return (int)(Math.random() * 100) % 10;
    }
    public void run(Car[] car) {
        for (int i = 0; i < car.length; i++) {
            car[i].printCar();
            car[i].stopAndGo(randNum());
        }
        System.out.println();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
