package ru.msu.cmc.webprac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.msu.cmc.webprac.DAO.ReaderDAO;
import ru.msu.cmc.webprac.DAO.impl.ReaderDAOImpl;
import ru.msu.cmc.webprac.tables.Reader;
import ru.msu.cmc.webprac.utils.DAOFactory;

import java.util.List;

@Controller
public class MainController {
//    @Autowired
//    private final ReaderDAO readerDAO = new ReaderDAOImpl();

//    @GetMapping("/")
//    public String index() {
//        return "start_page";
//    }

    @GetMapping("/readers")
    public String showReaders (Model model) {
        List<Reader> readers = DAOFactory.getInstance().getReaderDAO().getAllReader();
        model.addAttribute("readerList", readers);
//        model.addAttribute("ReaderDAO", readerDAO);
        return "readers";
    }

    @PostMapping("/readers")
    public String search(Model model, @RequestParam(name = "search_reader", required = false) String search_reader){
        if (search_reader.equals("")) {
            List<Reader> reader = DAOFactory.getInstance().getReaderDAO().getAllReader();
            model.addAttribute("readerList", reader);
        } else {
            Reader reader = DAOFactory.getInstance().getReaderDAO().getReaderBySurname(search_reader);
            model.addAttribute("readerList", reader);
        }
        return "readers";
    }
}
