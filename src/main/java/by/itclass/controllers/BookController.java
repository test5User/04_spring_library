package by.itclass.controllers;

import by.itclass.model.entities.Book;
import by.itclass.model.entities.BookInLibrary;
import by.itclass.model.repositories.BookRepository;
import by.itclass.model.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    private BookRepository bookRepository;
    private LibraryRepository libraryRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setLibraryRepository(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @GetMapping("/addBook/{id}")
    public ModelAndView addBook(@PathVariable(name = "id") int id) {
        return new ModelAndView("add-book", "book", new BookInLibrary(id));
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute(name = "book") BookInLibrary bookInLibrary) {
        var library = libraryRepository.findById(bookInLibrary.getLibrary_id()).get();
        var book = new Book(bookInLibrary.getGenre(), bookInLibrary.getAuthor(), bookInLibrary.getTitle(),
                bookInLibrary.getPages(), library);
        bookRepository.save(book);
        return "redirect:/view/" + bookInLibrary.getLibrary_id();
    }

    @GetMapping("delBook/{bookId}/{libraryId}")
    public String delBook(@PathVariable(name = "bookId") int bookId,
                          @PathVariable(name = "libraryId") int libraryId) {
        bookRepository.deleteById(bookId);
        return "redirect:/view/" + libraryId;
    }
}
