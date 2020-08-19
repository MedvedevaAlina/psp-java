package toystore;

import toystore.creator.SoftToyCreator;
import toystore.creator.SolidToyCreator;
import toystore.entity.Surprise;
import toystore.entity.softtoy.Bear;
import toystore.entity.solidtoy.Ball;
import toystore.menu.MenuAction;
import toystore.myexception.MyEnterException;
import toystore.purchase.Purchase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
   public static void main(String[] args) throws Exception{

       int numberMenu = 0;
       int addMenu=0;
       Purchase purchase = new Purchase();
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       do {
           boolean flag = true;
           MenuAction.printMenu();
           System.out.println("Введите число:");
           while (flag) {
               try {
                   numberMenu = Integer.parseInt(bufferedReader.readLine());
                   if (numberMenu < 1 && numberMenu > 4) throw new MyEnterException("Некорректное число!");
                   break;
               } catch (IOException e) {
                   System.out.println("Исключение типа IOException");
               } catch (NumberFormatException e) {
                   System.out.println("Исключение типа NumberFormatException");
               } catch (MyEnterException ex) {
                   System.err.println(ex.getMessage());
               }
           }
           while (flag) {
               switch (numberMenu) {
                   case 1:
                        while(flag) {
                            MenuAction.printAddMenu();
                            System.out.println("Введите число:");

                            try {
                                addMenu = Integer.parseInt(bufferedReader.readLine());
                            } catch (IOException e) {
                                System.err.println(e.getMessage());
                            } catch (NumberFormatException e) {
                                System.out.println("Исключение типа NumberFormatException");
                            }
                            if (addMenu == 1) {
                                SoftToyCreator softToyCreator = new SoftToyCreator();
                                Bear bear = new Bear();
                                softToyCreator.createBear(bear);
                                purchase.addToytoList(bear);
                            }
                            if (addMenu == 2) {
                                SolidToyCreator solidToyCreator = new SolidToyCreator();
                                Ball ball = new Ball();
                                solidToyCreator.createBall(ball);
                                purchase.addToytoList(ball);
                            }
                            if(addMenu==3) flag=false;
                        }
                       break;

                   case 2: {
                       if(purchase.getSize()==0){
                           System.out.println("Вы ничего не купили(");
                       }
                       else{System.out.println("==Список покупки==\n");
                       purchase.printPurchase();}
                       flag=false;
                       break;
                   }
                   case 3: {
                       if(purchase.getSize()==0){
                           System.out.println("Вы ничего не купили(");
                       }
                       else{
                           System.out.println("Общая стоимость покупки - " + purchase.countPrice());
                       }
                       flag=false;
                       break;
                   }
                   case 4:
                       Surprise surprise = new Surprise();
                       IPriceCount[] masToy = surprise.generateSurprise(4); // 4-ех видов игрушки, 2 из них идет в сюрприз
                       System.out.println("Общая стоимость сюприз-покупки "+ String.format("%3.2f",surprise.priceSurprise(masToy)));
                       flag = false;
                       break;
                   case 5: {
                       flag = false;
                       break;
                   }
                   default:
                       System.out.println("Неверное значение!");
                       flag = false;
                       break;
               }
           }
       }while(numberMenu !=5);
   }
}

