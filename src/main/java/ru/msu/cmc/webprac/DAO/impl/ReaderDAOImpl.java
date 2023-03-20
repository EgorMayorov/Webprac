package ru.msu.cmc.webprac.DAO.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.msu.cmc.webprac.DAO.ReaderDAO;
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
        Session session = getSessionFactory().openSession();
        Query<Reader> query = session.createQuery("FROM Reader WHERE 'Reader_ID' = :param", Reader.class)
                .setParameter("param", id);
        if (query.getResultList().size() == 0) {
            return null;
        }
        return query.getResultList().get(0);
    }

    public List<Reader> getReaderBySurame(String surname) {
        java.util.List<Reader> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Reader> query = session.createQuery("FROM Reader WHERE surname LIKE :surname", Reader.class)
                .setParameter("surname", "%" + surname + "%");
        if (query.getResultList().size() != 0) {
            result = query.getResultList();
        }
        return result;
    }
}