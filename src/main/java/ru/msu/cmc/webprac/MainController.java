package ru.msu.cmc.webprac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.msu.cmc.webprac.tables.Books;
import ru.msu.cmc.webprac.tables.Reader;
import ru.msu.cmc.webprac.utils.DAOFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    @GetMapping("/add_reader")
    public String addReaderShow () {
        return "add_reader";
    }

    @PostMapping("/add_reader")
    public String addReader (@RequestParam(name = "reader_name", required = false) String reader_name,
                             @RequestParam(name = "reader_surname", required = false) String reader_surname,
                             @RequestParam(name = "reader_patronymic", required = false) String reader_patronymic,
                             @RequestParam(name = "reader_birth", required = false) String reader_birth,
                             @RequestParam(name = "reader_address", required = false) String reader_address,
                             @RequestParam(name = "reader_phone", required = false) String reader_phone) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        String formatted_date = formatDate.format(new Date());
        Reader reader = new Reader(reader_name, reader_surname, reader_patronymic,
                formatted_date, reader_birth, reader_address, reader_phone);
        DAOFactory.getInstance().getReaderDAO().addReader(reader);
        return "add_reader";
    }

    @GetMapping("/add_book")
    public String addBookShow () {
        return "add_book";
    }

    @PostMapping("/add_book")
    public String addBook (@RequestParam(name = "book_name", required = false) String book_name,
                           @RequestParam(name = "book_author", required = false) String book_author,
                           @RequestParam(name = "book_publisher", required = false) String book_publisher,
                           @RequestParam(name = "book_genre", required = false) String book_genre,
                           @RequestParam(name = "book_amount", required = false) int book_amount,
                           @RequestParam(name = "book_about", required = false) String book_about) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        String formatted_date = formatDate.format(new Date());
        Books book = new Books(book_name, book_author, book_publisher, book_amount,
                book_about, book_genre, formatted_date);
        DAOFactory.getInstance().getBooksDAO().addBook(book);
        return "add_book";
    }
}
