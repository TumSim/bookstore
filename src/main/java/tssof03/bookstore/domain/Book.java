package tssof03.bookstore.domain;

public class Book {
    private String title;
    private String author;
    private Integer publicationYear;
    private Integer isbn;
    private Double price;

    
    public Book(String title, String author, Integer publicationYear, Integer isbn, Double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    public Book() {
        this.title = null;
        this.author = null;
        this.publicationYear = null;
        this.isbn = null;
        this.price = null;
    }


    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }


    public Integer getPublicationYear() {
        return publicationYear;
    }


    public Integer getIsbn() {
        return isbn;
    }


    public Double getPrice() {
        return price;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }


    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }


    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
                + ", price=" + price + "]";
    }

    
}
