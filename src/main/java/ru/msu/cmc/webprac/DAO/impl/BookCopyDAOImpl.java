package ru.msu.cmc.webprac.DAO.impl;

import ru.msu.cmc.webprac.tables.Book_Copy;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.msu.cmc.webprac.DAO.BookCopyDAO;

import static ru.msu.cmc.webprac.utils.HibernateUtil.*;

public class BookCopyDAOImpl extends BookCopyDAO {
    public void addCopy(Book_Copy copy) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(copy);
        session.getTransaction().commit();
        session.close();
    }

//    @Override
//    public void updateCopy(Book_Copy copy) {
//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//        session.merge(copy);
//        session.getTransaction().commit();
//        session.close();
//    }

    @Override
    public void deleteCopy(Book_Copy copy) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(copy);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Book_Copy getCopyById(Long id) {
        Session session = getSessionFactory().openSession();
        Query<Book_Copy> query = session.createQuery("FROM Book_Copy WHERE 'Copy_ID' = :param",
                        Book_Copy.class).setParameter("param", id);
        if (query.getResultList().size() == 0) {
            return null;
        }
        return query.getResultList().get(0);
    }
}
