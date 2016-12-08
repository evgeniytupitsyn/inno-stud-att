package ru.innopolis.nikn.models.dao.postgre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.nikn.models.dao.StudentDAO;
import ru.innopolis.nikn.models.dao.factory.DAOFactory;
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
public class PostgreStudentDAO implements StudentDAO {

    private static final String PREPARED_INSERT = "insert into students (first_name, last_name, group_num) values (?, ?, ?);";

    private static final String PREPARED_FIND_ALL = "select * from students";

    private static final String PREPARED_FIND_BY_ID = "select * from students where id = (?)";

    private static final String PREPARED_COUNT_LECTURE = "select COUNT(*) from journal where student_id = (?)";

    @Autowired
    private DAOFactory daoFactory;

    private Student buildStudent(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setFirstName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));
        student.setGroup(rs.getInt("group_num"));
        student.setCountLecture(getLectureCount(rs.getInt("id")));
        return student;
    }

    private int getLectureCount(int id) {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = daoFactory.createConnection();
            preparedStatement = connection.prepareStatement(PREPARED_COUNT_LECTURE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.getResultSet();
            if(rs.next()) {
                count = rs.getInt("count");
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
        System.out.println(id + " " + count);
        return count;
    }

    @Override
    public boolean createStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = daoFactory.createConnection();
            preparedStatement = connection.prepareStatement(PREPARED_INSERT);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setInt(3, student.getGroup());
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
    public boolean updateStudent(Student student) {
        return false;
    }

    @Override
    public boolean deleteStudent(Student student) {
        return false;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = daoFactory.createConnection();
            preparedStatement = connection.prepareStatement(PREPARED_FIND_ALL);
            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.getResultSet();
            while(rs.next()) {
                students.add(buildStudent(rs));
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
        return students;
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = daoFactory.createConnection();
            preparedStatement = connection.prepareStatement(PREPARED_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.getResultSet();
            if(rs.next()) {
                student = buildStudent(rs);
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
        return student;
    }

}
