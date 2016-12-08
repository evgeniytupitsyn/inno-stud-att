package ru.innopolis.nikn.utils;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.ObjectPool;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Nikolay on 22.11.2016.
 */
public class PoolConnectionFactory {

    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
    public static final String DBCP_DRIVER = "org.apache.commons.dbcp2.PoolingDriver";
    public static final String POSTGRE_DRIVER = "org.postgresql.Driver";

    public static Class dirverClass;
    private static PoolingDriver driver;

    public static void registerJDBCDriver(String driver) {
        try {
           dirverClass = Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.err.println("There was not able to find the driver class");
        }
    }

    public static ConnectionFactory getConnFactory(String connectionURI, String user, String password) {
        ConnectionFactory driverManagerConnectionFactory = new DriverManagerConnectionFactory(connectionURI, user, password);
        return driverManagerConnectionFactory;
    }
    public static PoolingDriver getDBCPDriver() {
        try {
            Class.forName(DBCP_DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("There was not able to find the driver class");
        }
        try {
            driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
        } catch (SQLException e) {
            System.err.println("There was an error: " + e.getMessage());
        }
        return driver;
    }

    public static void registerPool(String poolName, ObjectPool pool) {
        driver.registerPool(poolName, pool);
    }
}

