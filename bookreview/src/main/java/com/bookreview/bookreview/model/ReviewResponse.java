package com.bookreview.bookreview.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {
    private Long id;
    private String reviewerName;
    private int rating;
    private String comment;
    private Date reviewDate;
}
