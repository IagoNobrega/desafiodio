package com.examplede.desafiodio.controller;

import com.examplede.desafiodio.dto.BeerDTO;
import com.examplede.desafiodio.dto.QuantityDTO;
import com.examplede.desafiodio.exception.BeerAlreadyRegisteredException;
import com.examplede.desafiodio.exception.BeerNotFoundException;
import com.examplede.desafiodio.exception.BeerStockExceededException;
import com.examplede.desafiodio.service.BeerService;
import com.examplede.desafiodio.dto.QuantityDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/beers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class zBeerController {

    private final BeerService beerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BeerDTO createBeer(@RequestBody @Valid BeerDTO beerDTO) throws BeerAlreadyRegisteredException {
        return beerService.createBeer(beerDTO);
    }

    @GetMapping("/{name}")
    public BeerDTO findByName(@PathVariable String name) throws BeerNotFoundException {
        return beerService.findByName(name);
    }

    @GetMapping
    public List<BeerDTO> listBeers() {
        return beerService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws BeerNotFoundException {
        beerService.deleteById(id);
    }

    @PatchMapping("/{id}/increment")
    public BeerDTO increment(@PathVariable Long id, @RequestBody @Valid QuantityDTO quantityDTO)
            throws BeerNotFoundException, BeerStockExceededException {
        return beerService.increment(id, quantityDTO);
    }

    @PatchMapping("/{id}/decrement")
    public BeerDTO decrement(@PathVariable Long id, @RequestBody @Valid QuantityDTO quantityDTO)
            throws BeerNotFoundException, BeerStockExceededException {
        return beerService.decrement(id, quantityDTO);
    }
}