package service.training;

import dao.training.TrainingDao;
import dictionary.training.TrainingUnit;
import exception.ServiceNotAvailableException;

import java.sql.SQLException;
import java.util.List;

public class TrainingServiceImpl implements TrainingService {
    private final TrainingDao trainingDao;
    private static final int UNITS_NUMBER = 5;

    public TrainingServiceImpl( TrainingDao trainingDao ) {
        this.trainingDao = trainingDao;
    }

    public List<TrainingUnit> getLastUnlearnedUnits() throws ServiceNotAvailableException {
        return getLastUnlearnedUnits( UNITS_NUMBER );
    }
    // todo: should throw other exceptions
    public List<TrainingUnit> getLastUnlearnedUnits( int maxUnits ) throws ServiceNotAvailableException {
        try {
            return trainingDao.getUnlearnedUnits( maxUnits );
        } catch ( SQLException e ) {
            throw new ServiceNotAvailableException( e );
        }
    }

    public List<TrainingUnit> getAllTrainingUnits() throws ServiceNotAvailableException {
        try {
            return trainingDao.getAllUnits();
        } catch ( SQLException e ) {
            throw new ServiceNotAvailableException( e );
        }
    }

    public void insertUnit( TrainingUnit unit ) throws ServiceNotAvailableException {
        try {
            trainingDao.insertUnit( unit );
        } catch ( SQLException e ) {
            throw new ServiceNotAvailableException( e );
        }
    }

    public void deleteUnt( String gerWord ) throws ServiceNotAvailableException {
        try {
            trainingDao.deleteUnit( gerWord );
        } catch ( SQLException e ) {
            throw new ServiceNotAvailableException( e );
        }
    }
}
