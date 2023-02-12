package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRep;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRep bookRep;

    public BookController(BookRep bookRep) {
        this.bookRep = bookRep;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books", bookRep.findAll());
        return "booksList";
    }

}
