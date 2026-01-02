package com.global.book.base;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {

//    @Transactional
//    @Modifying
//    @Query(value = "update #{#entityName} t set t.setStatusCode= :statusCode Where t.id=:id")
//    T updateEntity(@Param("id") ID id, @Param("statusCode") String statusCode);
}
