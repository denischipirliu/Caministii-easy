package ro.cognizant.coderun2023;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity

public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String bookName;
    String author;
    String publishers;
    public Books()
    {
    }
    public Books(String bookName, String author, String publishers){
        this.bookName=bookName;
        this.author=author;
        this.publishers=publishers;
    }
    public String getBookName()
    {
        return bookName;
    }
    public String getAuthor()
    {
        return author;
    }
    public String getPublishers()
    {
        return publishers;
    }
}
