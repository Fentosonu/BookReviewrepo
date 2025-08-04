package com.bookreview.bookreview.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Pattern(regexp = "^(?:\\d{13}|\\d{3}-\\d{10})$")
    @Column(unique = true)
    private String isbn;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotNull
    @PastOrPresent
    @Temporal(TemporalType.DATE)
    private Date publicationYear;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
}
