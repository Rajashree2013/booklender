package se.lexicon.rajashree.booklender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.lexicon.rajashree.booklender.dto.LibraryUserDto;
import se.lexicon.rajashree.booklender.exception.ObjectDuplicateException;
import se.lexicon.rajashree.booklender.exception.ObjectNotFoundException;
import se.lexicon.rajashree.booklender.service.LibraryUserService;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/v1/LibaryUser")
@Validated
public class LibraryUserController {

    LibraryUserService libraryUserService;

    @Autowired
    public LibraryUserController(LibraryUserService libraryUserService) {
        this.libraryUserService = libraryUserService;
    }

    @GetMapping("/{id}") // find by id
    public ResponseEntity<LibraryUserDto> findById(@PathVariable("id") @Min(0) @Max(100000) Integer libUserId) throws ObjectNotFoundException {
        LibraryUserDto libraryUserDto = libraryUserService.findById(libUserId);
        return ResponseEntity.ok().body(libraryUserDto);
    }


   @GetMapping// get all
    public ResponseEntity<List<LibraryUserDto>> getAll() {
    return ResponseEntity.ok().body(libraryUserService.findByAll());

}
    @GetMapping("/{emailId}")
    public ResponseEntity<LibraryUserDto>findByEmail(String emailId){
     return ResponseEntity.ok().body(libraryUserService.findByEmail(emailId))  ;
    }

    @PostMapping("/")
    public ResponseEntity<LibraryUserDto> createdLibraryUser(@RequestBody @Valid LibraryUserDto libraryUserDto) throws ObjectDuplicateException {
        System.out.println("libUserDto = " + libraryUserDto);
        LibraryUserDto createdLibraryUser = libraryUserService.create(libraryUserDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLibraryUser); // 201
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateUserById(@RequestBody @Valid LibraryUserDto libraryUserDto) {
        System.out.println("roleDto = " + libraryUserDto);
        libraryUserService.update(libraryUserDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204
    }

}
