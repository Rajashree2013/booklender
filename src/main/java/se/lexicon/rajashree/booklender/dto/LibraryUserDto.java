package se.lexicon.rajashree.booklender.dto;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LibraryUserDto {

    private int userId;
    private LocalDate regDate;
    private String name;
    private String email;

}
