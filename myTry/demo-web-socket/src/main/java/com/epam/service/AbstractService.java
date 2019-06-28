package com.epam.service;

import com.epam.dao.Repository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService<T, ID> implements Service<T, ID> {

    private final Repository<T, ID> repository;

    @Autowired
    public AbstractService(Repository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T create(T t) {
        return repository.save(t);
    }

    @Override
    public T get(ID id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Iterable<T> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}
