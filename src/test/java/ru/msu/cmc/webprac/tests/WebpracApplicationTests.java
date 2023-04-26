package ru.msu.cmc.webprac.tests;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.boot.test.context.SpringBootTest;
import ru.msu.cmc.webprac.tables.Books;
import ru.msu.cmc.webprac.tables.Reader;
import ru.msu.cmc.webprac.utils.DAOFactory;

import org.junit.jupiter.api.*;

import java.awt.print.Book;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WebpracApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void deleteReaderTest () {
		DAOFactory.getInstance().getReaderDAO().deleteReader(DAOFactory.getInstance().getReaderDAO().getReaderBySurname("Кочармин"));
		Reader reader = DAOFactory.getInstance().getReaderDAO().getReaderBySurname("Кочармин");
		assertNull(reader);
	}

	@Test
	public void addReaderTest () {
		DAOFactory.getInstance().getReaderDAO().addReader(new Reader("Михаил", "Кочармин",
				"Дмитриевич", "23-04-2023", "28-09-2002",
				"ДСЛ МГУ", "879150000000"));
		Reader reader = DAOFactory.getInstance().getReaderDAO().getReaderBySurname("Кочармин");
		assertNotNull(reader);
	}

	@Test
	public void getReaderBySurnameTest () {
		Reader reader = DAOFactory.getInstance().getReaderDAO().getReaderBySurname("Пивоваров");
		assertNotNull(reader);
	}

	@Test
	public void getReaderByIDTest () {
		Reader reader = DAOFactory.getInstance().getReaderDAO().getReaderById(5L);
		assertNotNull(reader);
	}

	@Test
	public void getBookByNameTest () {
		Books book = DAOFactory.getInstance().getBooksDAO().getBookByName("Контакт");
		assertNotNull(book);
	}

	@Test
	public void getBookByIDTest () {
		Books book = DAOFactory.getInstance().getBooksDAO().getBookById(1L);
		assertNotNull(book);
	}

	@Test
	public void addBookTest () {
		DAOFactory.getInstance().getBooksDAO().addBook(new Books("Контакт", "Карл Саган",
				"Альпина нон-фикшн", 10, "роман", "21-04-2023"));
		Books book = DAOFactory.getInstance().getBooksDAO().getBookByName("Контакт");
		assertNotNull(book);
	}

	@Test
	public void deleteBookTest () {
		Books book = DAOFactory.getInstance().getBooksDAO().getBookByName("Контакт");
		DAOFactory.getInstance().getBooksDAO().deleteBook(book);
		book = DAOFactory.getInstance().getBooksDAO().getBookByName("Контакт");
		assertNull(book);
	}

	@Test
	public void getReadersBooks () {
		List<Books> books = DAOFactory.getInstance().getReaderDAO().getReaderBooksBySurname("Пивоваров");
		assertNotNull(books);
	}

	@Test
	public void getBooksReaders () {
		List<Reader> readers = DAOFactory.getInstance().getBooksDAO().getReadersByBook("Приключения Эраста Фандорина. Азазель");
		assertNotNull(readers);
	}
}
