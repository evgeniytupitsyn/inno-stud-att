package ru.innopolis.etupitsyn.dao;

import ru.innopolis.etupitsyn.myException.ConnectionException;
import ru.innopolis.etupitsyn.myException.UserQueryException;

import java.sql.SQLException;

/**
 * Created by evgeniytupitsyn on 22.11.2016.
 */
public interface UserDAO {

    public boolean createUser(User user) throws ConnectionException, SQLException, UserQueryException;
    public boolean updateUser(User user);
    public boolean deleteUser(User user);
    public User findByName(String name);
    public User findById(int id) throws Exception;
    public User find(String name, String pwd) throws Exception;

}
