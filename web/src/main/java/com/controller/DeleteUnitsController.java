package com.controller;

import com.controller.base.BaseController;
import context.DbModuleContext;
import context.EngineModuleContext;
import dao.training.TrainingDao;
import dictionary.training.TrainingUnit;
import exception.ServiceNotAvailableException;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import service.training.TrainingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteUnitsController extends BaseController {
    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        String words = req.getParameter( "words" );

        JSONArray wordsArr;
        try {
            JSONParser parser = new JSONParser();
            wordsArr = ( JSONArray ) parser.parse( words );
        } catch ( ParseException e ) {
            resp.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR );
            return;
        }

        if ( wordsArr != null && !wordsArr.isEmpty() ) {
            TrainingService trainingService =
                    ( TrainingService ) EngineModuleContext.getContext().getBean( "trainingService" );

            for ( Object word : wordsArr ) {
                String gerWord = ( String ) word;
                try {
                    trainingService.deleteUnt( gerWord );
                } catch ( ServiceNotAvailableException e ) {
                    resp.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR );
                    return;
                }
            }
        }
    }
}
