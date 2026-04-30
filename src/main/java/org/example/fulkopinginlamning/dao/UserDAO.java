package org.example.fulkopinginlamning.dao;

import org.example.fulkopinginlamning.model.User;
import org.example.fulkopinginlamning.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO extends GenericDAO<User, Integer> {

    public UserDAO (){
        super(User.class);
    }

    public User findByUsername(String username){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE username = :username", User.class);
            query.setParameter("username", username);
            List<User> users = query.getResultList();
            if (users.isEmpty()){
                return null;
            } else {
                return users.getFirst();
            }

        } catch (Throwable ex){
            throw new RuntimeException(ex);
        }
    }

}
