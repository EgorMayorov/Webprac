package ru.msu.cmc.webprac.tests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.msu.cmc.webprac.tables.Book_Copy;
import ru.msu.cmc.webprac.tables.Books;
import ru.msu.cmc.webprac.tables.Reader;
import ru.msu.cmc.webprac.tables.Records;
import ru.msu.cmc.webprac.utils.DAOFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WebpracApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void deleteReaderTest () {
		DAOFactory.getInstance().getReaderDAO().addReader(new Reader("Михаил", "Кочармин11",
				"Дмитриевич", "23-04-2023", "28-09-2002",
				"ДСЛ МГУ", "879150000000"));
		Reader reader = DAOFactory.getInstance().getReaderDAO().getReaderBySurname("Кочармин11").get(0);
		DAOFactory.getInstance().getReaderDAO().deleteReader(reader);
		List<Reader> reader1 = DAOFactory.getInstance().getReaderDAO().getReaderBySurname("Кочармин11");
		assertNull(reader1);
	}

	@Test
	public void addReaderTest () {
		DAOFactory.getInstance().getReaderDAO().addReader(new Reader("Михаил", "Кочармин12",
				"Дмитриевич", "23-04-2023", "28-09-2002",
				"ДСЛ МГУ", "879150000000"));
		Reader reader = DAOFactory.getInstance().getReaderDAO().getReaderBySurname("Кочармин12").get(0);
		assertNotNull(reader);
		reader = DAOFactory.getInstance().getReaderDAO().getReaderBySurname("Кочармин12").get(0);
		DAOFactory.getInstance().getReaderDAO().deleteReader(reader);
	}

	@Test
	public void getReaderBySurnameTest () {
		List<Reader> reader = DAOFactory.getInstance().getReaderDAO().getReaderBySurname("Пивоваров");
		assertNotNull(reader);
	}

	@Test
	public void getReaderByIDTest () {
		Reader reader = DAOFactory.getInstance().getReaderDAO().getReaderById(5L);
		assertNotNull(reader);
	}

	@Test
	public void getBookByNameTest () {
		List<Books> book = DAOFactory.getInstance().getBooksDAO().getBookByName("Приключения Эраста Фандорина. Азазель");
		assertNotNull(book);
	}

	@Test
	public void getBookByIDTest () {
		Books book = DAOFactory.getInstance().getBooksDAO().getBookById(1L);
		assertNotNull(book);
	}

	@Test
	public void addBookTest () {
		DAOFactory.getInstance().getBooksDAO().addBook(new Books("Контакт11", "Карл Саган",
				"Альпина нон-фикшн", 10, "роман", "21-04-2023"));
		Books book = DAOFactory.getInstance().getBooksDAO().getBookByName("Контакт11").get(0);
		assertNotNull(book);
		book = DAOFactory.getInstance().getBooksDAO().getBookByName("Контакт11").get(0);
		DAOFactory.getInstance().getBooksDAO().deleteBook(book);
	}

	@Test
	public void deleteBookTest () {
		DAOFactory.getInstance().getBooksDAO().addBook(new Books("Контакт15", "Карл Саган",
				"Альпина нон-фикшн", 10, "роман", "21-04-2023"));
		Books book = DAOFactory.getInstance().getBooksDAO().getBookByName("Контакт15").get(0);
		DAOFactory.getInstance().getBooksDAO().deleteBook(book);
		List<Books> book1 = DAOFactory.getInstance().getBooksDAO().getBookByName("Контакт15");
		assertNull(book1);
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

	@Test
	public void updateReaderTest () {
		Reader reader = DAOFactory.getInstance().getReaderDAO().getReaderBySurname("Кочармин").get(0);
		reader.setAddress("ГЗ МГУ");
		DAOFactory.getInstance().getReaderDAO().updateReader(reader);
		reader = DAOFactory.getInstance().getReaderDAO().getReaderBySurname("Кочармин").get(0);
		assertEquals("ГЗ МГУ", reader.getAddress());
	}

	@Test
	public void updateBookTest () {
		DAOFactory.getInstance().getBooksDAO().addBook(new Books("Контакт1", "Карл Саган AAA",
				"Альпина нон-фикшн AAA", 10, "роман AAA", "21-04-2023"));
		Books book = DAOFactory.getInstance().getBooksDAO().getBookByName("Контакт1").get(0);
		book.setAbout("Не про соцсеть");
		DAOFactory.getInstance().getBooksDAO().updateBook(book);
		book = DAOFactory.getInstance().getBooksDAO().getBookByName("Контакт1").get(0);
		assertEquals("Не про соцсеть", book.getAbout());
		DAOFactory.getInstance().getBooksDAO().deleteBook(book);
	}

	@Test
	public void updateCopyTest () {
		Book_Copy copy = DAOFactory.getInstance().getCopyDAO().GetBookCopyByBookName("Контакт");
		copy.setIs_taken_now("Yes");
		DAOFactory.getInstance().getCopyDAO().updateCopy(copy);
		assertEquals("Yes", copy.getIs_taken_now());
		copy.setIs_taken_now("No");
		DAOFactory.getInstance().getCopyDAO().updateCopy(copy);
	}

	@Test
	public void getBookCopyByBookNameTest () {
		Book_Copy copy = DAOFactory.getInstance().getCopyDAO().GetBookCopyByBookName("Контакт");
		assertNotNull(copy);
	}

	@Test
	public void getCopyByIDTest () {
		Book_Copy copy = DAOFactory.getInstance().getCopyDAO().getCopyById(1L);
		assertNotNull(copy);
	}

	@Test
	public void getRecordByIdTest () {
		Records record = DAOFactory.getInstance().getRecordsDAO().getRecordById(1L);
		assertNotNull(record);
	}

	@Test
	public void returnBookTest () {
		DAOFactory.getInstance().getRecordsDAO().addRecord(new Records("Кочармин",
				"Контакт"));
		Records record = DAOFactory.getInstance().getRecordsDAO().returnBook("Кочармин",
				"Контакт");
		Date current_date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		assertEquals(sdf.format(current_date), sdf.format(record.getReturning_date()));
	}

	@Test
	public void deleteCopyTest () {
		Long id = 66L;	// correct value before running tests (+1)
		Book_Copy copy = DAOFactory.getInstance().getCopyDAO().getCopyById(id);
		DAOFactory.getInstance().getCopyDAO().deleteCopy(copy);
		copy = DAOFactory.getInstance().getCopyDAO().getCopyById(id);
		assertNull(copy);
	}
}
