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
@WebServlet(urlPatterns = "/profile")
public class Profile extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRE);
    private final String LOGIN_FIELD = "login";
    private final String PASSWORD_FIELD = "password";
    private final String ERROR_MESSAGE = "Login or password is wrong.";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = null;
        try {
            Long id = (Long) session.getAttribute("id");
            user = daoFactory.getUserDAO().findById(id.intValue());
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("user", user);
        req.getRequestDispatcher("/profile.jsp").forward(req, resp);
    }

}
