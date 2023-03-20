package ru.msu.cmc.webprac.DAO.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.msu.cmc.webprac.DAO.RecordsDAO;
import ru.msu.cmc.webprac.tables.Records;

import static ru.msu.cmc.webprac.utils.HibernateUtil.getSessionFactory;

public class RecordsDAOImpl extends RecordsDAO {
    public void addRecord(Records Records) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(Records);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateRecord(Records record) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(record);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteRecord(Records record) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(record);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Records getRecordById(Long id) {
        Session session = getSessionFactory().openSession();
        Query<Records> query = session.createQuery("FROM Records WHERE 'Record_ID' = :param", Records.class)
                .setParameter("param", id);
        if (query.getResultList().size() == 0) {
            return null;
        }
        return query.getResultList().get(0);
    }
}
