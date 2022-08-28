package se.lexicon.rajashree.booklender.service;

import se.lexicon.rajashree.booklender.dto.BookDto;

import java.util.List;

public interface BookService  {

    List<BookDto> findByReserved(boolean reserved);
    List<BookDto> findByAvailable(boolean available);
    List<BookDto> findBytitle(String title);
    BookDto  findById(int bookId);
    List<BookDto> findByall();
    BookDto create(BookDto bookDto);
    BookDto  Update(BookDto bookDto);
    boolean  delete(int bookId);
}
