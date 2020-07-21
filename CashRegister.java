import java.text.DecimalFormat;
import java.util.HashMap;

public class CashRegister implements Runnable{
    private Store s;
    private String name;
    private Cashier c;
    private HashMap<Goods, Integer> g;

    CashRegister(String name, Cashier c, HashMap<Goods, Integer> g, Store s){
        this.name = name;
        this.c = c;
        this.g = g;
        this.s = s;
    }

    @Override
    public void run() {
        Receipt r = new Receipt(c, g);

        DecimalFormat numberFormat = new DecimalFormat("#.00");
        System.out.println(this.name + " --- " + this.c.toString() + " --- Receipt total: " + numberFormat.format(r.getTotal())
                + " dollars");
        try{
            this.s.sellGoods(g);
        } catch(QuantityExceededException ex){
            System.out.println(ex.toString());
        }

        r.write();
    }
}
