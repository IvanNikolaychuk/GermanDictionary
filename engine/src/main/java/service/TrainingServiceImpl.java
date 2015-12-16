package service;

import dao.training.TrainingDao;
import dictionary.training.TrainingUnit;

import java.sql.SQLException;
import java.util.List;

public class TrainingServiceImpl implements TrainingService {
    private final TrainingDao trainingDao;
    private static final int UNITS_NUMBER = 5;

    public TrainingServiceImpl( TrainingDao trainingDao ) {
        this.trainingDao = trainingDao;
    }

    public List<TrainingUnit> getLastUnlearnedUnits() throws SQLException {
        return getLastUnlearnedUnits( UNITS_NUMBER );
    }
    // todo: should throw other exceptions
    public List<TrainingUnit> getLastUnlearnedUnits( int maxUnits ) throws SQLException {
        return trainingDao.getUnlearnedUnits( maxUnits );
    }
}
