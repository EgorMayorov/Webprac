package ru.msu.cmc.webprac.DAO;

import ru.msu.cmc.webprac.tables.Books;
import ru.msu.cmc.webprac.tables.Reader;

import java.util.List;

public abstract class BooksDAO {
    public abstract void addBook(Books book);
    public abstract void deleteBook(Books book);
    public abstract void updateBook(Books book);
    public abstract Books getBookById(Long id);
    public abstract List<Books> getBookByName(String name);
    public abstract List<Reader> getReadersByBook(String name);
    public abstract List<Books> getAllBooks();
}
