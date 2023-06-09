package com.example.mvccrud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Min(value = 10, message = "Price is too low.")
    @Max(value = 100, message = "Price is too high!")
    private double price;
    @Past(message = "Year Published must be past.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate yearPublished;
    //@NotBlank
    @NotEmpty(message = "Publisher cannot be empty!")
    private String publisher;
    @NotEmpty(message = "Image can not be empty!")
    private String imgUrl;
    @ManyToOne
    private Author author;

}
