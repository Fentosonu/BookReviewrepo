package com.bookreview.bookreview.service;

import com.bookreview.bookreview.entity.Book;
import com.bookreview.bookreview.entity.Review;
import com.bookreview.bookreview.model.BookData;
import com.bookreview.bookreview.model.BookResponse;
import com.bookreview.bookreview.model.BookReviewData;
import com.bookreview.bookreview.model.ReviewResponse;
import com.bookreview.bookreview.repository.BookRepository;
import com.bookreview.bookreview.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired BookRepository bookRepository;
    @Autowired ReviewRepository reviewRepository;

    @Transactional
    public BookResponse createBook(BookData request) {
        if (bookRepository.findByIsbnIgnoreCase(request.getIsbn()).isPresent()) {
            throw new IllegalArgumentException("Book with ISBN " + request.getIsbn() + " already exists");
        }

        Book book = new Book();
        book.setIsbn(request.getIsbn());
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPublicationYear(request.getPublicationYear());

        Review review = new Review();
        review.setBook(book);
        review.setReviewerName(request.getReviewData().getReviewerName());
        review.setRating(request.getReviewData().getRating());
        review.setComment(request.getReviewData().getComment());

        book.getReviews().add(review);
        bookRepository.save(book);

        return convertToResponse(book);
    }

    public BookResponse getBookByIsbn(String isbn) {
        Book book = bookRepository.findByIsbnIgnoreCase(isbn)
                .orElseThrow(() -> new EntityNotFoundException("Book with ISBN " + isbn + " not found"));
        return convertToResponse(book);
    }

    private BookResponse convertToResponse(Book book) {
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setIsbn(book.getIsbn());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        response.setPublicationYear(book.getPublicationYear());

        response.setReviews(book.getReviews().stream()
                .map(this::convertToReviewResponse)
                .collect(Collectors.toList()));

        response.setTotalReviews((long) book.getReviews().size());
        response.setAverageRating(book.getReviews().stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0));

        response.setRatingDistribution(book.getReviews().stream()
                .collect(Collectors.groupingBy(
                        Review::getRating,
                        Collectors.counting()
                )));

        return response;
    }

    private ReviewResponse convertToReviewResponse(Review review) {
        ReviewResponse response = new ReviewResponse();
        response.setId(review.getId());
        response.setReviewerName(review.getReviewerName());
        response.setRating(review.getRating());
        response.setComment(review.getComment());
        response.setReviewDate(review.getReviewDate());
        return response;
    }
}
