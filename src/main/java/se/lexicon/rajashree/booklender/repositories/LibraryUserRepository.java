package se.lexicon.rajashree.booklender.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import se.lexicon.rajashree.booklender.model.LibraryUser;

import java.util.Optional;

public interface LibraryUserRepository extends CrudRepository<LibraryUser, Integer> {
    @Modifying
    @Query("SELECT u FROM LibraryUser u WHERE u.email = ?1 ")
    Optional<LibraryUser> findByEmail(String email);



}
