package com.controller;

import com.controller.base.BaseController;
import context.DbModuleContext;
import context.EngineModuleContext;
import dictionary.training.TrainingUnit;
import dictionary.word.WordPair;
import exception.ServiceNotAvailableException;
import exceptions.word.WordIsNotValidException;
import service.training.TrainingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static dictionary.word.WordType.*;
import static validator.WordsValidator.validateAndGet;

public class AddWordsController extends BaseController {

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher( PREFIX + "add-words" + SUFFIX );
        dispatcher.forward( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();
        String rusWord = params.get( "russian" )[ 0 ];
        String gerWord = params.get( "german" )[ 0 ];

        String validatedRusWord;
        String validatedGerWord;

        try {
            validatedRusWord = validateAndGet( rusWord, RUSSIAN );
            validatedGerWord = validateAndGet( gerWord, GERMAN );
        } catch ( WordIsNotValidException e ) {
            resp.sendError( HttpServletResponse.SC_BAD_REQUEST );
            return;
        }
        TrainingService trainingService =
                ( TrainingService ) EngineModuleContext.getContext().getBean( "trainingService" );

        WordPair wordPair = new WordPair( validatedRusWord, validatedGerWord );
        TrainingUnit unit = new TrainingUnit( wordPair );

        try {
            trainingService.insertUnit( unit );
        }  catch ( ServiceNotAvailableException e ) {
           resp.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR );
        }

    }
}
