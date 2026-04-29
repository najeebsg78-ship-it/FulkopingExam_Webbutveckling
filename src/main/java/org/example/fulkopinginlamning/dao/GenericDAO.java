package org.example.fulkopinginlamning.dao;

import org.example.fulkopinginlamning.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public abstract class GenericDAO<T, ID extends Serializable> {

    private final Class<T> entityClass;

    public GenericDAO(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    public T findById(ID id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(entityClass, id);
        }
    }

    public List<T> findAll(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<T> query = session.createQuery("FROM " + entityClass.getSimpleName(), entityClass);
            return query.getResultList();
        }
    }

    public void save (T entity) {
        executeTransaction(session -> session.persist(entity));
    }

    public void update(T entity){
        executeTransaction(session -> session.merge(entity));
    }

    public void delete (T entity){
        executeTransaction(session -> {
           T managedEntity = session.merge(entity);
           session.remove(managedEntity);
        });
    }

    private void executeTransaction (HibernateAction action){
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            action.execute(session);
            tx.commit();
        } catch (Exception ex){
            if (tx == null) tx.rollback();
            throw ex;
        }

    }

    @FunctionalInterface
    private interface HibernateAction {
        void execute(Session session);
    }


}
