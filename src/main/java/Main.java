import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String[] nameSplit(String str) {
        String[] nameArray;
        nameArray = str.split(",");
        return nameArray;
    }
    public static boolean nameCheck(String[] names) {
        for(int i = 0; i < names.length; i++) {
            if(names[i].length() <= 5 && names[i].length() > 0)
                return false;
        }
        return true;
    }
    public static int maxPositionIndex(Car[] cars) {
        int maxIndex = cars[0].getPosition();
        for(int i = 0; i < cars.length; i++) {
            if(maxIndex <= cars[i].getPosition())
                maxIndex = i;
        }
        return maxIndex;
    }

    public static String winner(Car[] cars, int max) {
        String winCar = "";
        if(max == 0) {
            winCar = cars[max].getName() + "가 최종 우승했습니다";
            return winCar;
        }
        for(int i = 0; i < max; i++) {
            if(cars[max].getPosition() == cars[i].getPosition()) {
                winCar += cars[i].getName() + ", ";
            }
        }
        winCar += cars[max].getName() + "가 최종 우승했습니다";
        return winCar;
    }

    public static void main(String[] args) {
        String[] name;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String names = scanner.nextLine();
            name = nameSplit(names);
        } while(nameCheck(name));

        Car[] cars = new Car[name.length];
        for(int i = 0; i < name.length; i++) {
            cars[i] = new Car(name[i]);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int count = scanner.nextInt();

        System.out.println("실행 결과");
        CarThread carThread = new CarThread();
        for(int i = 0; i < count; i++) {
            carThread.run(cars);
        }
        int max = maxPositionIndex(cars);
        System.out.println(winner(cars, max));
    }
}
