package com.javamaster.spring_crud.entity;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;



@Entity
@Table(name = "movies_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column
    private String category;

    @Column
    private String mainCharacter;

    @Column
    private String description;

    @Column
    private String releaseDate;

    @Column
    private BigDecimal price;



}
