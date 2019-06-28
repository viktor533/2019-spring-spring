package com.epam.service;

public interface Service<T, ID> {
    T create (T t);

    T get(ID id);

    Iterable<T> getAll();

    void delete(ID id);
}
