package ru.innopolis.nikn.controllers;

import ru.innopolis.nikn.dao.User;
import ru.innopolis.nikn.dao.factory.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Nikolay on 18.11.2016.
 */
@WebServlet(urlPatterns = "/register")
public class Register extends HttpServlet {

    private final boolean validate = true;
    private DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRE);
    private final String USERNAME_FIELD = "username";
    private final String FIRST_NAME_FIELD = "first_name";
    private final String LAST_NAME_FIELD = "last_name";
    private final String PASSWORD_FIELD = "password";
    private final String CONFIRM_PWD_FIELD = "confirm";
    private final String EMAIL_FIELD = "email";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", null);
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String ERROR_MESSAGE = "Password error";
        String username = request.getParameter(USERNAME_FIELD);
        String firstName = request.getParameter(FIRST_NAME_FIELD);
        String lastName = request.getParameter(LAST_NAME_FIELD);
        String pwd = request.getParameter(PASSWORD_FIELD);
        String confirm_pwd = request.getParameter(CONFIRM_PWD_FIELD);
        String email = request.getParameter(EMAIL_FIELD);
        if(pwd.equals(confirm_pwd)) {
            User.Builder builder = new User.Builder();
            builder.withUsername(username)
                    .withEmail(email)
                    .withFirstName(firstName)
                    .withLastName(lastName)
                    .withPassword(pwd);
            User user = new User(builder);
            try {
                daoFactory.getUserDAO().createUser(user);
                response.sendRedirect("/login");
            } catch (Exception e) {
                ERROR_MESSAGE = e.getMessage();
                request.setAttribute("message", ERROR_MESSAGE);
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        }
        else {
            request.setAttribute("message", ERROR_MESSAGE);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }

    }

}
