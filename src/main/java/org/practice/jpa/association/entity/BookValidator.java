package org.practice.jpa.association.entity;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public final class BookValidator implements ConstraintValidator<OneOfAssociation, Book> {
    @Override
    public boolean isValid(Book book, ConstraintValidatorContext constraintValidatorContext) {
        return book.getAuthor() == null || book.getPublisher() == null;
    }
}
