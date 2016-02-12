package com.controller;

import com.controller.base.BaseController;
import config.UserSettings;
import exception.ServiceNotAvailableException;
import service.settings.SettingsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static context.EngineModuleContext.getContext;
import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

public class SettingsController extends BaseController {
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher( PREFIX + "settings" + SUFFIX );
        req.setAttribute( "numberOfCorrectAnswersForDeletingUnit", UserSettings.getCorrectAnswersDeleteRequirement() );

        dispatcher.forward( req, resp );
    }

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        String param = req.getParameter( "correctAnswersDeleteRequirement" );
        if ( param == null ) {
            // todo: logger
            System.out.println("correctAnswersDeleteRequirement param is null");
            resp.sendError( SC_INTERNAL_SERVER_ERROR );
            return;
        }

        try{
            int correctAnswersDeleteRequirement = Integer.parseInt( param );
            SettingsService settingsServer = ( SettingsService ) getContext().getBean( "settingsServer" );
            settingsServer.deleteWordOnCorrectAnswers( correctAnswersDeleteRequirement );
            UserSettings.setCorrectAnswersDeleteRequirement( correctAnswersDeleteRequirement );
        } catch ( NumberFormatException e ){
            System.out.println("Cannot parse: " + param);
            resp.sendError( SC_INTERNAL_SERVER_ERROR );
        } catch ( ServiceNotAvailableException e ) {
            e.printStackTrace();
            resp.sendError( SC_INTERNAL_SERVER_ERROR );
        }

    }
}
