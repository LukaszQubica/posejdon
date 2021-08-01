package com.lucqubica.module.book.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class BookForm {

    @NotNull(message = "Author for book is required")
    @NotEmpty(message = "Author for book is required")
    @Size(min = 3, max = 255, message = "Author should has from 3 to 15")
    private String author;
    @NotNull(message = "Title for book is required")
    @NotEmpty(message = "Title for book is required")
    @Size(min = 3, max = 255, message = "Title should has from 3 to 15")
    private String title;

    private String isbn;
    private String lang;
    private String publisher;

    private List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    public BookForm setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookForm setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookForm setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookForm setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getLang() {
        return lang;
    }

    public BookForm setLang(String lang) {
        this.lang = lang;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public BookForm setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }
}
