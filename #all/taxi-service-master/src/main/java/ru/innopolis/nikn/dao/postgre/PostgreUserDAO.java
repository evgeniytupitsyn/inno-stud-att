package ru.innopolis.nikn.dao.postgre;

import ru.innopolis.nikn.dao.User;
import ru.innopolis.nikn.dao.UserDAO;
import ru.innopolis.nikn.dao.factory.PostgreDAOFactory;
import ru.innopolis.nikn.excaptions.ConnectionException;
import ru.innopolis.nikn.excaptions.UserQueryException;

import java.sql.*;

/**
 * Created by Nikolay on 22.11.2016.
 */
public class PostgreUserDAO implements UserDAO{

    private static final String PREPARED_FIND_QUERY = "select * from users where username = (?) AND pwd = (?) AND lock = FALSE";
    private static final String PREPARED_FIND_BY_ID_QUERY = "select * from users where id = (?)  AND lock = FALSE";
    private static final String PREPARED_INSERT = "insert into users (username, pwd, first_name, last_name, email) values (?, ?, ?, ?, ?);";

    private PostgreDAOFactory postgreDAOFactory = PostgreDAOFactory.getInstance();

    private User createUser(ResultSet rs) throws SQLException {
        if(rs.next()) {
            User.Builder builder = new User.Builder();
            builder.withId(rs.getInt("id"))
                    .withUsername(rs.getString("username"))
                    .withEmail(rs.getString("email"))
                    .withFirstName(rs.getString("first_name"))
                    .withLastName(rs.getString("last_name"));
            return new User(builder);
        }
        return null;
    }

    @Override
    public boolean createUser(User user) throws ConnectionException, SQLException, UserQueryException {
        Connection connection = null;
        PreparedStatement  preparedStatement = null;
        try {
            connection = postgreDAOFactory.createConnection();
            preparedStatement = connection.prepareStatement(PREPARED_INSERT);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getEmail());

            return !preparedStatement.execute();
        } catch (SQLException e) {
            throw new ConnectionException(e);
        }
        finally {
            if(connection != null) {
                postgreDAOFactory.closeConnection(connection);
            }
            if(preparedStatement != null) {
                preparedStatement.close();
            }
        }
      //  throw new UserQueryException(UserQueryException.LOGIN_ERROR_MESSAGE);
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }

    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public User findById(int id) throws ConnectionException, UserQueryException, SQLException {
        Connection connection = null;
        PreparedStatement  preparedStatement = null;
        try {
            connection = postgreDAOFactory.createConnection();
            preparedStatement = connection.prepareStatement(PREPARED_FIND_BY_ID_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.getResultSet();
            User user = createUser(rs);
            if(user != null) {
                return user;
            }
        } catch (SQLException e) {
            throw new ConnectionException(e);
        }
        finally {
            if(connection != null) {
                postgreDAOFactory.closeConnection(connection);
            }
            if(preparedStatement != null) {
                preparedStatement.close();
            }
        }
        throw new UserQueryException(UserQueryException.LOGIN_ERROR_MESSAGE);
    }

    @Override
    public User find(String login, String pwd) throws Exception {
        Connection connection = null;
        PreparedStatement  preparedStatement = null;
        try {
            connection = postgreDAOFactory.createConnection();
            preparedStatement = connection.prepareStatement(PREPARED_FIND_QUERY);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, pwd);
            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.getResultSet();
            User user = createUser(rs);
            if(user != null) {
                return user;
            }
        } catch (SQLException e) {
            throw new ConnectionException(e);
        }
        finally {
            if(connection != null) {
                postgreDAOFactory.closeConnection(connection);
            }
            if(preparedStatement != null) {
                preparedStatement.close();
            }
        }
        throw new UserQueryException(UserQueryException.LOGIN_ERROR_MESSAGE);
    }

}
