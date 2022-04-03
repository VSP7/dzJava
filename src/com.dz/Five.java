package com.dz;

import java.sql.SQLException;
import java.util.ArrayList;

public class Five {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // 5. Создайте базу данных, которая будет состоять из трёх табличек: items, users, orders.
        //Лучше чтобы вы создали её вручную, но если не хотите этого делать, то вот SQL файл,
        //который вы можете импортировать в БД через графический редактор PhpMyAdmin.
        //
        //Из таблицы users выберите лишь пользователя, у которого поле login равно значению «john».
        //
        //Из таблицы items выберите лишь те товары, которые принадлежат к категории «hats».
        //
        //В таблицу ordres поместите новые заказы. В качестве user_id указываейте id пользователя
        //что вы выбрали из таблицы users, а в качестве items_id указывайте id товаров,
        //что вы выбрали из таблицы items.
        //
        //После добавления всех значений в таблицу orders выведите на экран содержимое таблицы
        //orders.

        // создадим объект класса Sql
        Sql db = new Sql();
        //  узнаем id Джона
        int JohnId = db.getDate("users");
        // узнаем id товаров типа hats и запишем их в массив
        ArrayList<Integer> hatsId = db.getDate1("items");

        // добавим в таблицу orders id джона и id его заказов
        for(int i = 0; i< hatsId.size(); i++){
            db.insertArticle("orders",JohnId, hatsId.get(i));
        }

        // выведем таблицу orders
        db.getDate3("orders");


    }

}
