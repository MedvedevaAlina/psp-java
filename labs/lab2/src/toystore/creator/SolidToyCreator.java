package toystore.creator;

import toystore.entity.ToyImpl;
import toystore.entity.solidtoy.Ball;
import toystore.myexception.MyEnterException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolidToyCreator {
    public void createBall(Ball ball){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        CreatorToyImpl.createToy(ball);

        while (true){
            System.out.println("Введите материал");
            try {
                ball.setMaterial(bufferedReader.readLine());
                break;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {

            System.out.println("Введите диаметр мяча");
            try {
                ball.setDiameter(Double.parseDouble(bufferedReader.readLine()));
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }catch (NumberFormatException ex){
                System.out.println("Ошибка типа NumberFormatException");
            }catch (MyEnterException e){
                System.out.println("Диаметр больше 0");
            }
        }

    }
}
