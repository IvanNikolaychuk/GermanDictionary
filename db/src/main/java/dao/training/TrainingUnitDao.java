package dao.training;

import dictionary.training.TrainingWordPairUnit;

import java.sql.SQLException;

public interface TrainingUnitDao {
    TrainingWordPairUnit getUnit(int id) throws SQLException;
    void insertUnit(TrainingWordPairUnit unit) throws SQLException;
    void deleteUnit(int id) throws SQLException;
    void updateUnit(int id, TrainingWordPairUnit unit) throws SQLException;
}
