package com.bookreview.bookreview.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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
}
