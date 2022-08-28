package se.lexicon.rajashree.booklender.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.rajashree.booklender.model.Book;

import java.util.List;


public interface BookRepository extends CrudRepository<Book, Integer> {

    @Modifying
    @Query("SELECT u FROM Book u WHERE u.reserved = ?1 ")
    List<Book> findByReserved(boolean reserved);

    @Modifying
    @Query("SELECT u FROM Book u WHERE u.available = ?1 ")
    List<Book> findByAvailable(boolean available);

    @Modifying
    @Query("SELECT u FROM Book u WHERE u.title = ?1 ")
    List<Book> findByTitle(String title);







}
