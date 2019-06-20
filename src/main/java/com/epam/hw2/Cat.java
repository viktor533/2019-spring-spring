package com.epam.hw2;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder=true)
class Cat {
    private long id;
    private String name;
    private String description;
    private int years;
}
