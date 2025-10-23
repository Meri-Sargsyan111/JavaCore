package library;

import java.util.Objects;

public class Book {
    private String title;
    private String autorName;
    private double prise;
    private int quantity;


    public Book(String title, String autorName, double prise, int quantity) {
        this.title = title;
        this.autorName = autorName;
        this.prise = prise;
        this.quantity = quantity;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutorName() {
        return autorName;
    }

    public void setAutorName(String autorName) {
        this.autorName = autorName;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(prise, book.prise) == 0 &&
                quantity == book.quantity &&
                Objects.equals(title, book.title) &&
                Objects.equals(autorName, book.autorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, autorName, prise,quantity);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authorName='" + autorName + '\'' +
                ", prise=" + prise +
                ", quantity=" + quantity +
                '}';
    }
}

