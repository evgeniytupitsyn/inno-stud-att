package ru.innopolis.nikn.dao.factory;

import ru.innopolis.nikn.dao.UserDAO;

/**
 * Created by Nikolay on 22.11.2016.
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
