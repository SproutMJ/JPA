package org.practice.jpa.association;

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

    Author author = new Author();

    Book book = new Book();

    @Test
    void selectBook() {
        Author savedAuthor = authorRepository.save(author);
        Book savedBook = bookRepository.save(book);

        authorRepository.flush();
        bookRepository.flush();
    }
}
