package ru.innopolis.nikn.models.dao.factory;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.dbcp2.Utils;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.nikn.models.dao.StudentDAO;
import ru.innopolis.nikn.utils.PoolConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Nikolay on 22.11.2016.
 */
@Component
public class PostgreDAOFactory implements DAOFactory {

    public static final String DBURL = "jdbc:postgresql://localhost:5432/classwork";
    private final String USER_NAME = "postgres";
    private final String PASSWORD = "Qwerty";

    @Autowired
    private StudentDAO userDAO;


    public PostgreDAOFactory() {
        PoolConnectionFactory.registerJDBCDriver(PoolConnectionFactory.POSTGRE_DRIVER);
        ConnectionFactory connectionFactory = PoolConnectionFactory.getConnFactory(DBURL, USER_NAME, PASSWORD);
        PoolableConnectionFactory poolfactory = new PoolableConnectionFactory(connectionFactory, null);
        ObjectPool connectionPool = new GenericObjectPool(poolfactory);
        poolfactory.setPool(connectionPool);
        PoolingDriver dbcpDriver = PoolConnectionFactory.getDBCPDriver();
        dbcpDriver.registerPool("dbcp-jcg-postgre", connectionPool);
    }

    @Override
    public StudentDAO getUserDAO() {
        return userDAO;
    }

    @Override
    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:apache:commons:dbcp:dbcp-jcg-postgre");
    }

    @Override
    public void closeConnection(Connection connection) {
        Utils.closeQuietly(connection);
    }

}
