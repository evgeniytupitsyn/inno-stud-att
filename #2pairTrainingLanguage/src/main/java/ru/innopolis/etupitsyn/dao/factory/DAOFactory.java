package ru.innopolis.etupitsyn.dao.factory;

import ru.innopolis.etupitsyn.dao.UserDAO;

/**
 * Created by evgeniytupitsyn on 22.11.2016.
 */
public abstract class DAOFactory {

    public static final int ORACLE = 1;
    public static final int POSTGRE = 2;

    public abstract UserDAO getUserDAO();

    public static DAOFactory getDAOFactory(
            int whichFactory) {

        switch (whichFactory) {
            case ORACLE: {
                return null;
            }
            case POSTGRE:
                return PostgreDAOFactory.getInstance();
            default:
                return null;
        }
    }

}
