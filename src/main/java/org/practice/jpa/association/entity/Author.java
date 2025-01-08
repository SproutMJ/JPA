package org.practice.jpa.association.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public final class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    public void addBook(final Book book) {
        books.add(book);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Author author)) return false;
        return Objects.equals(id, author.id) && Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, books);
    }
}
