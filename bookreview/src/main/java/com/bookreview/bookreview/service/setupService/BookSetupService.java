package com.bookreview.bookreview.service.setupService;

import com.bookreview.bookreview.model.BookData;
import com.bookreview.bookreview.model.BookResponse;
import com.bookreview.bookreview.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookSetupService {
    @Autowired
    BookService bookService;

    public BookResponse createBookData(BookData bookData) {
        return bookService.createBook(bookData);
    }

    public BookResponse getBookByIsbn(String isbn) {
        return bookService.getBookByIsbn(isbn);
    }

}
