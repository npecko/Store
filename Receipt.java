import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.IOException;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.HashMap;

public class Receipt {
    private static int num = 0;
    private double total = 0;
    private Cashier c;
    private HashMap<Goods, Integer> g;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    String currentTime = dtf.format(now);

    Receipt(Cashier c, HashMap<Goods, Integer> g){
        num++;
        this.c = c;
        this.g = g;
        for (HashMap.Entry<Goods, Integer> entry : g.entrySet()) {
            total += entry.getKey().getPrice()*entry.getValue();
        }
    }

    public double getTotal(){
        return total;
    }
    public void write() {
        String name = "Receipt " + num + ".txt";
        try{
            FileWriter fw = new FileWriter(name);
            fw.write(this.toString());
            fw.close();
        } catch (IOException e) {
            System.out.println("IOException " + e);
        }
    }
    @Override
    public String toString() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        String finito = "";
        finito += "Number of Receipt: " + num + "\n" + c.toString() + "\n" + currentTime + "\n";
        for (HashMap.Entry<Goods, Integer> entry : g.entrySet()) {
            finito += entry.getKey().toString() + "\n\tQuantity: " + entry.getValue() + "\n";
        }
        finito += "Total: " + numberFormat.format(total) + " dollars.";
        return finito;
    }
}
