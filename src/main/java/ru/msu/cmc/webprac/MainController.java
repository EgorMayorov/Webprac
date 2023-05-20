package ru.msu.cmc.webprac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.msu.cmc.webprac.tables.Books;
import ru.msu.cmc.webprac.tables.Reader;
import ru.msu.cmc.webprac.utils.DAOFactory;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("/readers")
    public String showReaders (Model model) {
        List<Reader> readers = DAOFactory.getInstance().getReaderDAO().getAllReader();
        model.addAttribute("readerList", readers);
//        model.addAttribute("ReaderDAO", readerDAO);
        return "readers";
    }

    @PostMapping("/readers")
    public String searchReader (Model model, @RequestParam(name = "search_reader", required = false) String search_reader){
        List<Reader> reader;
        if (search_reader.equals("")) {
            reader = DAOFactory.getInstance().getReaderDAO().getAllReader();
        } else {
            reader = DAOFactory.getInstance().getReaderDAO().getReaderBySurname(search_reader);
        }
        model.addAttribute("readerList", reader);
        return "readers";
    }

    @PostMapping("/reader_info")
    public String readerInfo (Model model, @RequestParam(name = "reader_surname", required = false) String reader_surname) {
        Reader reader = DAOFactory.getInstance().getReaderDAO().getReaderBySurname(reader_surname).get(0);
        model.addAttribute("reader_info", reader);
        return "reader_info";
    }

    @PostMapping("/reader_books")
    public String readerBooks (Model model, @RequestParam(name = "reader_surname", required = false) String reader_surname) {
        List<Books> books = DAOFactory.getInstance().getReaderDAO().getReaderBooksBySurname(reader_surname);
        model.addAttribute("booksList", books);
        return "reader_books";
    }

    @GetMapping("/books")
    public String showBooks (Model model) {
        List<Books> books = DAOFactory.getInstance().getBooksDAO().getAllBooks();
        model.addAttribute("bookList", books);
//        model.addAttribute("ReaderDAO", readerDAO);
        return "books";
    }

    @PostMapping("/books")
    public String searchBook (Model model, @RequestParam(name = "search_book", required = false) String search_book){
        List<Books> books;
        if (search_book.equals("")) {
            books = DAOFactory.getInstance().getBooksDAO().getAllBooks();
        } else {
            books = DAOFactory.getInstance().getBooksDAO().getBookByName(search_book);
        }
        model.addAttribute("bookList", books);
        return "books";
    }

    @PostMapping("/book_info")
    public String bookInfo (Model model, @RequestParam(name = "book_name", required = false) String book_name) {
        List<Books> book = DAOFactory.getInstance().getBooksDAO().getBookByName(book_name);
        model.addAttribute("book_info", book.get(0));
        return "book_info";
    }

    @PostMapping("/book_readers")
    public String bookReaders (Model model, @RequestParam(name = "book_name", required = false) String book_name) {
        List<Reader> readers = DAOFactory.getInstance().getBooksDAO().getReadersByBook(book_name);
        model.addAttribute("readersList", readers);
        return "book_readers";
    }
}
