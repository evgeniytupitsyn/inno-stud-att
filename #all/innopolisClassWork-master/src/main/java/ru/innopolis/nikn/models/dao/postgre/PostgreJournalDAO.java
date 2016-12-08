package ru.innopolis.nikn.models.dao.postgre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.nikn.models.dao.JournalDAO;
import ru.innopolis.nikn.models.dao.factory.DAOFactory;
import ru.innopolis.nikn.models.entities.Journal;
import ru.innopolis.nikn.models.entities.Lecture;
import ru.innopolis.nikn.models.entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolay on 28.11.2016.
 */
@Component
public class PostgreJournalDAO implements JournalDAO{

    private static final String PREPARED_FIND_ALL = "select journal.id, journal.data, students.first_name, students.last_name, " +
            "students.group_num, lectures.name FROM journal " +
            "INNER JOIN students ON journal.student_id = students.id " +
            "INNER JOIN lectures ON journal.lecture_id = lectures.id";

    private static final String PREPARED_INSERT = "insert into journal (student_id, lecture_id, data) values (?, ?, ?);";

    @Autowired
    private DAOFactory daoFactory;

    private Student buildStudent(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setFirstName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));
        student.setGroup(rs.getInt("group_num"));
        return student;
    }

    private Lecture buildLecture(ResultSet rs) throws SQLException {
        Lecture lecture = new Lecture();
        lecture.setName(rs.getString("name"));
        return lecture;
    }

    private Journal buildJournal(ResultSet rs) throws SQLException {
        Journal journal = new Journal();
        journal.setId(rs.getInt("id"));
        journal.setStudent(buildStudent(rs));
        journal.setLecture(buildLecture(rs));
        journal.setDate(rs.getDate("data"));
        return journal;
    }

    @Override
    public List<Journal> findAll() {
        List<Journal> journals = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = daoFactory.createConnection();
            preparedStatement = connection.prepareStatement(PREPARED_FIND_ALL);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while(rs.next()) {
                journals.add(buildJournal(rs));
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
        return journals;
    }

    @Override
    public boolean createJournalRow(Journal journal) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = daoFactory.createConnection();
            preparedStatement = connection.prepareStatement(PREPARED_INSERT);
            preparedStatement.setInt(1, journal.getStudent().getId());
            preparedStatement.setInt(2, journal.getLecture().getId());
            preparedStatement.setDate(3, journal.getDate());
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
}
