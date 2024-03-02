package tssof03.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private Integer publicationYear;
    private String isbn;
    private Double price;

    
    @ManyToOne  // Book Many toOne Category
    @JsonIgnoreProperties("books")
    @JoinColumn(name = "categoryid") // FK
    private Category category;




    public Book(String title, String author, Integer publicationYear, String isbn, Double price, Category category) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
    }

    

    public Book(Long id, String title, String author, Integer publicationYear, String isbn, Double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }



    public Book() {
        this.id = null;
        this.title = null;
        this.author = null;
        this.publicationYear = null;
        this.isbn = null;
        this.price = null;
    }


    public void setCategory(Category category) {
        this.category = category;
    }



    public Category getCategory() {
        return category;
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
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


    public String getIsbn() {
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


    public void setIsbn(String isbn) {
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
