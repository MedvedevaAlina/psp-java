package toystore.entity.solidtoy;

import toystore.entity.ToyImpl;

public class SolidToy extends ToyImpl {
    protected String material;

    public SolidToy() {
        super();
        material = new String();
    }
    public SolidToy(String nameToy) {
        super(nameToy);
        this.material = new String();
    }

    public SolidToy(String nameToy, double price) {
        super(nameToy, price);
        this.material = new String();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString()+
                " из материала " + material;
    }
    @Override
    public double countPrice() {
        return this.getPrice()*1.4;
    }
}
