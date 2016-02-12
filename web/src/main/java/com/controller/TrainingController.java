package com.controller;

import com.controller.base.BaseController;
import com.google.gson.Gson;
import dictionary.training.TrainingUnit;
import exception.ServiceNotAvailableException;
import service.training.TrainingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static context.EngineModuleContext.getContext;

public class TrainingController extends BaseController {
    private List<TrainingUnit> units;

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        Gson gson = new Gson();
        TrainingService trainingService = ( TrainingService ) getContext().getBean( "trainingService" );
        try {
            units = trainingService.getLastUnlearnedUnits();
        } catch ( ServiceNotAvailableException e ) {
            resp.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR );
//            dispatcher = req.getRequestDispatcher( PREFIX + "home" + SUFFIX );
        }

        resp.setContentType( "text/html" );
        resp.setCharacterEncoding( "UTF-8" );
        try ( PrintWriter out = resp.getWriter() ) {
            out.write( gson.toJson( units ) );
        }

    }

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher( PREFIX + "training" + SUFFIX );

        dispatcher.forward( req, resp );
    }
}
