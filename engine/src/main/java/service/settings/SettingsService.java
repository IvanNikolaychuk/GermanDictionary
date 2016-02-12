package service.settings;

import dao.settings.SettingsDao;
import exception.ServiceNotAvailableException;

import java.sql.SQLException;

public class SettingsService {
    private final SettingsDao settingsDao;

    public SettingsService( SettingsDao settingsDao ) {
        this.settingsDao = settingsDao;
    }

    // todo: check for words.
    public void deleteWordOnCorrectAnswers( int numberOfAnswers ) throws ServiceNotAvailableException {
        try {
            settingsDao.setDeleteWordOnCorrectAnswers( numberOfAnswers );
        } catch ( SQLException e ) {
            throw new ServiceNotAvailableException( e );
        }
    }

    public int getDeleteWordOnCorrectAnswersVal() throws ServiceNotAvailableException {
        try {
            return settingsDao.getDeleteWordOnCorrectAnswersVal();
        } catch ( SQLException e ) {
            throw new ServiceNotAvailableException( e );
        }
    }
}
