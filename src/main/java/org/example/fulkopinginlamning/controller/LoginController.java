package org.example.fulkopinginlamning.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.fulkopinginlamning.dao.UserDAO;
import org.example.fulkopinginlamning.model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.util.Date;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private static final String LOGIN_VIEW = "/WEB-INF/view/login.jsp";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String logout = req.getParameter("logga ut");

        if ("true".equals (logout)){
            HttpSession session = req.getSession(false);

            if (session != null){
                session.invalidate();
            }
            req.setAttribute("message", "du har blivit utlogggad");
        }
        req.getRequestDispatcher(LOGIN_VIEW).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String username = req.getParameter("username") == null? "": req.getParameter("username");
        String password = req.getParameter("password") == null? "": req.getParameter("password");
        String error = null;

        if (username.isEmpty() || password.isEmpty()){
            error = "fyll i username och lösenord";
        }

        UserDAO userDAO = new UserDAO();
        User user = null;

        try {
            if (error == null){
                user = userDAO.findByUsername(username);
                if (user == null){
                    error = "hittade inte user";
                } else {
                    if (BCrypt.checkpw(password, user.getPassword())) {
                        user.setLastLogin(new Date());
                        userDAO.update(user);

                        HttpSession session = req.getSession();
                        session.setAttribute("user", user);
                    } else{
                        error = "fel lösenord";
                    }
                }
            }
        } catch (Exception e){
            error = "error" + e.getMessage();
            System.out.println(e);
        }

        if (error != null){
            req.setAttribute("error", error);
            req.setAttribute("username", username);
            req.getRequestDispatcher(LOGIN_VIEW).forward(req, resp);
            return;
        }

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
