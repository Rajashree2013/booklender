package se.lexicon.rajashree.booklender.service;

import se.lexicon.rajashree.booklender.dto.BookDto;
import se.lexicon.rajashree.booklender.dto.LibraryUserDto;
import se.lexicon.rajashree.booklender.model.LibraryUser;

import java.util.List;

public interface LibraryUserService {
    LibraryUserDto findById(int userId);
    LibraryUserDto findByEmail( String email);
    List<LibraryUserDto> findByAll();
    LibraryUserDto create( LibraryUserDto  libraryUserDto);
    LibraryUserDto update(LibraryUserDto libraryUserDto);
    boolean delete( int userId);
}
