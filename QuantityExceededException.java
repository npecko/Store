public class QuantityExceededException extends Exception {
    private String name;
    private int available;
    private int requested;
    public QuantityExceededException(String name, int available, int requested) {
        this.name = name;
        this.available = available;
        this.requested = requested;
    }
    public int getAvailable(){
        return available;
    }
    public int getRequested(){
        return requested;
    }
    @Override
    public String toString() {
        return "QuantityExceededException{" + name + ": available=" + available + ", requested=" + requested + '}';
    }
}
