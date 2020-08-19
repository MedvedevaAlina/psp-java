package sklad;

import sklad.entity.Product;
import sklad.entity.Sklad;

public class Main {
    public static void main(String[ ] args){
        Sklad sklad=new Sklad();
        sklad.setAddress("Минск, ул.Стебенева 6");
        Product product1= new Product("Макароны", 1.2, false);
        Product product2=new Product("Вода Бонаква",2.,true);

        sklad.addProduct(product1);
        sklad.addProduct(product2);
        sklad.addProduct(new Product("Коко-кола", 2.3, true));
        sklad.addProduct(new Product("Рис", 3.4, false));

        System.out.println("Список имеющих товаров на складе:");
        WriterInfo.printItemInSklad(sklad);

        System.out.println("Список всех товаров:");
        WriterInfo.printAllItems(sklad);
    }
}
