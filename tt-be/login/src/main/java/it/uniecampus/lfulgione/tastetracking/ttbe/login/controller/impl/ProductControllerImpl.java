package it.uniecampus.lfulgione.tastetracking.ttbe.login.controller.impl;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.controller.ProductController;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ProductControllerImpl implements ProductController {
    @Override
    public ResponseEntity<Void> create(Object product) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> search(String name, Integer type) {
        return null;
    }
}
