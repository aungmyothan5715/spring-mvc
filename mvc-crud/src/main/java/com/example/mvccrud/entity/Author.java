package com.example.mvccrud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Name can not be empty!")
    @Pattern(regexp = "[A-Za-z ]*", message = "Name cannot contain illegal characters.")
    private String name;
   // @NotEmpty(message = "Must not be empty!")
    @Past(message = "Date of Birth must be past.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    //@NotEmpty(message = "Email can not be empty!")
    @Email(message = "Invalid Email format!")
    private String email;
    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        book.setAuthor(this);
        books.add(book);
    }

}
