package org.practice.jpa.association;

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
class JpaTest {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    Author author = new Author();

    List<Book> books = Arrays.asList(new Book(), new Book(), new Book());

    @Test
    void selectBook() {
        Author savedAuthor = authorRepository.save(author);

        for (Book book : books) {
            Book savedBook = bookRepository.save(book);
            savedAuthor.addBook(savedBook);
        }

        authorRepository.flush();
        bookRepository.flush();

        authorRepository.findAll();
    }
}
