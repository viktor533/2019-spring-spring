package com.epam.hw2;

public class CatService {
    public Cat getCatById(long id) {
        return Cat.builder().id(1).name("Musya").years(2).description("Very fast").build();
    }
}
