package com.epam.service;

import com.epam.dao.CatRepository;
import com.epam.domain.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatService extends AbstractService<Cat, Long>{

    @Autowired
    public CatService(CatRepository repository) {
        super(repository);
    }
}
