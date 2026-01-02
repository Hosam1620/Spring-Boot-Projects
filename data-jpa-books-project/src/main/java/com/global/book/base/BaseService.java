package com.global.book.base;

import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public abstract class BaseService<T extends BaseEntity<ID>, ID> {

    private final BaseRepository<T, ID> baseRepository;

    public BaseService(BaseRepository<T, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    public T findById(ID id) {
        return baseRepository.findById(id).orElseThrow();
    }

    public Iterable<T> findAll() {
        return baseRepository.findAll();
    }
    @Transactional
    public T insert(T entity) {
        return baseRepository.save(entity);
    }
    @Transactional
    public void delete(ID id) {
        baseRepository.deleteById(id);
    }
    @Transactional
    public T updateName(T entity) {
        return baseRepository.save(entity);
    }


}
