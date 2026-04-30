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


}
