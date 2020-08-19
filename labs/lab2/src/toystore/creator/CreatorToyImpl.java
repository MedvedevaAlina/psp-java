package toystore.creator;

import toystore.entity.ToyImpl;
import toystore.myexception.MyEnterException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreatorToyImpl {
    public static void createToy(ToyImpl toy)
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Введите возрастное ограничение ребенка");
            try {
                toy.setMinChildAge(Integer.parseInt(bufferedReader.readLine()));
                break;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException ex) {
                System.out.println("Введите число!");
            } catch (MyEnterException e) {
                System.out.println("Введите число больше 0");
            }
        }

        while (true) {
            System.out.println("Введите цену товара");
            try {
                toy.setPrice(Double.parseDouble(bufferedReader.readLine()));
                break;
            } catch (IOException e) {
                System.err.println("Ошибка типа IOException");
            } catch (NumberFormatException ex) {
                System.out.println("Введите число!");
            } catch (MyEnterException e) {
                System.out.println("Введите число больше 0");
            }
        }
    }
}
