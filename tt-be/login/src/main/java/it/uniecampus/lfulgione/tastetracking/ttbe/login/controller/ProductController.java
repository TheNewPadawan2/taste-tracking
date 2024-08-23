package it.uniecampus.lfulgione.tastetracking.ttbe.login.controller;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductDTO;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/product")
public interface ProductController {

    @PostMapping(path = "/create")
    ResponseEntity<Void> create(
            @RequestBody @NotNull ProductDTO product);

    @GetMapping
    ResponseEntity<List<ProductDTO>> search(
            @RequestParam(name = "name", required = false) @Nullable String name,
            @RequestParam(name = "type", required = false) @Nullable Integer type);
}