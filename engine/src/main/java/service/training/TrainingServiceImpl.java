package service.training;

import config.UserSettings;
import dao.training.TrainingDao;
import dictionary.training.TrainingUnit;
import exception.ServiceNotAvailableException;

import java.sql.SQLException;
import java.util.List;


public class TrainingServiceImpl implements TrainingService {
    private final TrainingDao trainingDao;
    private static final int DEFAULT_UNITS_NUMBER = 5;

    public TrainingServiceImpl( TrainingDao trainingDao ) {
        this.trainingDao = trainingDao;
    }

    public List<TrainingUnit> getLastUnlearnedUnits() throws ServiceNotAvailableException {
        return getLastUnlearnedUnits( DEFAULT_UNITS_NUMBER );
    }

    public List<TrainingUnit> getLastUnlearnedUnits( int maxUnits ) throws ServiceNotAvailableException {
        try {
            return trainingDao.getUnits( maxUnits );
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

    public TrainingUnit getUnit( int id ) throws ServiceNotAvailableException {
        try {
            return trainingDao.getUnit( id );
        } catch ( SQLException e ) {
            throw new ServiceNotAvailableException( e );
        }
    }


    public void updateUnit( int id, TrainingUnit newUnit ) throws ServiceNotAvailableException {
        try {
            trainingDao.updateUnit( id, newUnit );
        } catch ( SQLException e ) {
            throw new ServiceNotAvailableException( e );
        }
    }

    public void deleteUnitIfItIsNotUpToDate( int unitId ) throws ServiceNotAvailableException {
        TrainingUnit unit = getUnit( unitId );
        if ( unit.getCorrectAnswers() >= UserSettings.getCorrectAnswersDeleteRequirement() ) {
            try {
                trainingDao.deleteUnit( unitId );
            } catch ( SQLException e ) {
                // // TODO: 11.02.2016 Logger
                System.out.println( "Unable to delete unit with id = " + unitId );
            }
        }
    }

}
