public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) { this.name = name; }
    public String getName() { return name; }
    public int getPosition() {
        return position;
    }
    //전진하거나 멈추는 메소드, 처음은 무조건 한 칸(-) 가야한다고 생각했어요
    public void stopAndGo(int num) { if(num >= 4 || position == 0)  position++; }
    public void printCar() {
        System.out.print(name + ":");
        for(int i = 0; i < position; i++)
             System.out.print("-");
        System.out.println();
    }
}
