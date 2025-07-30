package com.bookreview.bookreview;

import com.bookreview.bookreview.model.BookReviewData;
import com.bookreview.bookreview.service.setupService.BookSetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    BookSetupService bookSetupService;

    @PostMapping("/books")
    public ResponseEntity<List<BookReviewData>>  createBookReviewData(@RequestBody List<BookReviewData> bookReviewData) {
        return ResponseEntity.ok(bookSetupService.createBookData(bookReviewData));
    }

}
