package org.practice.jpa.association.entity;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Override
    @EntityGraph(value = "author-books-graph",
        type = EntityGraph.EntityGraphType.FETCH)
    List<Author> findAll();
}
