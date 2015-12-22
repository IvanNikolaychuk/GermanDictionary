package service.training;

import dictionary.training.TrainingUnit;
import exception.ServiceNotAvailableException;

import java.sql.SQLException;
import java.util.List;

public interface TrainingService {
    List<TrainingUnit> getLastUnlearnedUnits() throws ServiceNotAvailableException;

    List<TrainingUnit> getLastUnlearnedUnits( int maxUnits ) throws ServiceNotAvailableException;

    List<TrainingUnit> getAllTrainingUnits() throws ServiceNotAvailableException;

    void insertUnit( TrainingUnit unit ) throws ServiceNotAvailableException;
}
