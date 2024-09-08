package it.uniecampus.lfulgione.tastetracking.ttbe.login.service;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductUpdateDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.exception.ProductNotFoundException;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface ProductService {
    void create(
            @NotNull ProductDTO productDTO);
    @NotNull
    List<ProductDTO> search(
            @Nullable String name,
            @Nullable Integer type);
    ProductDTO update(
            @NotNull ProductUpdateDTO productUpdateDTO)
            throws ProductNotFoundException;

    void logicalDelete(
            @NotNull String name)
            throws ProductNotFoundException;
}
