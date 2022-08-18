package se.lexicon.rajashree.booklender.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Book {

    private int bookId;

    private String title;
    private LocalDate regDate;
    private boolean available;
    private boolean reserved;
    private int maxLoanDays;
    private BigDecimal finePerDay;
    private String description;

    public Book() {
    }

    public Book(String title, int maxLoanDays, BigDecimal finePerDay, String description) {
        this.title = title;
        this.maxLoanDays = maxLoanDays;
        this.finePerDay = finePerDay;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public int getMaxLoanDays() {
        return maxLoanDays;
    }

    public void setMaxLoanDays(int maxLoanDays) {
        this.maxLoanDays = maxLoanDays;
    }

    public BigDecimal getFinePerDay() {
        return finePerDay;
    }

    public void setFinePerDay(BigDecimal finePerDay) {
        this.finePerDay = finePerDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getBookId() == book.getBookId() && isAvailable() == book.isAvailable() && isReserved() == book.isReserved() && getMaxLoanDays() == book.getMaxLoanDays() && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getRegDate(), book.getRegDate()) && Objects.equals(getFinePerDay(), book.getFinePerDay()) && Objects.equals(getDescription(), book.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getTitle(), getRegDate(), isAvailable(), isReserved(), getMaxLoanDays(), getFinePerDay(), getDescription());
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", regDate=" + regDate +
                ", available=" + available +
                ", reserved=" + reserved +
                ", maxLoanDays=" + maxLoanDays +
                ", finePerDay=" + finePerDay +
                ", description='" + description + '\'' +
                '}';
    }
}