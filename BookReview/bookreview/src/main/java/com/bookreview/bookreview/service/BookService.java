package com.bookreview.bookreview.service;

import com.bookreview.bookreview.entity.Book;
import com.bookreview.bookreview.entity.Review;
import com.bookreview.bookreview.repository.BookRepository;
import com.bookreview.bookreview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired BookRepository bookRepository;
    @Autowired ReviewRepository reviewRepository;

    public List<Book> createBook(List<Book> books) {
        return bookRepository.saveAll(books);
    }

    public List<Review> createReview(List<Review> reviews) {
        return reviewRepository.saveAll(reviews);
    }

    public Optional<Book> getBook(String isbn) {
        return bookRepository.findByIsbn(isbn).stream().findFirst();
    }
}
