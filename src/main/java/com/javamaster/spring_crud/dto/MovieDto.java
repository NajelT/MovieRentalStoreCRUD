package com.javamaster.spring_crud.dto;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class MovieDto {

    private Integer id;
    private String title;
    private String category;
    private String mainCharacter;
    private String description;
    private String releaseDate;
    private BigDecimal price;

}
