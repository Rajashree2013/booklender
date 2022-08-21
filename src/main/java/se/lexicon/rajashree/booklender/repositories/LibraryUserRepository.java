package se.lexicon.rajashree.booklender.repositories;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.rajashree.booklender.model.LibraryUser;

import java.util.Optional;

public interface LibraryUserRepository extends CrudRepository<LibraryUser, Integer> {


    /*Optional<LibraryUser> findByEmail(String email);*/



}
