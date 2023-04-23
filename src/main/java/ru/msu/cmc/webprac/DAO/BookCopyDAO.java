package ru.msu.cmc.webprac.DAO;

import ru.msu.cmc.webprac.tables.Book_Copy;

public abstract class BookCopyDAO {
    public abstract void addCopy(Book_Copy copy);
    public abstract void updateCopy(Book_Copy copy);
    public abstract void deleteCopy(Book_Copy copy);
    public abstract Book_Copy GetBookCopyByBookName(String name);
    public abstract Book_Copy getCopyById(Long id);
}