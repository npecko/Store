public class Cashier {
    private int id;
    private String name;
    private boolean b = false;
    Cashier(int id, String name){
        this.id = id;
        this.name = name;
    }
    public void setBusy(boolean b){
        this.b = b;
    }
    public boolean isBusy(){
        return b;
    }
    @Override
    public String toString() {
        return "Cashier id: " + id + ", Name: " + name;
    }
}
