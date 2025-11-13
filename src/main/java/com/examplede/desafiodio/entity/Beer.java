package com.examplede.desafiodio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Size(max = 100)
    private String name;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 100)
    private String brand;

    @Column(nullable = false)
    @Max(500)
    @Min(0)
    private Integer max;

    @Column(nullable = false)
    @Max(500)
    @Min(0)
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BeerType type;

    public enum BeerType {
        LAGER, PILSEN, IPA, WEISS, STOUT
    }
}