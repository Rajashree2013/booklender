package se.lexicon.rajashree.booklender.dto;


import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class BookDto {

    private int bookId;
    private String title;
    private boolean available;
    private boolean reserved;
    private String description;
    private int maxLoanDays;
    private BigDecimal finePerDay;


    public BookDto(String title, String description, int maxLoanDays, BigDecimal finePerDay) {
        this.title = title;
        this.description = description;
        this.maxLoanDays = maxLoanDays;
        this.finePerDay = finePerDay;
    }
}
