package ru.innopolis.nikn.dao.factory;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.dbcp2.Utils;

import ru.innopolis.nikn.dao.UserDAO;
import ru.innopolis.nikn.dao.postgre.PostgreUserDAO;
import ru.innopolis.nikn.utils.PoolConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Nikolay on 22.11.2016.
 */
public class PostgreDAOFactory extends DAOFactory {

    public static final String DBURL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER_NAME = "postgres";
    private final String PASSWORD = "Qwerty";

    private PostgreDAOFactory() {
        PoolConnectionFactory.registerJDBCDriver(PoolConnectionFactory.POSTGRE_DRIVER);
        ConnectionFactory connectionFactory = PoolConnectionFactory.getConnFactory(DBURL, USER_NAME, PASSWORD);
        PoolableConnectionFactory poolfactory = new PoolableConnectionFactory(connectionFactory, null);
        ObjectPool connectionPool = new GenericObjectPool(poolfactory);
        poolfactory.setPool(connectionPool);
        PoolingDriver dbcpDriver = PoolConnectionFactory.getDBCPDriver();
        dbcpDriver.registerPool("dbcp-jcg-postgre", connectionPool);
    }

    public static PostgreDAOFactory getInstance() {
        return PostgreSingletone.INSTANCE;
    }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:apache:commons:dbcp:dbcp-jcg-postgre");
    }

    public void closeConnection(Connection connection) {
        Utils.closeQuietly(connection);
    }

    @Override
    public UserDAO getUserDAO() {
        return new PostgreUserDAO();
    }

    private static class PostgreSingletone {
        private static final PostgreDAOFactory INSTANCE = new PostgreDAOFactory();
    }


}
