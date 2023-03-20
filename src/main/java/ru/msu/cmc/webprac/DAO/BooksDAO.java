package ru.msu.cmc.webprac.DAO;

import ru.msu.cmc.webprac.tables.Books;

public abstract class BooksDAO {
    public abstract void addBook(Books book);
    public abstract void deleteBook(Books book);
    public abstract void updateBook(Books book);
    public abstract Books getBookById(Long id);

}
