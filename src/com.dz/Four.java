package com.dz;

import java.io.*;

public class Four {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        // 4) Создайте программу, в которой у пользователя будут запрашиваться такие данные, как:
        // имя, логин, возраст, а также список его хобби. После ввода всех данных выполните сериализацию
        // и далее десиреализацию. Объект что будет получен при десериализации должен быть выведен
        // с использованием переопределенния метода toString().

        UserData userData = new UserData(); // создадим объект юзера
        //        System.out.println(userData);

        // сериализуем
        // создаём файл, в который будем сохранять объект (название и расширение любое)
        FileOutputStream fos = new FileOutputStream("serialize.userData");
        // создаём объект записи
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        // записываем
        oos.writeObject(userData);
        // закрываем запись
        oos.close();
        // файл создался и объект записался в папке содержащей src проекта

        Thread.sleep(1000);

        // десериализуем
        FileInputStream fis = new FileInputStream("serialize.userData"); // создаём объект файла
        ObjectInputStream ois = new ObjectInputStream(fis); // создаём объект для записи из файла
        UserData object1 = (UserData) ois.readObject();  // записываем в конечный объект извлеченный объект1
        System.out.println(object1); // выводим
        ois.close(); // закрываем промежуточный объект записи

    }

}
