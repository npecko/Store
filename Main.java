import java.util.HashMap;
import java.text.*;

public class Main {
    public static void main(String args[]){
        Cashier mark = new Cashier(5189, "Mark");
        Cashier john = new Cashier(1125, "John");

        Goods orange = new Goods(31, "Orange", 1.99, "21.12.2012");
        Goods apple = new Goods(41, "Apple", 2.99, "23.12.2012");
        Goods chair = new Goods(22, "Chair", 29.99, "N/A");
        Goods table = new Goods(23, "Table", 39.99,"N/A");
        Goods heels = new Goods(123, "High heels", 15.99, "N/A");
        Goods milk = new Goods(32, "Milk", 4.99, "28.02.2019");

        Store ikea = new Store();
        ikea.addCashier(mark);
        ikea.addCashier(john);
        ikea.addGoods(orange, 3);
        ikea.addGoods(apple, 5);
        ikea.addGoods(chair, 7);
        ikea.addGoods(table, 9);
        ikea.addGoods(heels, 2);
        ikea.addGoods(milk, 11);

        HashMap<Goods, Integer> cart1 = new HashMap<>();
        cart1.put(orange, 2);
        cart1.put(apple, 4);
        cart1.put(chair, 7);
        HashMap<Goods, Integer> cart2 = new HashMap<>();
        cart2.put(table, 8);
        cart2.put(heels, 2);
        cart2.put(milk, 11);

        Thread cashRegister1 = new Thread(new CashRegister("Cash Register 1", ikea.getCashier(), cart1, ikea));
        Thread cashRegister2 = new Thread(new CashRegister("Cash Register 2", ikea.getCashier(), cart2, ikea));

        cashRegister1.start();
        try{
            cashRegister1.join();
        }catch(InterruptedException ex){}
        cashRegister2.start();
        try{
            cashRegister2.join();
        }catch(InterruptedException ex){}

        System.out.println("Number of receipts issued: " + ikea.getNumOfReceipts());
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        System.out.println("Total income: " + numberFormat.format(ikea.getIncome()) + " dollars");
    }
}
