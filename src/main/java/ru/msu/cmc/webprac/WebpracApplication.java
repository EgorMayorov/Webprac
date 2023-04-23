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
		List<Reader> oneName = DAOFactory.getInstance().getReaderDAO().getReaderBySurname("Пивоваров");
		System.out.println(oneName);
		List<Books> books = DAOFactory.getInstance().getReaderDAO().getReaderBooksBySurname("Пивоваров");
		for(Books b:books) {
			System.out.println(b.toString());
		}
//		DAOFactory.getInstance().getReaderDAO().addReader(new Reader("Михаил", "Кочармин",
//				"Дмитриевич", "23-04-2023", "28-09-2002",
//				"ДСЛ МГУ", "879150000000"));
		DAOFactory.getInstance().getBooksDAO().addBook(new Books("Контакт", "Карл Саган",
				"Альпина нон-фикшн", 10, "роман", "21-04-2023"));
	}
}
