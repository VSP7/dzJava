package com.dz;

import java.util.Scanner;

public class Three {

    public static void main(String[] args) {

        // 3) При помощи ООП и классов создайте программу «Rock, Paper, Scissors» или же «Камень, ножницы, бумага».
        // Ваша задача состоит в том, чтобы создать: отдельный класс Player,
        // перечисление с названием VARIANTS и два объекта на основе класса Player.
        //
        //Код из основного класса мы вам предоставляем, он находиться ниже:
        //// Создаем объекты
        //Player bot = new Player();
        //Player alex = new Player(VARIANTS.SCISSORS, "Alex");
        //
        //// Получаем результат
        //System.out.println(bot.whoWins(bot, alex));
        //
        //Вам необходимо создать класс Player, в котором должны быть реализованы следующие моменты:
        //перечисление для установки выбора: enum VARIANTS;
        //переменные для установки имени, а также определенного варианта из перечисления;
        //два конструктора. Первый ничего не принимает и устанавливает случайное значение из перечисления,
        // а также имя «Bot». Второй конструктор принимает определенный вариант из перечисления и имя для объекта;
        //функция whoWins, которая принимает два объекта и возвращает либо строку «Ничья»,
        // либо информацию про игрока, который победил.
        //Ниже пример работы программы:
        // Победил игрок с именем Bot.

        Scanner in = new Scanner(System.in);
        System.out.println("Введите ваше имя:");
        String userName = in.nextLine();
        while (true) {
            System.out.println("Введите камень ножницы или бумага:");
            String chooseUser = in.nextLine();

            Player bot = new Player();

            System.out.println("Bot поставил: "+bot.chooseBot);
            System.out.println(userName+" поставил: "+chooseUser);

            System.out.println(bot.whoWins(userName, chooseUser));
            if(bot.whoWins(userName, chooseUser)!="недопустимое значение, повторите попытку") break;
        }

    }

}
