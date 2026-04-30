package org.example.fulkopinginlamning.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.fulkopinginlamning.dao.UserDAO;
import org.example.fulkopinginlamning.model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;


@WebServlet("/register")
public class RegisterController extends HttpServlet {

    private static final String REGISTER_VIEW = "/WEB-INF/view/register.jsp";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(REGISTER_VIEW).forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username") == null? "": req.getParameter("username");
        String password1 = req.getParameter("password1") == null? "": req.getParameter("password1");
        String password2 = req.getParameter("password2") == null? "": req.getParameter("password2");
        String error = null;

        if (username.isBlank() || password1.isBlank() || password2.isBlank()) {
            error = "fyll i alla fält";
        } else if (!password1.equals(password2)){
            error = "lösenordet matchar inte";
        }

        if (error != null){
            req.setAttribute("error", error);
            req.setAttribute("username", username);
            req.setAttribute("password1", password1);
            req.setAttribute("password2", password2);

            try{
                System.out.println("återgå till register page med error" + error);
                req.getRequestDispatcher(REGISTER_VIEW).forward(req, resp);
            } catch (Throwable ex){
                throw ex;
            }
            return;
        }

        String hashpassword = BCrypt.hashpw(password1, BCrypt.gensalt());

        User user = new User();
        user.setUsername(username);
        user.setPassword(hashpassword);

        UserDAO userDAO = new UserDAO();

        try {
            userDAO.save(user);
            req.setAttribute("success", "Användare har skapats");
        } catch (Throwable ex) {
            req.setAttribute("error", "Användare kunde inte skapas");
            System.out.println(ex.getMessage());
        }


        req.getRequestDispatcher(REGISTER_VIEW).forward(req, resp);
    }
}
