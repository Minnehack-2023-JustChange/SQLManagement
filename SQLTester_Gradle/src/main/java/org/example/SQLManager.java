package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SQLManager {

    public static SQLManager instance = new SQLManager();

    public static SQLManager getInstance() {
        return instance;
    }

    Connection connection;

    public void init(String password) throws Exception {

        for (int i = 0; i < 50; i++) {
            insertFakeAccountData();
        }


        // String url = "jdbc:mysql://localhost:3306/minnehack";
        // connection = DriverManager.getConnection(url, username, password);

        Class.forName("com.mysql.jdbc.Driver");
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "minnehack");
        config.setUsername("root");
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        HikariDataSource ds = new HikariDataSource(config);
        connection = ds.getConnection();
        System.out.println();
        System.out.println();

        for (int i = 0; i < 50; i++) {
            insertFakeAccountData();
        }
        System.out.println();
        System.out.println();

    }

    public String generateRandomString(int length) {
        char[] array = new char[length];
        for (int i = 0; i < length; i++) {
            array[i] = (char) ThreadLocalRandom.current().nextInt(33, 126 + 1);
        }

        return String.valueOf(array);
    }

    public String generateRandomLetterString(int length) {
        char[] array = new char[length];
        for (int i = 0; i < length; i++) {
            array[i] = (char) ThreadLocalRandom.current().nextInt(97, 122 + 1);
        }

        return String.valueOf(array);
    }


    public String generateRandomNumber(int length) {
        char[] array = new char[length];
        for (int i = 0; i < length; i++) {
            array[i] = (char) ThreadLocalRandom.current().nextInt(48, 57 + 1);
        }

        return String.valueOf(array);
    }


    public void insertFakeAccountData() throws SQLException {

        String query = "INSERT INTO `accounts` VALUES(" +
                "\"" + generateRandomNumber(20) + "\"," +
                "\"" + generateRandomLetterString(10) + "@email.com" + "\"," +
                "\"" + generateRandomNumber(4) + generateRandomNumber(24) + generateRandomNumber(4) + "\"," +
                "\"" + generateRandomLetterString(8) + "\"," +
                "\"" + generateRandomLetterString(8) + "\"," +
                "\"" + generateRandomLetterString(13) + "\"," +
                "FALSE, " +
                "\"" + generateRandomNumber(27) + "\"" +
                ");";

        System.out.println(query);
        //connection.prepareStatement(query).execute();
    }

}
