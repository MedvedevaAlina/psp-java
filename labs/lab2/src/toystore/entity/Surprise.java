package toystore.entity;

import toystore.IPriceCount;
import toystore.entity.softtoy.Bear;
import toystore.entity.solidtoy.Ball;

import java.util.Random;

public class Surprise {
    public static IPriceCount getToyFromSurprise(int mode){
        switch(mode){
            case 0:
                return new Bear("Мишутка", 73.4, 23.1);
            case 1:
                return new Ball("Волейбольный мячик", 125.5, 38);
            case 2:
                return new Bear("Мишка", 109, 77.7);
            case 3:
                return new Ball("Детский мячик", 15.7, 18);
            default:
                throw new IllegalArgumentException("не может быть такого!");
        }
    }

    public IPriceCount[] generateSurprise(int maxMode) {
        IPriceCount[ ] surprise = new IPriceCount[2];
        for (int i = 0; i < surprise.length; i++) {
            int mode = new Random().nextInt(maxMode);
            surprise[i] = Surprise.getToyFromSurprise(mode);
        }
        return surprise;
    }
    public double priceSurprise(IPriceCount[] surprise) {
        double sumPrice=0;
        int i=1;
        for (IPriceCount s : surprise) {
            System.out.println("Цена "+ i +"-ой(ей) игрушки "+ String.format("%3.2f",s.countPrice()));
            i++;
            sumPrice += s.countPrice();
        }
        return sumPrice;
    }
}
