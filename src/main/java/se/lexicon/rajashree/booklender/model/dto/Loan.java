package se.lexicon.rajashree.booklender.model.dto;

import java.time.LocalDate;
import java.util.Objects;

public class Loan {

    private long loanId;
    private LibraryUser loanTaker;
    private Book book;
    private LocalDate loanDate;
    private boolean terminated;

    public Loan() {
    }

    public Loan(LibraryUser loanTaker, Book book, LocalDate loanDate, boolean terminated) {
        this.loanTaker = loanTaker;
        this.book = book;
        this.loanDate = loanDate;
        this.terminated = terminated;
    }

    public long getLoanId() {
        return loanId;
    }

    public void setLoanId(long loanId) {
        this.loanId = loanId;
    }

    public LibraryUser getLoanTaker() {
        return loanTaker;
    }

    public void setLoanTaker(LibraryUser loanTaker) {
        this.loanTaker = loanTaker;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loan)) return false;
        Loan loan = (Loan) o;
        return getLoanId() == loan.getLoanId() && isTerminated() == loan.isTerminated() && Objects.equals(getLoanTaker(), loan.getLoanTaker()) && Objects.equals(getBook(), loan.getBook()) && Objects.equals(getLoanDate(), loan.getLoanDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLoanId(), getLoanTaker(), getBook(), getLoanDate(), isTerminated());
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanTaker=" + loanTaker +
                ", book=" + book +
                ", loanDate=" + loanDate +
                ", terminated=" + terminated +
                '}';
    }
}
