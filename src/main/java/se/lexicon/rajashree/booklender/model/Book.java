package se.lexicon.rajashree.booklender.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String title;
    private boolean available;
    private boolean reserved;
    private int maxLoanDays;
    private BigDecimal finePerDay;
    private String description;

    public Book(String title, int maxLoanDays, BigDecimal finePerDay, String description) {
        setTitle(title);
        setMaxLoanDays(maxLoanDays);
        setFinePerDay(finePerDay);
        setDescription(description);
        setAvailable(true);
        setReserved(false);
    }

}