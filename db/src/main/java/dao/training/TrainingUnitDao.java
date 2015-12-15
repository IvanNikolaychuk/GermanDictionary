package dao.training;

import dictionary.training.TrainingUnit;

import java.sql.SQLException;

public interface TrainingUnitDao {
    TrainingUnit getUnit( int id) throws SQLException;
    void insertUnit(TrainingUnit unit) throws SQLException;
    void deleteUnit(int id) throws SQLException;
    void updateUnit(int id, TrainingUnit unit) throws SQLException;
}
