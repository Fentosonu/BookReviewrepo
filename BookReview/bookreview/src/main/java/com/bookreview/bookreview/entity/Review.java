package com.bookreview.bookreview.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Review {
//    id, bookId, reviewerName, rating (1-5), comment, reviewDate

    @Id
    private Long id;

    @Column
    private String reviewerName;

    @Column
    private int rating;

    @Column (columnDefinition = "TEXT")
    private String comment;

    @Column
    private Date reviewDate;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

}
