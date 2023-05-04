package ru.msu.cmc.webprac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.msu.cmc.webprac.tables.Books;
import ru.msu.cmc.webprac.tables.Reader;
import ru.msu.cmc.webprac.tables.Records;
import ru.msu.cmc.webprac.utils.DAOFactory;

import java.util.List;

@SpringBootApplication
public class WebpracApplication {

	public static void main(String[] args) {

		try {
			SpringApplication.run(WebpracApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}

//		Reader oneName = DAOFactory.getInstance().getReaderDAO().getReaderBySurname("Пивоваров");
//		System.out.println(oneName);
//		List<Books> books = DAOFactory.getInstance().getReaderDAO().getReaderBooksBySurname("Пивоваров");
//		for(Books b:books) {
//			System.out.println(b.toString());
//		}

//		DAOFactory.getInstance().getReaderDAO().addReader(new Reader("Михаил", "Кочармин",
//				"Дмитриевич", "23-04-2023", "28-09-2002",
//				"ДСЛ МГУ", "879150000000"));

//		DAOFactory.getInstance().getBooksDAO().addBook(new Books("Контакт", "Карл Саган",
//				"Альпина нон-фикшн", 10, "роман", "21-04-2023"));

//		Books book = DAOFactory.getInstance().getBooksDAO().getBookByName("Контакт");
//		book.setAbout("Олег сказал, что книга крутая!");
//		DAOFactory.getInstance().getBooksDAO().updateBook(book);

//		Reader reader = DAOFactory.getInstance().getReaderDAO().getReaderBySurname("Кочармин");
//		reader.setAddress("ГЗ МГУ");
//		DAOFactory.getInstance().getReaderDAO().updateReader(reader);

//		Books book = DAOFactory.getInstance().getBooksDAO().getBookByName("Контакт");
//		DAOFactory.getInstance().getBooksDAO().deleteBook(book);
//
//		Reader reader = DAOFactory.getInstance().getReaderDAO().getReaderBySurname("Кочармин");
//		DAOFactory.getInstance().getReaderDAO().deleteReader(reader);

//		DAOFactory.getInstance().getRecordsDAO().addRecord(new Records("Кочармин", "Контакт"));

//		List<Books> books1 = DAOFactory.getInstance().getReaderDAO().getReaderBooksBySurname("Кочармин");
//		for(Books b:books1) {
//			System.out.println(b.toString());
//		}

//		DAOFactory.getInstance().getRecordsDAO().returnBook("Кочармин", "Контакт");

//		List<Reader> readers = DAOFactory.getInstance().getBooksDAO().getReadersByBook("Приключения Эраста Фандорина. Азазель");
//		for(Reader r:readers) {
			System.out.println("Here!");
//		}
	}
}
