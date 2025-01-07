package org.practice.jpa.association.bidirectionalontomany.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
