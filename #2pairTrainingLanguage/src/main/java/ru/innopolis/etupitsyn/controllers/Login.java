package ru.innopolis.etupitsyn.controllers;

import ru.innopolis.etupitsyn.dao.User;
import ru.innopolis.etupitsyn.dao.factory.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by evgeniytupitsyn on 18.11.2016.
 */
@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRE);
    private final String LOGIN_FIELD = "login";
    private final String PASSWORD_FIELD = "password";
    private final String ERROR_MESSAGE = "Login or password is wrong.";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", null);
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter(LOGIN_FIELD);
        String password = request.getParameter(PASSWORD_FIELD);
        User user = null;
        try {
            user = daoFactory.getUserDAO().find(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("id", user.getId());
            session.setAttribute("login", user.getUsername());
            session.setMaxInactiveInterval(30*30);
            response.sendRedirect("/");
        }
        catch (Exception ex) {
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

}
