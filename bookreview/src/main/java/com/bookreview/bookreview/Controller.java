package com.bookreview.bookreview;

import com.bookreview.bookreview.model.BookData;
import com.bookreview.bookreview.model.BookResponse;
import com.bookreview.bookreview.service.setupService.BookSetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    BookSetupService bookSetupService;

    @PostMapping("/books")
    public ResponseEntity<BookResponse>  createBookReviewData(@RequestBody BookData bookData) {
        return ResponseEntity.ok(bookSetupService.createBookData(bookData));
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookResponse> getBookByIsbn(@PathVariable String isbn) {
        return ResponseEntity.ok(bookSetupService.getBookByIsbn(isbn));
    }
}
