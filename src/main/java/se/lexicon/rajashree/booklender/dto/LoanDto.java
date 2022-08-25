package se.lexicon.rajashree.booklender.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LoanDto {

private long loanId;
private LibraryUserDto lonetaker;
private BookDto book;
private LocalDate loanDate;
private Boolean  terminated;

}
