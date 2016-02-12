package service.training;

import dictionary.training.TrainingUnit;
import exception.ServiceNotAvailableException;

import java.sql.SQLException;
import java.util.List;

public interface TrainingService {
    List<TrainingUnit> getLastUnlearnedUnits() throws ServiceNotAvailableException;

    List<TrainingUnit> getLastUnlearnedUnits( int maxUnits ) throws ServiceNotAvailableException;

    List<TrainingUnit> getAllTrainingUnits() throws ServiceNotAvailableException;

    TrainingUnit getUnit( int id ) throws ServiceNotAvailableException;

    void insertUnit( TrainingUnit unit ) throws ServiceNotAvailableException;

    void deleteUnt( String gerWord ) throws ServiceNotAvailableException;

    void updateUnit( int id, TrainingUnit unit ) throws ServiceNotAvailableException;

    void deleteUnitIfItIsNotUpToDate( int unitId ) throws ServiceNotAvailableException;

}
