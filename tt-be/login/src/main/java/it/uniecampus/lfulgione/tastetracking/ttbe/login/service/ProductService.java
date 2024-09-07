package it.uniecampus.lfulgione.tastetracking.ttbe.login.service;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductUpdateDTO;
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
    void update(
            @NotNull ProductUpdateDTO productUpdateDTO);
}
