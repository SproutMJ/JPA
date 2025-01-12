package org.practice.jpa.association;

import org.junit.jupiter.api.Test;
import org.practice.jpa.association.entity.Author;
import org.practice.jpa.association.entity.AuthorRepository;
import org.practice.jpa.association.entity.Book;
import org.practice.jpa.association.entity.BookRepository;
import org.practice.jpa.association.entity.Publisher;
import org.practice.jpa.association.entity.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

@DataJpaTest
class JpaTest {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PublisherRepository publisherRepository;

    Author author = new Author();

    Book book = new Book();

    Publisher publisher = new Publisher();

    @Test
    void selectBook() {
        Author savedAuthor = authorRepository.save(author);
        publisher = publisherRepository.save(publisher);
        book.setPrice(new BigDecimal(100));

        book.setAuthor(savedAuthor);
        book.setPublisher(publisher);

        Book savedBook = bookRepository.save(book);

        authorRepository.flush();
        bookRepository.flush();
    }
}
