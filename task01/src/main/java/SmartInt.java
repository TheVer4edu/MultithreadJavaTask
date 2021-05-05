public class SmartInt {

    private int value;

    public SmartInt(int value) {
        this.value = value;
    }

    public synchronized int getValue() {
        return value;
    }

    public synchronized int incrementValue() {
        return value++;
    }
}
