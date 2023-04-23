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
		//System.out.println("AAAAAa");
		try {
			SpringApplication.run(WebpracApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("AAAAAa");
		List<Reader> oneName = DAOFactory.getInstance().getReaderDAO().getReaderBySurname("Пивоваров");
		System.out.println(oneName);
		List<Books> books = DAOFactory.getInstance().getReaderDAO().getReaderBooksBySurname("Пивоваров");
		System.out.println(books);
	}
}
