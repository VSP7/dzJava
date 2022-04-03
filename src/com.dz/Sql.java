package com.dz;

import java.sql.*;
import java.util.ArrayList;

public class Sql {

    // параметры подключения к базе данных с именем java_db
    // при выгрузке базы на удаленный сервер поменять потребуется только текущие переменные
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "dz";
    private final String LOGIN = "root";
    private final String PASS = "";
    //------------------------------------------------------------------------------------

    // создаём пустой объект соединения
    private Connection dbConn = null;

    // метод подключения к бд
    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        // прописываем параметры подключения в строку
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME; //+..
        // при ошибке с временными зонами нужно дописать параметры в строку connStr
        Class.forName("com.mysql.cj.jdbc.Driver");
        // подключаем драйвер jdbc
        //  jdbc - технология в java для подключения к бд

        // производим подключение используя всё выше
        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
        return dbConn; // возвращаем объект подключения
    }

    // метод отключения от бд
    public void closeConnected() throws SQLException {
        dbConn.close();
        System.out.println("connection close");
    }

    // метод создания таблицы (на вход принимает название)
    public void createTable(String tableName) throws SQLException, ClassNotFoundException {
        // далее в строку прописываем sql команду, в которой указываем что хотим создать таблицу
        // с именем tableName и полями и параметрами к полям
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName
                + " (id INT AUTO_INCREMENT PRIMARY KEY, user_id INT(100), items_id INT(100))" + " ENGINE=MYISAM;";

        // создаём объект класса Statement для передачи команд в sql и сразу производим подключение
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(sql); // передаём команду из строки выше
    }

    // метод добавления записей в таблицу `articles` с переданными параметрами
    public void insertArticle(String table, int userId, int itemsId)
            throws SQLException, ClassNotFoundException {
        // создаём строку sql команды
        String sql = "INSERT INTO "+ table+" (user_id, items_id) VALUES (?, ?)";
        // вместо ? далее будем вставлять свои данные(так безопаснее)

        // создаём объект подключения к базе и передаём команду-строку выше
        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        // PreparedStatement также позволяет добавить свои данные для вставки вместо ?
        prSt.setInt(1, userId);
        prSt.setInt(2, itemsId);

        prSt.executeUpdate(); // передаём команду в sql

        System.out.println("data successfully added");
    }

    // метод извлечения необходимых данных из таблицы  table
    public int getDate(String table) throws SQLException, ClassNotFoundException {
        String sql = "SELECT id FROM "+ table+" WHERE `login`='John'";

        // создаём объект класса Statement для передачи команд в sql и сразу производим подключение
        Statement statement = getDbConnection().createStatement();
        // записываем полученный ответ в res объект
        ResultSet res = statement.executeQuery(sql);
        while(res.next()) { // выводим необходимые данные построчно( 1 цикл=строка в таблице )

            // пример с записью id в переменную id1
            int id = res.getInt("id");
            return id;
        }
        return 0;
    }

    // метод извлечения необходимых данных из таблицы  table
    public ArrayList<Integer> getDate1(String table) throws SQLException, ClassNotFoundException {
        // создаём строку sql команды

        // пример, когда необходимо, чтобы извлечь одну ячейку в нужном столбце и поле
        String sql = "SELECT id FROM "+ table+" WHERE `category`='hats'";

        // создаём объект класса Statement для передачи команд в sql и сразу производим подключение
        Statement statement = getDbConnection().createStatement();
        // записываем полученный ответ в res объект
        ResultSet res = statement.executeQuery(sql);
        ArrayList<Integer> id = new ArrayList<>(0);
        while(res.next()) { // выводим необходимые данные построчно( 1 цикл=строка в таблице )

            id.add(res.getInt("id"));

        }
        return id;
    }

    // метод извлечения необходимых данных из таблицы  table
    public void getDate3(String table) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM "+ table;

        // создаём объект класса Statement для передачи команд в sql и сразу производим подключение
        Statement statement = getDbConnection().createStatement();
        // записываем полученный ответ в res объект
        ResultSet res = statement.executeQuery(sql);
        while(res.next()) { // выводим необходимые данные построчно( 1 цикл=строка в таблице )

            System.out.print(res.getInt("id"));
            System.out.print(" ");
            System.out.print(res.getInt("user_id"));
            System.out.print(" ");
            System.out.println(res.getInt("items_id"));

        }
    }


}
