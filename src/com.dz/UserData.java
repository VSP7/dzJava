package com.dz;

import java.io.Serializable;
import java.util.Scanner;

public class UserData implements Serializable {

    private String name;
    private String login;
    private String age;
    private String hobbies;

    UserData(){

        Scanner in = new Scanner(System.in);

        System.out.println("Введите ваше имя:");
        this.name = in.nextLine();
        System.out.println("Введите ваш логин:");
        this.login = in.nextLine();
        System.out.println("Введите ваш возраст:");
        this.age = in.nextLine();
        System.out.println("Введите ваши хобби:");
        this.hobbies = in.nextLine();

        // вместо пробелов в перечне хобби
        // вставим переход строки
        this.hobbies = this.hobbies.replaceAll("\\s+", "\n");

    }

    public String toString(){

        return "Пользователь: "+this.name+" с логином: "+this.login+". Его возраст: "+this.age+". Все хобби:\n"
                +this.hobbies;
    }

}
