package it.uniecampus.lfulgione.tastetracking.ttbe.login.service;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductDTO;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface ProductService {
    void create(
            @NotNull ProductDTO productDTO);
    List<ProductDTO> search(
            @Nullable String name,
            @Nullable Integer type);
}
