import java.util.ArrayList;
import java.util.List;
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
        System.out.println("이름은 5자리 이하로 입력하세요");
        return true;
    }
    public static int maxPositionIndex(List<Car> cars) {
        int maxIndex = 0;
        for(int i = 0; i < cars.size(); i++) {
            if(cars.get(maxIndex).getPosition() <= cars.get(i).getPosition())
                maxIndex = i;
        }
        return maxIndex;
    }
    public static String winner(List<Car> cars, int max) {
        String winCar = "";
        for(int i = 0; i < max; i++) {
            if(cars.get(max).getPosition() == cars.get(i).getPosition()) {
                winCar += cars.get(i).getName() + ", ";
            }
        }
        winCar += cars.get(max).getName() + "가 최종 우승했습니다";
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

        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < name.length; i++) {
            cars.add(new Car(name[i]));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int count = scanner.nextInt();

        System.out.println("실행 결과");
        CarThread carThread = new CarThread();
        carThread.setCars(cars);
        for(int i = 0; i < count; i++) {
            carThread.run();
        }

        int max = maxPositionIndex(cars);
        System.out.println(winner(cars, max));
    }
}
