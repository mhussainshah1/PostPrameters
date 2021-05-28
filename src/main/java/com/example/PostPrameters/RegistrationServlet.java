package com.example.PostPrameters;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {
    //request
    //web browser -> web server -> database server

    //response
    //web browser <- web server <- database server

    //Get
    //getting / reading / retrieving data from web server which gets data from database server.
    //the data is not changed while reading
    //data can be reloaded upon refreshing of browser
    //display the parameter in the url

    //doGet() - forwarding the request
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
    }

    //Post
    //posting / writing /sending data to the web server which sends into database server
    //data is changed when writing
    //data can't send upon refreshing of browser.
    //Hide the parameters with in the request. They are not displayed in the url.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //processing post request form
        System.out.println("Request Received");
//        request.getParameterMap().forEach((x, y) -> System.out.print(x + " = " + Arrays.toString(y) + ","));

        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (email.equals("")  || name .equals("") || age .equals("") || password.equals("") || confirmPassword .equals("")) {
            request.setAttribute("error", "You are missing of the inputs");
            doGet(request, response);
        } else {
            if (!password.equalsIgnoreCase(confirmPassword)) {
                request.setAttribute("error", "The passwords do not match");
                doGet(request, response);
            } else {
                //var account = new Account();
                System.out.println("The account has been created!!!");
            }
        }

    }
}
