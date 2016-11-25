package ru.innopolis.course2.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by evgeniytupitsyn on 22/11/2016.
 */
public class Main {
    public static Connection main(String[] args) {
        try {
            DriverManager.registerDriver((Driver) Class.forName("org.postgresql.Driver").newInstance());
            StringBuilder url = new StringBuilder();
            url.
                    append("jdbc:postgresql:").
                    append("table");
            Connection connection = DriverManager.getConnection(url.toString(), "postgres", "asdasdasd12");
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
