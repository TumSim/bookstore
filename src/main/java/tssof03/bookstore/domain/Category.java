package tssof03.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryid;
    private String name;

    

    public Category(Long categoryid, String name) {
        this.categoryid = categoryid;
        this.name = name;
    }

    public Category() {
        this.categoryid = null;
        this.name = null;
    }
    public Category(String name) {
        this.name = name;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getCategoryid() {
        return categoryid;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category [categoryid=" + categoryid + ", name=" + name + "]";
    }

}
