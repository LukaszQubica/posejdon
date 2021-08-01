package com.lucqubica.module.book;

import com.lucqubica.module.book.dto.BookDto;
import com.lucqubica.module.book.entity.BookEntity;
import com.lucqubica.module.book.form.BookForm;
import com.lucqubica.module.book.mapper.BookMapper;
import com.lucqubica.module.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
@RestController
public class BooksRestController {
    @Autowired
    private BookService bookService;
    @GetMapping("/api/book")
    public List<BookDto> getBooks() {
        List<BookEntity> books = bookService.findAll();
        return BookMapper.map(books);
    }
    @GetMapping("/api/book/{id}")
    public BookDto getBook(@PathVariable Long id) {
        BookEntity book = bookService.findOne(id);
        return BookMapper.map(book);
    }
    @PostMapping("/api/book")
    public BookDto newBook(@RequestBody @Valid BookForm form) {
        return bookService.create(form);
    }
    @PutMapping("/api/book/{id}")
    public BookDto updateBooks(@PathVariable Long id,
                               @RequestBody BookEntity booksEntity) {
        BookEntity book = bookService.update(booksEntity.setId(id));
        return BookMapper.map(book);
    }
    @DeleteMapping("/api/book/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }
}