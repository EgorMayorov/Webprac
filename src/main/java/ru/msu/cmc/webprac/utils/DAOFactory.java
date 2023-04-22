package ru.msu.cmc.webprac.utils;

import ru.msu.cmc.webprac.DAO.BooksDAO;
import ru.msu.cmc.webprac.DAO.ReaderDAO;
import ru.msu.cmc.webprac.DAO.RecordsDAO;
import ru.msu.cmc.webprac.DAO.BookCopyDAO;
import ru.msu.cmc.webprac.DAO.impl.BooksDAOImpl;
import ru.msu.cmc.webprac.DAO.impl.ReaderDAOImpl;
import ru.msu.cmc.webprac.DAO.impl.RecordsDAOImpl;
import ru.msu.cmc.webprac.DAO.impl.BookCopyDAOImpl;

public class DAOFactory {
    private static ReaderDAO readerDAO = null;
    private static BooksDAO booksDAO = null;
    private static RecordsDAO recordsDAO = null;
    private static BookCopyDAO copyDAO = null;
    private static DAOFactory instance = null;

    public static synchronized DAOFactory getInstance(){
        if (instance == null){
            instance = new DAOFactory();
        }
        return instance;
    }

    public ReaderDAO getReaderDAO(){
        if (readerDAO == null){
            readerDAO = new ReaderDAOImpl();
        }
        return readerDAO;
    }

    public BooksDAO getBooksDAO(){
        if (booksDAO == null){
            booksDAO = new BooksDAOImpl();
        }
        return booksDAO;
    }

    public RecordsDAO getRecordsDAO(){
        if (recordsDAO == null){
            recordsDAO = new RecordsDAOImpl();
        }
        return recordsDAO;
    }

    public BookCopyDAO getCopyDAO(){
        if (copyDAO == null){
            copyDAO = new BookCopyDAOImpl();
        }
        return copyDAO;
    }
}
