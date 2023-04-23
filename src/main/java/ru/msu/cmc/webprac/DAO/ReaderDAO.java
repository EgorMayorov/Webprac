package ru.msu.cmc.webprac.DAO;

import ru.msu.cmc.webprac.tables.Books;
import ru.msu.cmc.webprac.tables.Reader;

import java.util.List;

public abstract class ReaderDAO {
    public abstract void addReader(Reader reader);
    public abstract void deleteReader(Reader reader);
    public abstract void updateReader(Reader reader);
    public abstract Reader getReaderById(Long id);
    public abstract List<Reader> getReaderBySurname(String name);
    public abstract List<Books> getReaderBooksBySurname(String name);
}
