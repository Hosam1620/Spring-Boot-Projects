package com.global.book.repository;

import com.global.book.base.BaseRepository;
import com.global.book.entity.Book;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends BaseRepository<Book, Long> {

    @Override
    @NullMarked
    @EntityGraph(attributePaths = "author")
    List<Book> findAll();
}
