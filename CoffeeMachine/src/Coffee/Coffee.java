package Coffee;

public class Coffee {
    private String type;
    private double price;
    private int waterNeeded;
    private int milkNeeded;
    private int beansNeeded;

    public Coffee(String type, double price, int waterNeeded, int milkNeeded, int beansNeeded) {
        this.type = type;
        this.price = price;
        this.waterNeeded = waterNeeded;
        this.milkNeeded = milkNeeded;
        this.beansNeeded = beansNeeded;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getWaterNeeded() {
        return waterNeeded;
    }

    public int getMilkNeeded() {
        return milkNeeded;
    }

    public int getBeansNeeded() {
        return beansNeeded;
    }
}
