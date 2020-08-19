package toystore.entity.solidtoy;

import toystore.myexception.MyEnterException;

public class Ball extends SolidToy {
    private double diameter;

    public Ball() {
        super("Мячик детский");
        diameter=0;
    }

    public Ball(String nameToy, double diameter) {
        super(nameToy);
        this.diameter = diameter;
    }

    public Ball(String nameToy, double price, double diameter) {
        super(nameToy, price);
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) throws MyEnterException{
        if(diameter<=0) throw new MyEnterException("Не бывает таких маленьких мячиков!");
        this.diameter = diameter;
    }

    @Override
    public boolean equals(Object o) {
        if(o==null)
            return false;
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball temp = (Ball) o;
        return Double.compare(temp.diameter, this.diameter) == 0 &&
                this.material.equals(temp.material)&&
                this.price==temp.price;
    }

    @Override
    public int hashCode() {
        return 47*(int)this.diameter;
    }
}
