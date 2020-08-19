package sklad;

import sklad.entity.Product;
import sklad.entity.Sklad;

public class WriterInfo {
    public static void printItemInSklad(Sklad sklad){
        sklad.printIsAvailable();
    }
    public static void printAllItems(Sklad sklad){
        sklad.printListProduct();
    }
}
