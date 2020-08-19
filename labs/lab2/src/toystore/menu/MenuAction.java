package toystore.menu;

public class MenuAction {
    public static void printMenu(){
        System.out.flush();
        System.out.println("1.Добавить в покупку\n2.Просмотреть заказ\n3.Посчитать стоимость заказа\n4.Оформить сюприз-покупку\n5.Выход\n");
    }

    public static void printAddMenu(){
        System.out.flush();
        System.out.println("1.Мягкая игрушка (различные мишки)\n2.Твердая игрушка (различные мячи)\n3.Назад");
    }

}
