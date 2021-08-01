package com.lucqubica.module.book.entity;

public enum BookType {
    HARDCOVER,
    SOFTCOVER,
    COVER;

    public static BookType safeValueOf(String type) {
        try {
            return valueOf(type.toUpperCase());
        } catch (Exception e) {
            return COVER;
        }
    }
}