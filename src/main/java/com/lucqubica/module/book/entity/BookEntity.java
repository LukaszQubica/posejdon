package com.lucqubica.module.book.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "book")

public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotNull(message = "Author for book is required")
    @NotEmpty(message = "Author for book is required")
    @Size(min = 3, max = 255, message = "Author should has from 3 to 15")
    private String author;
    @NotNull(message = "Title for book is required")
    @NotEmpty(message = "Title for book is required")
    @Size(min = 3, max = 255, message = "Title should has from 3 to 15")
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id", referencedColumnName = "id")
    private BookDetailsEntity details;

    @Enumerated(EnumType.STRING)
    private BookType type;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<BookTagEntity> tags;

    public BookType getType() {
        return type;
    }

    public BookEntity setType(BookType type) {
        this.type = type;
        return this;
    }

    public Set<BookTagEntity> getTags() {
        return tags;
    }

    public BookEntity setTags(Set<BookTagEntity> tags) {
        this.tags = tags;
        return this;
    }

    public BookDetailsEntity getDetails() {
        return details;
    }

    public BookEntity setDetails(BookDetailsEntity details) {
        this.details = details;
        return this;
    }

    public Long getId() {
        return id;
    }

    public BookEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookEntity setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookEntity setTitle(String title) {
        this.title = title;
        return this;
    }
}
