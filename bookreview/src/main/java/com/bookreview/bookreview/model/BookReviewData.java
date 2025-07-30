package com.bookreview.bookreview.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookReviewData {
//"reviewerName": "John Doe",
//                "rating": 5,
//                "comment": "Excellent book for Java developers"

    private String reviewerName;
    private int rating;
    private String comment;

}
