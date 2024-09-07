package it.uniecampus.lfulgione.tastetracking.ttbe.login.dto;

import lombok.Data;

@Data
public class ProductUpdateDTO {
    private ProductDTO old;
    private ProductDTO updated;
}
