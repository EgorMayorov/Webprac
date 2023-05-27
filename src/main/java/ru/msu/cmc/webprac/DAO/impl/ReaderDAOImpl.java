package ru.msu.cmc.webprac.DAO.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.msu.cmc.webprac.DAO.ReaderDAO;
import ru.msu.cmc.webprac.tables.Books;
import ru.msu.cmc.webprac.tables.Reader;
import ru.msu.cmc.webprac.utils.HibernateUtil;

import java.util.List;

import static ru.msu.cmc.webprac.utils.HibernateUtil.getSessionFactory;

public class ReaderDAOImpl extends ReaderDAO {
    public void addReader(Reader reader) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(reader);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateReader(Reader reader) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(reader);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteReader(Reader reader) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(reader);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Reader getReaderById(Long id) {
        Reader result = null;
        Session session = getSessionFactory().openSession();
        Query<Reader> query = session.createQuery("FROM Reader WHERE reader_id = :param", Reader.class)
                .setParameter("param", id);
        if (query.getResultList().size() != 0) {
            result = query.getSingleResult();
        }
        return result;
    }

    @Override
    public List<Reader> getReaderBySurname(String surname) {
        List<Reader> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Reader> query = session.createQuery("FROM Reader WHERE surname LIKE :surname", Reader.class)
                .setParameter("surname", "%" + surname + "%");
        if (query.getResultList().size() != 0) {
            result = query.getResultList();
        }
        return result;
    }

    @Override
    public List<Books> getReaderBooksBySurname(String surname) {
        java.util.List<Books> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Books> query = session.createQuery("Select DISTINCT bok " +
                        "FROM Records rec " +
                        "left join rec.reader_id read " +
                        "left join rec.copy_id cop " +
                        "left join cop.book_id bok " +
                        "Where read.surname LIKE :surname", Books.class)
                .setParameter("surname", "%" + surname + "%");
//                .setParameter("surname", "%" + surname + "%");
        if (query.getResultList().size() != 0) {
            result = query.getResultList();
        }
        return result;
    }

    @Override
    public List<Reader> getAllReader() {
        List<Reader> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Reader> query = session.createQuery("FROM Reader", Reader.class);
        if (query.getResultList().size() != 0) {
            result = query.getResultList();
        }
        return result;
    }

    @Override
    public List<Books> getTakenReaderBooks (String surname) {
        List<Books> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Books> query = session.createQuery("Select bok " +
                        "FROM Records rec " +
                        "left join rec.reader_id read " +
                        "left join rec.copy_id cop " +
                        "left join cop.book_id bok " +
                        "Where read.surname LIKE :surname " +
                        "and cop.is_taken_now LIKE 'Yes'", Books.class)
                .setParameter("surname", "%" + surname + "%");
        if (query.getResultList().size() != 0) {
            result = query.getResultList();
        }
        return result;
    }

    @Override
    public List<Reader> getReadersWithBooks () {
        List<Reader> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Reader> query = session.createQuery("SELECT DISTINCT read " +
                "FROM Records rec " +
                "LEFT JOIN rec.reader_id read " +
                "LEFT JOIN rec.copy_id cop " +
                "WHERE cop.is_taken_now LIKE 'Yes' " +
                "AND rec.returning_date is NULL", Reader.class);
        if (query.getResultList().size() != 0) {
            result = query.getResultList();
        }
        return result;
    }
}
