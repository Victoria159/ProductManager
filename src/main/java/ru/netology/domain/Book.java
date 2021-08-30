package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class Book extends Product {
    private String author;


    public Book() {
        super();
    }

    public Book(int id, String title, int price, String author) {
        super(id, title, price);
        this.author = author;
    }

}