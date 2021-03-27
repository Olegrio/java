package com.ifmo.jjd.lesson6.taskone;

import java.util.Arrays;
import java.util.Objects;

public class Book {
    private String name;
    private Author[] authors;
    private int pagesCount;
    private int year;

    public Book(String name, Author[] authors, int pagesCount, int year) {
        if (pagesCount < 20 || year < 100) throw new IllegalArgumentException("pagesCount < 20 или year < 100");
        this.pagesCount = pagesCount;
        this.year = year;

        setName(name);
        setAuthor(authors);
    }

    private void setAuthor(Author[] authors){
        this.authors = new Author[authors.length];
        this.authors = Objects.requireNonNull(authors, "ошибка в authors в Book");

        for (int i = 0; i < authors.length; i++) {
            for (int j = 0; j < authors.length; j++) {
                if(i != j){
                    if(authors[i].getName().equals(authors[j].getName()) && authors[i].getSurname().equals(authors[j].getSurname())){
                        throw new IllegalArgumentException("Автор у книги повторяется");
                    }
                }
            }
        }
    }
    private void setName(String name){
        this.name = Objects.requireNonNull(name, "name в Book ошибочно");
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "\n\n*********Book{" +
                "name='" + name + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", pagesCount=" + pagesCount +
                ", year=" + year +
                '}';
    }
}
