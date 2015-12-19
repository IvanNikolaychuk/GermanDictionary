package com.controller;

import com.controller.base.BaseController;
import context.DbModuleContext;
import context.EngineModuleContext;
import dictionary.training.TrainingUnit;
import exception.ServiceNotAvailableException;
import service.TrainingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DisplayWordsController extends BaseController {
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        TrainingService trainingService =
                ( TrainingService ) EngineModuleContext.getAppContext().getBean( "trainingService" );
        try {
            List<TrainingUnit> unitList = trainingService.getAllTrainingUnits();
            req.setAttribute( "units", unitList );
        }  catch ( ServiceNotAvailableException e ) {
           req.setAttribute( "units", null );
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher( PREFIX + "words" + SUFFIX );
        dispatcher.forward( req, resp );
    }


}