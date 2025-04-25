package by.itclass.controllers;

import by.itclass.model.entities.Library;
import by.itclass.model.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static by.itclass.constants.AppConst.*;

@Controller
public class LibraryController {
    private LibraryRepository repository;

    @Autowired
    public void setRepository(LibraryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String getAll(Model model) {
        var libs = repository.findAll();
        model.addAttribute(LIBS_ATTR, libs);
        return INDEX_PAGE;
    }

    @GetMapping("/view/{id}")
    public String viewById(@PathVariable(name = "id") int id,
                           Model model) {
        var library = repository.findById(id).get();
        model.addAttribute(LIB_ATTR, library);
        return LIBRARY_PAGE;
    }

    @GetMapping("/del")
    public String deleteById(@RequestParam(name = "id") int id) {
        repository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/addLib")
    public String addLib(@RequestParam(name = "name") String name,
                         @RequestParam(name = "address") String address) {
        var lib = new Library(name, address);
        repository.save(lib);
        return "redirect:/";
    }
}
