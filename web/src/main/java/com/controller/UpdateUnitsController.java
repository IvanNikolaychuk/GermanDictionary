package com.controller;

import com.controller.base.BaseController;
import context.EngineModuleContext;
import dictionary.training.TrainingUnit;
import dictionary.word.WordPair;
import exception.ServiceNotAvailableException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import service.training.TrainingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Math.toIntExact;

/**
 * Assume that units, passed here are already updated on front-end side, and passed
 * here in JSON format.
 */
public class UpdateUnitsController extends BaseController {
    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        String words = req.getParameter( "words" );

        JSONArray jsonUnits;
        try {
            jsonUnits = ( JSONArray ) new JSONParser().parse( words );
        } catch ( ParseException e ) {
            resp.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR );
            return;
        }

        if ( jsonUnits != null && !jsonUnits.isEmpty() ) {
            TrainingService trainingService =
                    ( TrainingService ) EngineModuleContext.getContext().getBean( "trainingService" );

            for ( Object jsonUnit : jsonUnits ) {
                TrainingUnit unit = getUnitFromJson( ( JSONObject ) jsonUnit );
                try {
                    trainingService.updateUnit( unit.getId(), unit );
                    trainingService.deleteUnitIfItIsNotUpToDate( unit.getId() );
                } catch ( ServiceNotAvailableException e ) {
                    resp.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR );
                }
            }
        }
    }

    private TrainingUnit getUnitFromJson( JSONObject jsonUnit ) {
        Long id = ( Long ) jsonUnit.get( "id" );
        Long correctAnswers = ( Long ) jsonUnit.get( "correctAnswers" );
        JSONObject pair = ( JSONObject ) jsonUnit.get( "wordPair" );
        String gerWord = ( String ) ( ( JSONObject ) pair.get( "germanWord" ) ).get( "value" );
        String rusWord = ( String ) ( ( JSONObject ) pair.get( "russianWord" ) ).get( "value" );
        return new TrainingUnit( toIntExact( id ), new WordPair( rusWord, gerWord ), toIntExact( correctAnswers ) );
    }
}
