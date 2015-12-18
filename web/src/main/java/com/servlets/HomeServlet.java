package com.servlets;

import com.servlets.base.BaseHttpServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends BaseHttpServlet {

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher( PREFIX + "home" + SUFFIX );
        dispatcher.forward( req, resp );
    }
}
