package org.thibaut.thelibrary.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.domain.entity.Author;
import org.thibaut.thelibrary.domain.entity.Book;
import org.thibaut.thelibrary.domain.entity.Category;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository< Book, Integer >, QuerydslPredicateExecutor<Book> {

	public List<Book> getBooksByTitleContainsAndAuthorsContainsAndCategoriesContains( String title, List< Author > authors, Category style );
}
