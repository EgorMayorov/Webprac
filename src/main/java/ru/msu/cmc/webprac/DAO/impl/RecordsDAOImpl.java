package ru.msu.cmc.webprac.DAO.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.msu.cmc.webprac.DAO.RecordsDAO;
import ru.msu.cmc.webprac.tables.Book_Copy;
import ru.msu.cmc.webprac.tables.Records;
import ru.msu.cmc.webprac.utils.DAOFactory;

import java.util.Date;

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
    public void returnBook(String surname, String book){
        Session session = getSessionFactory().openSession();
        Query<Records> query = session.createQuery("SELECT rec " +
                "FROM Records rec " +
                "LEFT JOIN rec.reader_id rd " +
                "LEFT JOIN rec.copy_id cp " +
                "LEFT JOIN cp.book_id bk " +
                "WHERE bk.name LIKE :book " +
                        "AND rd.surname LIKE :surname " +
                        "AND cp.is_taken_now LIKE 'Yes'", Records.class)
                .setParameter("book", book).setParameter("surname", surname);
        Records record = query.getResultList().get(0);

        Date current_date = new Date(System.currentTimeMillis());
        record.setReturning_date(current_date);
        session.close();

        session = getSessionFactory().openSession();
        Query<Book_Copy> query2 = session.createQuery("SELECT cp " +
                        "FROM Records rec " +
                        "LEFT JOIN rec.copy_id cp " +
                        "WHERE cp.is_taken_now LIKE 'Yes'", Book_Copy.class);
        Book_Copy copy = query2.getSingleResult();

        copy.setIs_taken_now("No");
        DAOFactory.getInstance().getCopyDAO().updateCopy(copy);
        DAOFactory.getInstance().getRecordsDAO().updateRecord(record);
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
