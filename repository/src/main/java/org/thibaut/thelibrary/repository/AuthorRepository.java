package org.thibaut.thelibrary.repository;

import org.thibaut.thelibrary.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository< Author, Integer >, QuerydslPredicateExecutor<Author> {
}
