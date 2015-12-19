package dao.training;

import dictionary.training.TrainingUnit;

import java.sql.SQLException;
import java.util.List;

public interface TrainingDao {
    TrainingUnit getUnit( int id ) throws SQLException;

    void insertUnit( TrainingUnit unit ) throws SQLException;

    void deleteUnit( int id ) throws SQLException;

    void updateUnit( int id, TrainingUnit unit ) throws SQLException;

    List<TrainingUnit> getUnlearnedUnits( int maxUnits ) throws SQLException;

    List<TrainingUnit> getAllUnits() throws SQLException;
}
