package ro.cognizant.coderun2023;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    private BooksRepository repo;

    // Home Page
    @GetMapping("/")
    public String welcome() {
        return "<html><body>"
                + "<h1>WELCOME</h1>"
                + "</body></html>";
    }

    @GetMapping("/books")
    public List<Books> getAllBooks() {
        return repo.findALL();
    }
    @GetMapping("/company/{bookName}")
    public Books getBooksbybookname(
            @PathVariable(value = "bookName") String bookName) {
        return repo.findBybookName(bookName);
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Books addBook(
            @RequestBody Books books) {
        return repo.save(books);
    }

    @DeleteMapping("/delete/{bookName}")
    public void deleteBook(
            @PathVariable(value = "bookName") String bookName) {
        repo.deleteBybookName(bookName);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Object> updateBook(
            @RequestBody Books books,
            @PathVariable String bookName) {

        Optional<Books> bookRepo
                = Optional.ofNullable(
                repo.findBybookName(bookName));

        if (!bookRepo.isPresent())
            return ResponseEntity
                    .notFound()
                    .build();

        books.setbookName(bookName);

        repo.save(books);

        return ResponseEntity
                .noContent()
                .build();
    }
}