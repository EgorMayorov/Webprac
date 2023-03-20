package ru.msu.cmc.webprac.DAO.impl;

import ru.msu.cmc.webprac.tables.Books;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.msu.cmc.webprac.DAO.BooksDAO;

import static ru.msu.cmc.webprac.utils.HibernateUtil.*;

public class BooksDAOImpl extends BooksDAO {
    public void addBook(Books book) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(book);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateBook(Books book) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(book);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteBook(Books book) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(book);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Books getBookById(Long id) {
        Session session = getSessionFactory().openSession();
        Query<Books> query = session.createQuery("FROM Books WHERE 'Book_ID' = :param", Books.class)
                .setParameter("param", id);
        if (query.getResultList().size() == 0) {
            return null;
        }
        return query.getResultList().get(0);
    }
}
