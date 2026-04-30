package org.example.fulkopinginlamning.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.fulkopinginlamning.dao.AccountDAO;
import org.example.fulkopinginlamning.model.Account;

import java.io.IOException;
import java.util.List;

@WebServlet("/account")
public class AccountController extends HttpServlet {

    private static final String ACCOUNT_LIST_VIEW = "/WEB-INF/view/account/list.jsp";
    private static final String ACCOUNT_EDIT_VIEW = "/WEB-INF/view/account/edit.jsp";
    private static final String ACCOUNT_VIEW_VIEW = "/WEB-INF/view/account/view.jsp";

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        AccountDAO accountDAO = new AccountDAO();

        if (req.getParameter("editId") != null) {
            loadAccountAndForward(req, resp, "editId", ACCOUNT_EDIT_VIEW);
            return;
        }

        if (req.getParameter("id") != null) {
            loadAccountAndForward(req, resp, "id", ACCOUNT_VIEW_VIEW);
            return;
        }

        if (req.getParameter("deleteId") != null) {
            String stringId = req.getParameter("deleteId");

            if (stringId != null && !stringId.isEmpty()){
                Integer id = Integer.parseInt(stringId);
                Account account = accountDAO.findById(id);
                if (account != null){
                    accountDAO.delete(account);
                }
            }
            resp.sendRedirect(req.getContextPath() + "/account");
            return;
        }

        List<Account> accounts = accountDAO.findAll();
        req.setAttribute("accounts", accounts);
        req.getRequestDispatcher(ACCOUNT_LIST_VIEW).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountDAO accountDAO = new AccountDAO();
        Account account = new Account();

        String stringId = req.getParameter("id");
        if (stringId != null){
            Integer id = Integer.parseInt(stringId);
            if (id != 0){
                account = accountDAO.findById(id);
            }
        }

        if (account == null) {
            throw new ServletException("Account med id " + stringId + " hittades inte");
        }

        account.setAddress(req.getParameter("address"));
        account.setCountry(req.getParameter("country"));
        account.setFirstname(req.getParameter("firstname"));
        account.setLastname(req.getParameter("lastname"));

        if (account.getId() > 0){
            accountDAO.update(account);
        } else {
            accountDAO.save(account);
        }

    resp.sendRedirect(req.getContextPath() + "/account");

    }

    private void loadAccountAndForward (HttpServletRequest req, HttpServletResponse resp, String parameterName, String viewURI)
            throws ServletException, IOException{

        AccountDAO accountDAO = new AccountDAO();
        String stringId = req.getParameter(parameterName);
        Account account = new Account();

        if (stringId != null && !stringId.isEmpty()){
            Integer id = Integer.parseInt(stringId);
            account = accountDAO.findById(id);
        }

        req.setAttribute("account", account);
        req.getRequestDispatcher(viewURI).forward(req, resp);
    }
















}
