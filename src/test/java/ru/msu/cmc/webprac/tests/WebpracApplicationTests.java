package ru.msu.cmc.webprac.tests;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.boot.test.context.SpringBootTest;
import ru.msu.cmc.webprac.tables.Reader;
import ru.msu.cmc.webprac.utils.DAOFactory;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class WebpracApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void addReaderTest () {
		DAOFactory.getInstance().getReaderDAO().addReader(new Reader("Михаил", "Кочармин",
				"Дмитриевич", "23-04-2023", "28-09-2002",
				"ДСЛ МГУ", "879150000000"));
		Reader reader = DAOFactory.getInstance().getReaderDAO().getReaderBySurname("Кочармин");
		assertNotNull(reader);
	}
}
