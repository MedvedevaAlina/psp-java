package toystore.entity;

import toystore.IPriceCount;
import toystore.myexception.MyEnterException;

abstract public class ToyImpl implements IPriceCount {
   protected String nameToy;
   protected int minChildAge;
   protected double price;

    public ToyImpl() {
        nameToy = new String();
        minChildAge = 0;
        price=0;
    }

    public ToyImpl(String nameToy) {
        this.nameToy = nameToy;
    }

    public ToyImpl(String nameToy, double price) {
        this.nameToy = nameToy;
        this.minChildAge = 4;
        this.price = price;
    }

    public String getNameToy() {
        return nameToy;
    }

    public void setNameToy(String nameToy) {


        this.nameToy = nameToy;
    }

    public int getMinChildAge() {
        return minChildAge;
    }

    public void setMinChildAge(int minChildAge) throws MyEnterException {
        if(minChildAge<0) throw new MyEnterException("Возраст ребенка не может быть меньше 0");

        this.minChildAge = minChildAge;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws MyEnterException {
        if(price<=0) throw new MyEnterException("Цена не может быть отрицательная!");
        this.price = price;
    }

    @Override
    public String toString() {
        return  nameToy + ' ' +
                "для детей от " + minChildAge + " лет";
    }
}
