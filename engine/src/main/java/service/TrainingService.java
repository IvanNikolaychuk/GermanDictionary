package service;

import dictionary.training.TrainingUnit;

import java.sql.SQLException;
import java.util.List;

public interface TrainingService {
    List<TrainingUnit> getLastUnlearnedUnits() throws SQLException;

    List<TrainingUnit> getLastUnlearnedUnits( int maxUnits ) throws SQLException;
}
