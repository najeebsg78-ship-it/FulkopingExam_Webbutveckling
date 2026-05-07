package org.example.fulkopinginlamning.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.fulkopinginlamning.dao.LoanDAO;
import org.example.fulkopinginlamning.model.Loan;
import org.example.fulkopinginlamning.model.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/history")
public class HistoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        User user = (User) session.getAttribute("user");
        LoanDAO loanDAO = new LoanDAO();
        List<Loan> loans = loanDAO.findLoansByUserId(user.getUserId());

        req.setAttribute("loans", loans);
        req.getRequestDispatcher("/WEB-INF/view/history.jsp").forward(req, resp);
    }
}