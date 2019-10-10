import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//자동차 목록, 한 라운드의 자동차 위치 등
public class RacingGame {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Car> cars = new ArrayList<>();

    public String[] nameSplit(String str) {
        String[] nameArray;
        nameArray = str.split(",");
        return nameArray;
    }
    public boolean nameCheck(String[] names) {
        for(int i = 0; i < names.length; i++) {
            if(names[i].length() > 5 || names[i].length() <= 0) {
                System.out.println((i + 1) + "번째 이름을 5자리 이하로 입력하세요");
                return true;
            }
        }
        return false;
    }
    public int maxPositionIndex() {
        int maxIndex = 0;
        for(int i = 0; i < cars.size(); i++) {
            if(cars.get(maxIndex).getPosition() <= cars.get(i).getPosition()) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public String winnerPrint(int max) {
        String winCar = "";
        for(int i = 0; i < max; i++) {
            if(cars.get(max).getPosition() == cars.get(i).getPosition()) {
                winCar += cars.get(i).getName() + ", ";
            }
        }
        winCar += cars.get(max).getName() + "가 최종 우승했습니다";
        return winCar;
    }
    public void addCarList(String[] name) {
        for(int i = 0; i < name.length; i++) {
            cars.add(new Car(name[i]));
        }
    }
    public void playGame() {
        String[] userNames;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String names = scanner.nextLine();
            userNames = nameSplit(names);
        } while(nameCheck(userNames));

        addCarList(userNames);

        System.out.println("시도할 회수는 몇회인가요?");
        int count = scanner.nextInt();

        System.out.println("실행 결과");
        CarThread carThread = new CarThread(cars);
        for(int i = 0; i < count; i++) {
            carThread.run();
        }

        int max = maxPositionIndex();
        System.out.println(winnerPrint(max));
    }
}
