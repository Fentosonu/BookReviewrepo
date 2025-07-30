package com.bookreview.bookreview.service.setupService;

import com.bookreview.bookreview.entity.Book;
import com.bookreview.bookreview.entity.Review;
import com.bookreview.bookreview.model.BookData;
import com.bookreview.bookreview.model.BookReviewData;
import com.bookreview.bookreview.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookSetupService {
    @Autowired
    BookService bookService;

    public List<BookReviewData> createBookData(List<BookReviewData> bookReviewData) {
        List<Book> books = new ArrayList<>();
        List<Review> reviews = new ArrayList<>();
        //need to implement the logics
        books = bookService.createBook(books);

        reviews = bookService.createReview(reviews);

        return bookReviewData;
    }





}
