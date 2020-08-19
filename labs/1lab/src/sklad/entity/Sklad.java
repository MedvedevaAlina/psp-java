package sklad.entity;

import java.util.ArrayList;

public class Sklad {
    private String address;

    public void setAddress(String address) {
        this.address = address;
    }
    private ArrayList<Product> listProduct;

    public Sklad() {
        listProduct=new ArrayList<>();
    }

    public void printIsAvailable(){
        for (Product item:listProduct) {
            if(item.isAvailable())
                System.out.println(item);
        }
    }
    public void printListProduct() {
        for (Product item : listProduct) {
            System.out.println(item.getName());
        }
    }
    public void addProduct(Product product){
        listProduct.add(product);
    }
}
