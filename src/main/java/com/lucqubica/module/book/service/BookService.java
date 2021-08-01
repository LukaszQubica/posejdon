package com.lucqubica.module.book.service;
import com.lucqubica.module.book.repository.BookRepository;
import com.lucqubica.module.book.dto.BookDto;
import com.lucqubica.module.book.entity.BookDetailsEntity;
import com.lucqubica.module.book.entity.BookEntity;
import com.lucqubica.module.book.entity.BookTagEntity;
import com.lucqubica.module.book.form.BookForm;
import com.lucqubica.module.book.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public BookEntity findOne(Long id) {
        return bookRepository.findOneById(id);
    }
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }
    public BookDto create(BookForm form) {
        BookDetailsEntity details = new BookDetailsEntity()
                .setPublisher(form.getPublisher())
                .setLang(form.getLang())
                .setIsbn(form.getIsbn());
        BookEntity newBook = new BookEntity()
                .setAuthor(form.getAuthor())
                .setTitle(form.getTitle())
                .setDetails(details);
        newBook.setTags(createTags(form, newBook));
        return BookMapper.map(
                bookRepository.saveAndFlush(newBook)
        );
    }
    public BookEntity update(BookEntity bookEntity) {
        return bookRepository.saveAndFlush(bookEntity);
    }
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    private Set<BookTagEntity> createTags(BookForm form, BookEntity newBook) {
        return form.getTags()
                .stream()
                .map(tagStr -> new BookTagEntity().setValue(tagStr).setBook(newBook))
                .collect(Collectors.toSet());
    }
}