package org.example.fulkopinginlamning.dao;

import org.example.fulkopinginlamning.model.Book;
import org.example.fulkopinginlamning.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BookDAO extends GenericDAO<Book, Integer> {

    public BookDAO (){
        super(Book.class);
    }

    public List<Book> searchBook (String searchText) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Book> query = session.createQuery("""
                FROM Book b 
                WHERE LOWER(b.title) LIKE LOWER(:searchText)
                OR LOWER(b.author) LIKE LOWER (:searchText)
                OR LOWER(b.category) LIKE LOWER (:searchText) 
                """, Book.class);
            query.setParameter("searchText", "%" + searchText + "%");
            return query.getResultList();
        }
    }

    public List<Book> findByTitle (String title) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Book> query = session.createQuery("""
                FROM Book b 
                WHERE LOWER(b.title) = LOWER(:title)
                """, Book.class);
            query.setParameter("title", title);
            return query.getResultList();
        }
    }

    public List<Book> findByAuthor (String author) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Book> query = session.createQuery("""
                FROM Book b 
                WHERE LOWER(b.author) = LOWER(:author)
                """, Book.class);
            query.setParameter("author", author);
            return query.getResultList();
        }
    }

    public List<Book> findByCategory (String category) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Book> query = session.createQuery("""
                FROM Book b 
                WHERE LOWER(b.category) = LOWER(:category)
                """, Book.class);
            query.setParameter("category", category);
            return query.getResultList();
        }
    }



}
