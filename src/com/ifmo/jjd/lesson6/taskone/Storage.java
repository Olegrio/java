package com.ifmo.jjd.lesson6.taskone;

import java.util.Arrays;
import java.util.Objects;

public class Storage {
    private Book[] books;
    private int numberStorage;
    private int sizeStorage = 20;

    public Storage(int numberStorage) {
        if(sizeStorage < 1) throw new IllegalArgumentException("sizeStorage < 1");
        setNumberStorage(numberStorage);
        this.books = new Book[sizeStorage];
    }

    public void addBook(Book book) {
        Objects.requireNonNull(books, "books -> addBooks в Storage ошибочно");
        for (int i = 0; i < books.length; i++) {
            if(books[i] != null && books[i].getName().equals(book.getName())){
                System.out.println("Такая книга в хранилище уже есть");
                return;
            }
            if(books[i] == null){
                books[i] = book;
                return;
            }
        }
        System.out.println("Хранилище заполненно");
    }

    public void setNumberStorage(int numberStorage) {
        if(numberStorage <= 0) throw new IllegalArgumentException("numberStorage <= 0");
        this.numberStorage = numberStorage;
    }

    public int getSizeStorage() {
        return sizeStorage;
    }

    public Book[] getBooks() {
        return books;
    }

    public int getNumberStorage() {
        return numberStorage;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "books=" + Arrays.toString(books) +
                ", numberStorage=" + numberStorage +
                '}';
    }
}
