package org.example.fulkopinginlamning.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try {
            if (sessionFactory == null){
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");

                sessionFactory = configuration.buildSessionFactory();
            }
            return sessionFactory;
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public static SessionFactory getSessionFactory(){return sessionFactory;}
    public static void shutDown(){sessionFactory.close();}
}
