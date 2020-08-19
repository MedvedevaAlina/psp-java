package toystore.purchase;

import toystore.IPriceCount;
import toystore.entity.ToyImpl;
import toystore.entity.softtoy.SoftToy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Purchase implements IPriceCount {
   private List<ToyImpl> listToy;
   private double pricePurchase;

   public Purchase(){
       listToy=new ArrayList<>();
       pricePurchase=0;
   }

   public void addToytoList(ToyImpl item){
       listToy.add(item);
   }

   public int getSize(){
       return listToy.size();
   }

   public void printPurchase(){
       int i=1;
       Iterator it=listToy.iterator();
       while(it.hasNext())
       {
           System.out.println(i+". "+(it.next()).toString());
           i++;
       }
   }

    @Override
    public double countPrice() {
       if(listToy.size()==1) return listToy.get(0).countPrice();
       else {
           double tempPrice = 0;
           Iterator it = listToy.iterator();
           ToyImpl obj;
           while (it.hasNext()) {
               obj = (ToyImpl) it.next();
               tempPrice += obj.getPrice();
           }
           pricePurchase = tempPrice * 0.8;
           return pricePurchase;
       }
    }
}
