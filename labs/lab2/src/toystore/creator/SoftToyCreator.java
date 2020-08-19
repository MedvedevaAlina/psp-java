package toystore.creator;

import toystore.entity.softtoy.Bear;
import toystore.myexception.MyEnterException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class SoftToyCreator {

    public void createBear(Bear bear) throws InputMismatchException, MyEnterException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        CreatorToyImpl.createToy(bear);
        while (true){
            System.out.println("Введите наполнитель");
            try {
                bear.setPacking(bufferedReader.readLine());
                break;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
         }

        while (true) {

            System.out.println("Введите высоту товара");
            try {
                bear.setHeight(Double.parseDouble(bufferedReader.readLine()));
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }catch (NumberFormatException ex){
                throw new MyEnterException("Ввели неккоректное число!", ex);
            }
        }
    }
}
