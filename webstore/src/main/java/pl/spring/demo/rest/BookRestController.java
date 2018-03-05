package pl.spring.demo.rest;

import java.util.Collection;
import java.util.List;

import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/book")
public class BookRestController {

    private BookService bookService;

    @Autowired
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.GET) //@GetMapping
    Collection<BookTo> readBooks() {
        return this.bookService.findAllBooks();
    }

    @RequestMapping(value = "{title}", method = RequestMethod.GET)
    Collection<BookTo> readBooks(@PathVariable String title) {
        return this.bookService.findBooksByTitle(title);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@RequestBody BookTo input) {
        this.validateBook(input);
        BookTo newBook = bookService.saveBook(input);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    private void validateBook(BookTo book) {
        List<BookTo> booksByTitle = bookService.findBooksByTitle(book.getTitle());
        if (!booksByTitle.isEmpty()) {
            throw new BookAlreadyExistsException(book.getTitle());
        }
    }
}
