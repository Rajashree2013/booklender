package se.lexicon.rajashree.booklender.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loanId;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    private LibraryUser loanTaker;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    private Book book;
    private LocalDate loanDate;
    private boolean  concluded;



    public Loan(LibraryUser loanTaker, Book book, LocalDate loanDate) {
        setLoanTaker(loanTaker);
        setBook(book);
        setLoanDate(loanDate);
        setConcluded(false);
}

    public void setBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book is null");
        if (!book.isAvailable()) throw new IllegalArgumentException("Book is not available");
        book.setAvailable(false);
        this.book = book;
    }

    public boolean isOverDue() {
        LocalDate dueDate = loanDate.plusDays(book.getMaxLoanDays());
        return LocalDate.now().isAfter(dueDate);
    }

    public BigDecimal getFine() {
        Period period = Period.between(loanDate.plusDays(book.getMaxLoanDays()), LocalDate.now());
        int daysOverdue = period.getDays();
        BigDecimal fine = BigDecimal.ZERO;
        if (daysOverdue > 0)
            fine = BigDecimal.valueOf(daysOverdue * book.getFinePerDay().longValue());
        return fine;
    }

    public boolean extendLoan(int days) {
        if (book.isReserved() || isOverDue()) return false;
        if (days > book.getMaxLoanDays()) return false;
        setLoanDate(getLoanDate().plusDays(days));
        return true;
    }

    // add more logic
    public void returnBook() {
        this.book.setAvailable(true);
        this.concluded = true;
    }


}











