package org.example.fulkopinginlamning.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.fulkopinginlamning.dao.BookDAO;
import org.example.fulkopinginlamning.dao.LoanDAO;
import org.example.fulkopinginlamning.model.Book;
import org.example.fulkopinginlamning.model.Loan;

import java.io.IOException;

@WebServlet ("/book")
public class BookController  extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParameter = request.getParameter("id");
        if (idParameter == null){
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        BookDAO bookDAO = new BookDAO();
        LoanDAO loanDAO = new LoanDAO();

        Book book = bookDAO.findById(Integer.parseInt(idParameter));
        Loan activeLoan = loanDAO.findActiveLoanByBookId(book.getBookId());

        request.setAttribute("book", book);
        request.setAttribute("activeLoan", activeLoan);
        request.getRequestDispatcher("/WEB-INF/view/book.jsp").forward(request, response);


    }

}
