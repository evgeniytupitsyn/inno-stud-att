package ru.innopolis.nikn.models.dao.postgre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.nikn.models.dao.LectureDAO;
import ru.innopolis.nikn.models.dao.factory.DAOFactory;
import ru.innopolis.nikn.models.entities.Lecture;
import ru.innopolis.nikn.models.entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolay on 22.11.2016.
 */
@Component
public class PostgreLectureDAO implements LectureDAO {

    private static final String PREPARED_INSERT = "insert into lectures (name) values (?);";

    private static final String PREPARED_FIND_ALL = "select * from lectures";

    private static final String PREPARED_FIND_BY_ID = "select * from lectures where id = (?)";

    @Autowired
    private DAOFactory daoFactory;

    private Lecture buildLecture(ResultSet rs) throws SQLException {
        Lecture lecture = new Lecture();
        lecture.setId(rs.getInt("id"));
        lecture.setName(rs.getString("name"));
        return lecture;
    }

    @Override
    public boolean createLecture(Lecture lecture) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = daoFactory.createConnection();
            preparedStatement = connection.prepareStatement(PREPARED_INSERT);
            preparedStatement.setString(1, lecture.getName());
            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                daoFactory.closeConnection(connection);
            }
        }
        return false;
    }

    @Override
    public boolean updateLecture(Lecture lecture) {
        return false;
    }

    @Override
    public boolean deleteLecture(Lecture lecture) {
        return false;
    }

    @Override
    public List<Lecture> findAll() {
        List<Lecture> lectures = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = daoFactory.createConnection();
            preparedStatement = connection.prepareStatement(PREPARED_FIND_ALL);
            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.getResultSet();
            while(rs.next()) {
                lectures.add(buildLecture(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                daoFactory.closeConnection(connection);
            }
        }
        return lectures;
    }

    @Override
    public Lecture findById(int id) {
        Lecture lecture = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = daoFactory.createConnection();
            preparedStatement = connection.prepareStatement(PREPARED_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.getResultSet();
            if(rs.next()) {
                lecture = buildLecture(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                daoFactory.closeConnection(connection);
            }
        }
        return lecture;
    }



}
