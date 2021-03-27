package com.ifmo.jjd.lesson6.taskone;

public class Application {
    public static void main(String[] args) {

//        1. Реализовать объектную модель:
//        Хранилище: книги, номер хранилища;
//        Книга: название, авторы, количество страниц, год издания (int);
//        Автор: имя, фамилия.
//                Книга может быть написана несколькоми авторами.
//                Каждое хранилище расчитано на 20 книг (максимум).
//                * Необходимо реализовать возможность добавления книг в хранилище по 1й.
//                * В одно хранилище не может быть добавлено несколько книг с одинаковым названием


        Author author1 = new Author("Иван", "Иванов");
        Author author2 = new Author("Сергей", "Петров");
        Author author3 = new Author("Марина", "Александрова");
        Author author4 = new Author("Екатерина", "Федорова");
        Author author5 = new Author("Джон", "Джонсон");

        Book book1 = new Book("Книга 1", new Author[]{author1, author2}, 100, 2001);
        Book book2 = new Book("Книга 2", new Author[]{author3, author2}, 300, 1980);
        Book book3 = new Book("Книга 3", new Author[]{author4, author5}, 501, 1991);
        Book book4 = new Book("Книга 4", new Author[]{author1, author2, author3}, 104, 2020);
        Book book5 = new Book("Книга 5", new Author[]{author1}, 85, 1994);
        Book book6 = new Book("Книга 6", new Author[]{author4, author2, author3, author1}, 1287, 2003);
        Book book7 = new Book("Книга 7", new Author[]{author5, author3}, 515, 1989);
        Book book8 = new Book("Книга 8", new Author[]{author5, author2}, 203, 1980);

        Storage storage1 = new Storage(1);
        Storage storage2 = new Storage(2);
        Storage storage3 = new Storage(3);

        storage1.addBook(book1);
        storage1.addBook(book2);
        storage1.addBook(book3);

        System.out.println(storage1.toString());


    }
}
