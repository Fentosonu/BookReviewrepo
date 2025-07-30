package com.bookreview.bookreview.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {
//    id, isbn, title, author, publicationYear
    @Id
    private Long id;

    @Column
    private String isbn;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private Date publicationYear;
}
