package java191012;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    private final List<Car> cars = new ArrayList<>();

    public void addCar(String[] name) {
        for(int i = 0; i < name.length; i++) {
            cars.add(new Car(name[i]));
        }
    }

    public List<String> nameSplit(List<String> names) {
        String.join(",", names);
        return names;
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

}
