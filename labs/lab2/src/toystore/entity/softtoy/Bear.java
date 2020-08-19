package toystore.entity.softtoy;

public class Bear extends SoftToy {
    private double height;

    public Bear() {
        super("мишка Тедди");
        height=0;
    }

    public Bear(String nameToy, double price, double height) {
        super(nameToy, price);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

     @Override
    public boolean equals(Object o) {
        if (this == null) return false;
        if (this == o) return true;
        if (!(o instanceof Bear)) return false;
        Bear temp = (Bear) o;
        return Double.compare(temp.height, height) == 0 &&
                this.packing.equals(temp.packing)&&
                this.price==temp.price;
    }

    @Override
    public int hashCode() {
        return 47*(int)this.height+12;
    }

    @Override
    public String toString() {
        return super.toString() +
                " с высотой " + height;
    }
}
