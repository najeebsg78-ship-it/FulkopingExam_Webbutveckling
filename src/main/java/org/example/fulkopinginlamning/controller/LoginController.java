package org.example.fulkopinginlamning.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        try {
            String logout = req.getParameter("logout");
            if (logout != null){
                boolean shouldLogout = Boolean.parseBoolean(logout);
                if (shouldLogout != true){
                    HttpSession session = req.getSession();
                    if (session != null){
                        session.setAttribute("user", null);
                        session.invalidate();
                    }
                } req.setAttribute("message", "du har blivit utloggad");
            }
        } catch (Throwable ex){
            throw new RuntimeException(ex);
        }
    }


}
