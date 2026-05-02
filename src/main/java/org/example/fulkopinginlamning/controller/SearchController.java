package org.example.fulkopinginlamning.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.fulkopinginlamning.dao.BookDAO;
import org.example.fulkopinginlamning.model.Book;

import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchController extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String searchText = request.getParameter("q");
        if (searchText != null && !searchText.isEmpty()) {
            BookDAO bookDAO = new BookDAO();
            List<Book> books = bookDAO.searchBook(searchText);
            request.setAttribute("books", books);
            request.setAttribute("searchText", searchText);
        }
        request.getRequestDispatcher("/WEB-INF/view/search.jsp").forward(request, response);

    }

}
