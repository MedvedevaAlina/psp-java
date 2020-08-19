package sklad.entity;

public class Product {
    private String name;
    private double cost;
    private boolean isAvailable;

    public Product(String name, double cost, boolean isAvailable) {
        this.name = name;
        this.cost = cost;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return  name +
                " со стоимостью " + cost;
    }

    public Product() {  }

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
}
