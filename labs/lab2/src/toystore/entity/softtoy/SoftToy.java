package toystore.entity.softtoy;

import toystore.entity.ToyImpl;

public class SoftToy extends ToyImpl {
   protected String packing;

    public SoftToy() {
        super();
        packing= new String();
    }

    public SoftToy(String nameToy) {
        super(nameToy);
        this.packing = new String();
    }

    public SoftToy(String nameToy, double price) {
        super(nameToy, price);
        this.packing = new String();
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    @Override
    public String toString() {
        return super.toString()+ " с полнителем " + packing ;
    }

    @Override
    public double countPrice() {
        return 1.3*this.getPrice();
    }
}
