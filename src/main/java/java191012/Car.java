package java191012;

public class Car {
    private final String name;
    private int position = 0;
    private final int MAX_NAME_LENGTH = 5;
    private static final int MIN_GO_NUM = 4;
    private final int START_POINT = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randNum) {
        if (randNum >= MIN_GO_NUM || position == START_POINT)
            position++;
    }
}
