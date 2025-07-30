package com.bookreview.bookreview.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookData {
//    "isbn": "978-0134685991",
//            "title": "Effective Java",
//            "author": "Joshua Bloch",
//            "publicationYear": 2018,
//            "initialReview": {
//        "reviewerName": "John Doe",
//                "rating": 5,
//                "comment": "Excellent book for Java developers"
//    }

    private String isbn;
    private String title;
    private String author;
    private Date publicationYear;
    private BookReviewData reviewData;
}
