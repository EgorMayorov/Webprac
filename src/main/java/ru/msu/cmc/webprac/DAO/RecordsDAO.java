package ru.msu.cmc.webprac.DAO;

import ru.msu.cmc.webprac.tables.Records;

public abstract class RecordsDAO {
    public abstract void addRecord(Records record);
//    public abstract void deleteRecord(Records records);
    public abstract void updateRecord(Records records);
    public abstract Records returnBook(String surname, String book);
    public abstract Records getRecordById(Long id);
}
