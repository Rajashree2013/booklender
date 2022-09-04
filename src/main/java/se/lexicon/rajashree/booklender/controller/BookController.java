package se.lexicon.rajashree.booklender.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.lexicon.rajashree.booklender.dto.BookDto;
import se.lexicon.rajashree.booklender.dto.LibraryUserDto;
import se.lexicon.rajashree.booklender.exception.ObjectDuplicateException;
import se.lexicon.rajashree.booklender.exception.ObjectNotFoundException;
import se.lexicon.rajashree.booklender.service.BookService;
import se.lexicon.rajashree.booklender.service.LibraryUserService;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Book")
@Validated
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}") // find by id
    public ResponseEntity<BookDto> findById(@PathVariable("id") @Min(0) @Max(100000) Integer bookId) throws ObjectNotFoundException {
        BookDto bookDto = bookService.findById(bookId);
        return ResponseEntity.ok().body(bookDto);
    }
    @GetMapping// get all
    public ResponseEntity<List<BookDto>> getAll() {
        return ResponseEntity.ok().body(bookService.findByall());

    }
    @GetMapping("/{title}")
    public ResponseEntity<List<BookDto>>findByEmail(String title){
        return ResponseEntity.ok().body(bookService.findBytitle(title))  ;
    }

    @PostMapping("/")
    public ResponseEntity<BookDto> createdLibraryUser(@RequestBody @Valid BookDto bookDto) throws ObjectDuplicateException {
        System.out.println("BookDto = " + bookDto);
        BookDto createdBookDto = bookService.create(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBookDto); // 201
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateUserById(@RequestBody @Valid BookDto bookDto) {
        System.out.println("bookDto = " + bookDto);
        bookService.Update(bookDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204
    }
}
