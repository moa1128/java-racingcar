//자동차 이름, 위치, 자동차가 이동 했는지 안 했는지 등
public class Car {
    private final String name;
    private int position = 0;
    private final int MIN_GO_NUM = 4;
    private final int START_POINT = 0;

    public Car(String name) {
        this.name = name;
    }
    public String getName() { return name; }
    public int getPosition() {
        return position;
    }
    public void stopAndGo(int num) {
        if(num >= MIN_GO_NUM || position == START_POINT)  position++;
    }
    public void printCar() {
        System.out.print(name + ":");
        for(int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
