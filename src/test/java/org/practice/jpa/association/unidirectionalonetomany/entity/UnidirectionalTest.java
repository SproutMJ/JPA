package org.practice.jpa.association.unidirectionalonetomany.entity;

import org.junit.jupiter.api.Test;
import org.practice.jpa.association.entity.Author;
import org.practice.jpa.association.entity.AuthorRepository;
import org.practice.jpa.association.entity.Book;
import org.practice.jpa.association.entity.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

@DataJpaTest
class UnidirectionalTest {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    Author author = new Author();

    List<Book> books = Arrays.asList(new Book(), new Book(), new Book());

    @Test
    void insert() {
        Author savedAuthor = authorRepository.save(author);

        for (Book book : books) {
            Book savedBook = bookRepository.save(book);
            savedAuthor.addBook(savedBook);
        }

        authorRepository.flush();
        bookRepository.flush();
    }

    @Test
    void insertAnotherBook() {
        Author savedAuthor = authorRepository.save(author);

        for (Book book : books) {
            Book savedBook = bookRepository.save(book);
            savedAuthor.addBook(savedBook);
        }
        authorRepository.flush();
        bookRepository.flush();

        Book anotherBook = bookRepository.save(new Book());
        savedAuthor.addBook(anotherBook);

        authorRepository.flush();
        bookRepository.flush();
    }

    @Test
    void deleteLastBook() {
        Author savedAuthor = authorRepository.save(author);

        for (Book book : books) {
            Book savedBook = bookRepository.save(book);
            savedAuthor.addBook(savedBook);
        }
        authorRepository.flush();
        bookRepository.flush();

        List<Book> authorBooks = savedAuthor.getBooks();
        authorBooks.remove(authorBooks.size() - 1);

        authorRepository.flush();
        bookRepository.flush();
    }
}
