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
import java.util.Date;

@WebServlet("/loan")
public class LoanController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        User user = (User) session.getAttribute("user");
        Integer bookId = Integer.parseInt(req.getParameter("bookId"));
        String action = req.getParameter("action");

        LoanDAO loanDAO = new LoanDAO();

        if ("borrow".equals(action)) {
            Loan loan = new Loan();
            loan.setBookId(bookId);
            loan.setUserId(user.getUserId());
            loan.setStartDate(new Date());
            loan.setEndDate(null);
            loanDAO.save(loan);

        } else if ("return".equals(action)) {
            Loan loan = loanDAO.findActiveLoanByBookId(bookId);
            if (loan != null) {
                loan.setEndDate(new Date());
                loanDAO.update(loan);
            }
        }

        resp.sendRedirect(req.getContextPath() + "/book?id=" + bookId);
    }
}