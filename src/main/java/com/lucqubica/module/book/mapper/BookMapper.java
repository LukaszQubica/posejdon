package com.lucqubica.module.book.mapper;

import com.lucqubica.module.book.dto.BookDto;
import com.lucqubica.module.book.entity.BookEntity;
import com.lucqubica.module.book.entity.BookType;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {

    public static BookDto map(BookEntity entity) {
        return new BookDto()
                .setId(entity.getId())
                .setAuthor(entity.getAuthor())
                .setTitle(entity.getTitle())
                .setDetails(BookDetailsMapper.map(entity.getDetails()))
                .setTags(BooksTagsMapper.map(entity.getTags()))
                .setTag(BooksTagsMapper.mapAsString(entity.getTags()));
    }

    private static String getTypeAsStrOrNull(BookType type) {
        return type != null ? type.toString() : null;
    }

    public static List<BookDto> map(List<BookEntity> entities) {
        return entities
                .stream()
                .map(BookMapper::map)
                .collect(Collectors.toList());
    }

}