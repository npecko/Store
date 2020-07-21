import java.util.*;

public class Store {
    private HashMap<Goods, Integer> goods = new HashMap<>();
    private ArrayList<Cashier> cashiers = new ArrayList<>();
    private int numOfReceipts = 0;
    private double income = 0;
    Store() {}
    public void addCashier(Cashier c){
        cashiers.add(c);
    }
    public Cashier getCashier(){
        for(Cashier cashier : this.cashiers){
            if(!cashier.isBusy()){
                cashier.setBusy(true);
                return cashier;
            }
        }
        return cashiers.get(0);
    }
    public void addGoods(Goods g, int quantity){
        goods.put(g, quantity);
    }
    public void sellGoods(HashMap<Goods, Integer> g) throws QuantityExceededException{
        for (HashMap.Entry<Goods, Integer> entry : g.entrySet()) {
            if(goods.get(entry.getKey()) < entry.getValue()){
                throw new QuantityExceededException(entry.getKey().getName(), goods.get(entry.getKey()),
                        entry.getValue());
            }
            else{
                if(goods.get(entry.getKey()) - entry.getValue() == 0){
                    goods.remove(entry.getKey());
                }
                else{
                    goods.put(entry.getKey(), goods.get(entry.getKey()) - entry.getValue());
                }
                income += entry.getKey().getPrice()*entry.getValue();
            }
        }
        numOfReceipts++;
    }
    public double getIncome(){
        return income;
    }
    public int getNumOfReceipts(){
        return numOfReceipts;
    }
}
