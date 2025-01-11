package org.practice.jpa.association;

import org.junit.jupiter.api.Test;
import org.practice.jpa.association.entity.Author;
import org.practice.jpa.association.entity.AuthorRepository;
import org.practice.jpa.association.entity.Book;
import org.practice.jpa.association.entity.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@DataJpaTest
class JpaTest {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    Author author = new Author();

    List<Book> books = Arrays.asList(
            new Book(null, null, new BigDecimal(100), null),
            new Book(null, null, new BigDecimal(10), null),
            new Book(null, null, new BigDecimal(1000), null));

    @Test
    void selectBook() {
        Author savedAuthor = authorRepository.save(author);

        for (Book book : books) {
            Book savedBook = bookRepository.save(book);
            savedAuthor.addBook(savedBook);
        }

        authorRepository.flush();
        bookRepository.flush();

        List<Book> cheaperThan100 = savedAuthor.getCheaperThan100();
        for(Book book : cheaperThan100){
            System.out.println("book = " + book);
        }
    }
}
