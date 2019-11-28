public abstract class Car {

    private String _Color;

    public Car(String color) {
        _Color = color;
    }

    public abstract void startEngine();
    public abstract void revEngine();
    public abstract void stopEngine();

    public void wash() {
    }

}
