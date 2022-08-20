package se.lexicon.rajashree.booklender.model;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class LibraryUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private LocalDate regDate;
    private String name;
    @Column(unique=true)
    private String email;

    public LibraryUser(LocalDate regDate, String name) {
        this.regDate = regDate;
        setName(name);
    }

}