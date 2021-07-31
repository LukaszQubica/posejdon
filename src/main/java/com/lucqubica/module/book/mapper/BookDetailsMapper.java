package com.lucqubica.module.book.mapper;

import com.lucqubica.module.book.dto.BookDetailsDto;
import com.lucqubica.module.book.entity.BookDetailsEntity;

public class BookDetailsMapper {
    public static BookDetailsDto map(BookDetailsEntity details) {
        if (details == null) {
            return new BookDetailsDto();
        }
        return new BookDetailsDto()
                .setPublisher(details.getPublisher())
                .setLang(details.getLang());

    }

}