package org.example.fulkopinginlamning.dao;

import org.example.fulkopinginlamning.model.Loan;
import org.example.fulkopinginlamning.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LoanDAO extends GenericDAO<Loan, Integer> {

    public LoanDAO (){
        super(Loan.class);
    }

    public List<Loan> findActiveLoans(Integer loanId){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Loan> query = session.createQuery("FROM Loan WHERE endDate IS NULL", Loan.class);
            return query.getResultList();

        }catch (Throwable ex){
            throw new RuntimeException(ex);
        }
    }

    public Loan findActiveLoanByBookId (Integer bookId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Loan> query = session.createQuery("FROM Loan WHERE bookId = :bookId AND endDate IS NULL", Loan.class);
            query.setParameter("bookId", bookId);
            return query.uniqueResult();

        }catch (Throwable ex) {throw new RuntimeException(ex); }

    }

    public List<Loan> findLoansByUserId(Integer userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Loan> query = session.createQuery(
                    "FROM Loan WHERE userId = :userId ORDER BY startDate DESC", Loan.class);
            query.setParameter("userId", userId);
            return query.getResultList();
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
    }


}
