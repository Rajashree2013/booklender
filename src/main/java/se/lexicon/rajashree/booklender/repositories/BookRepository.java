package se.lexicon.rajashree.booklender.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.rajashree.booklender.model.Book;

import java.util.List;


public interface BookRepository extends CrudRepository<Book, Integer> {


    List<Book> findByReserved(boolean reserved);


    List<Book> findByAvailable(boolean available);


    List<Book> findByTitle(String title);







}
