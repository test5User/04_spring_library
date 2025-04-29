package by.itclass.model.repositories;

import by.itclass.model.entities.Book;
import by.itclass.model.entities.BookInLibrary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
