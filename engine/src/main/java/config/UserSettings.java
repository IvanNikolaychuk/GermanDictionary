package config;

import exception.ServiceNotAvailableException;
import service.settings.SettingsService;
import service.training.TrainingService;

import static context.EngineModuleContext.getContext;

public class UserSettings {
    /**
     * represents number of successful attempts the user has to make,
     * before the word would be deleted from his dictionary.
     */
    private static int CORRECT_ANSWERS_DELETE_REQUIREMENT;

    private static final int DEFAULT_CORRECT_ANSWERS_DELETE_REQUIREMENT = 3;

    public synchronized static int getCorrectAnswersDeleteRequirement() {
        if ( CORRECT_ANSWERS_DELETE_REQUIREMENT == 0 ) {
            SettingsService settingsService = ( SettingsService ) getContext().getBean( "settingsServer" );
            try {
                CORRECT_ANSWERS_DELETE_REQUIREMENT = settingsService.getDeleteWordOnCorrectAnswersVal();
            } catch ( ServiceNotAvailableException e ) {
                return DEFAULT_CORRECT_ANSWERS_DELETE_REQUIREMENT;
            }
        }

        return CORRECT_ANSWERS_DELETE_REQUIREMENT;
    }

    public synchronized static void setCorrectAnswersDeleteRequirement( int correctAnswersDeleteRequirement ) {
        CORRECT_ANSWERS_DELETE_REQUIREMENT = correctAnswersDeleteRequirement;
    }
}
