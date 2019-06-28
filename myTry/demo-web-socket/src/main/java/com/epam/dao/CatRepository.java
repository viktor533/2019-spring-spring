package com.epam.dao;

import com.epam.domain.Cat;

@org.springframework.stereotype.Repository
public interface CatRepository extends Repository<Cat, Long> {
}
