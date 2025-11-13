package com.examplede.desafiodio.dto;

import com.examplede.desafiodio.entity.Beer.BeerType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeerDTO {
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 100)
    private String brand;

    @NotNull
    @Max(500)
    @Min(0)
    private Integer max;

    @NotNull
    @Max(500)
    @Min(0)
    private Integer quantity;

    @NotNull
    private BeerType type;
}