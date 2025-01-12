package org.practice.jpa.association;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.practice.jpa.association.entity.Author;
import org.practice.jpa.association.entity.AuthorRepository;
import org.practice.jpa.association.entity.Book;
import org.practice.jpa.association.entity.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class JpaTest {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    EntityManager entityManager;

    Author author;

    @Transactional
    @BeforeEach
    void setUp() {
        author = new Author(null, "John Doe");
        author = authorRepository.save(author);
        authorRepository.flush();
    }

    @Test
    void proxy() {
        authorRepository.getReferenceById(author.getId());

        Book book = new Book(null, author);

        book = bookRepository.save(book);

        authorRepository.flush();
        bookRepository.flush();
    }

    @Test
    void object() {
        authorRepository.findById(author.getId());

        Book book = new Book(null, author);

        book = bookRepository.save(book);

        authorRepository.flush();
        bookRepository.flush();
    }
}
